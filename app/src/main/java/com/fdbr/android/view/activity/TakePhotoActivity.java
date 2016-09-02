package com.fdbr.android.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraHostProvider;
import com.commonsware.cwac.camera.CameraView;
import com.commonsware.cwac.camera.PictureTransaction;
import com.commonsware.cwac.camera.SimpleCameraHost;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.base.CustomSimpleCameraHost;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.custom.RevealBackgroundView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wandywijayanto on 8/31/16.
 */
public class TakePhotoActivity extends BaseActivity implements RevealBackgroundView.OnStateChangeListener,
        CameraHostProvider {

    public static final String ARG_REVEAL_START_LOCATION = "reveal_start_location";
    private static final Interpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final int STATE_TAKE_PHOTO = 0;
    private static final int STATE_SETUP_PHOTO = 1;
    private int currentState;
    private boolean pendingIntro;
    private int facing = Camera.CameraInfo.CAMERA_FACING_BACK;
    private final int PICK_IMAGE_REQUEST = 1;
    private final int PICK_IMAGE_KITKAT_REQUEST = 2;
    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 28;
    private final String TAG = TakePhotoActivity.class.getSimpleName();
    private String selectedImagePath;

    @BindView(R.id.vRevealBackground)
    RevealBackgroundView vRevealBackground;
    @BindView(R.id.vPhotoRoot)
    View vTakePhotoRoot;
    @BindView(R.id.vShutter)
    View vShutter;
    @BindView(R.id.ivTakenPhoto)
    ImageView ivTakenPhoto;
    @BindView(R.id.vUpperPanel)
    ViewSwitcher vUpperPanel;
    @BindView(R.id.vLowerPanel)
    ViewSwitcher vLowerPanel;
    @BindView(R.id.cameraView)
    CameraView cameraView;
    @BindView(R.id.rvFilters)
    RecyclerView rvFilters;
    @BindView(R.id.btnTakePhoto)
    Button btnTakePhoto;
    @BindView(R.id.btn_switch_camera)
    ImageButton btnSwitchCamera;
    @BindView(R.id.btn_open_gallery)
    ImageButton btnOpenGallery;
    @BindView(R.id.btn_accept)
    ImageButton btnAccept;
    @BindView(R.id.relative_camera_container)
    RelativeLayout cameraContainer;

    @Override
    protected void onCreate() {
        updateStatusBarColor();
        updateState(STATE_TAKE_PHOTO);
        setupRevealBackground(null);
        //setupPhotoFilters();

        vLowerPanel.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                vLowerPanel.getViewTreeObserver().removeOnPreDrawListener(this);
                pendingIntro = true;
                vUpperPanel.setTranslationY(-vUpperPanel.getHeight());
                vLowerPanel.setTranslationY(vLowerPanel.getHeight());
                return true;
            }
        });
    }

    @Override
    public int getContentView() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        return R.layout.activity_take_photo;
    }

    @Override
    public CameraHost getCameraHost() {
        return new MyCameraHost(this);
    }

    @Override
    public void onStateChange(int state) {
        if (RevealBackgroundView.STATE_FINISHED == state) {
            vTakePhotoRoot.setVisibility(View.VISIBLE);
            if (pendingIntro) {
                startIntroAnimation();
            }
        } else {
            vTakePhotoRoot.setVisibility(View.INVISIBLE);
        }
    }

    class MyCameraHost extends CustomSimpleCameraHost {

        private Camera.Size previewSize;

        public MyCameraHost(Context ctxt) {
            super(ctxt);
        }

        @Override
        public boolean useFullBleedPreview() {
            return true;
        }

        @Override
        public Camera.Size getPictureSize(PictureTransaction xact, Camera.Parameters parameters) {
            return previewSize;
        }

        @Override
        public Camera.Parameters adjustPreviewParameters(Camera.Parameters parameters) {
            Camera.Parameters parameters1 = super.adjustPreviewParameters(parameters);
            previewSize = parameters1.getPreviewSize();
            return parameters1;
        }

        @Override
        public void saveImage(PictureTransaction xact, final Bitmap bitmap) {
            /*runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showTakenPicture(bitmap);
                }
            });*/
        }

        @Override
        public void saveImage(PictureTransaction xact, byte[] image) {
            super.saveImage(xact, image);
            //photoPath = getPhotoPath();
        }
    }

    private void setupRevealBackground(Bundle savedInstanceState) {
        vRevealBackground.setFillPaintColor(0xFF16181a);
        vRevealBackground.setOnStateChangeListener(this);
        if (savedInstanceState == null) {
            final int[] startingLocation = getIntent().getIntArrayExtra(ARG_REVEAL_START_LOCATION);
            vRevealBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    vRevealBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                    vRevealBackground.startFromLocation(startingLocation);
                    return true;
                }
            });
        } else {
            vRevealBackground.setToFinishedFrame();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void updateStatusBarColor() {
        if (Utils.isAndroid5()) {
            getWindow().setStatusBarColor(0xff111111);
        }
    }

    private void updateState(int state) {
        currentState = state;
        if (currentState == STATE_TAKE_PHOTO) {
            vUpperPanel.setInAnimation(this, R.anim.slide_in_from_right);
            //vLowerPanel.setInAnimation(this, R.anim.slide_in_from_right);
            vUpperPanel.setOutAnimation(this, R.anim.slide_out_to_left);
            //vLowerPanel.setOutAnimation(this, R.anim.slide_out_to_left);
            cameraContainer.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivTakenPhoto.setVisibility(View.GONE);
                }
            }, 400);
        } else if (currentState == STATE_SETUP_PHOTO) {
            vUpperPanel.setInAnimation(this, R.anim.slide_in_from_left);
            //vLowerPanel.setInAnimation(this, R.anim.slide_in_from_left);
            vUpperPanel.setOutAnimation(this, R.anim.slide_out_to_right);
            //vLowerPanel.setOutAnimation(this, R.anim.slide_out_to_right);
            cameraContainer.setVisibility(View.GONE);
            ivTakenPhoto.setVisibility(View.VISIBLE);
        }
    }

    /*private void setupPhotoFilters() {
        PhotoFiltersAdapter photoFiltersAdapter = new PhotoFiltersAdapter(this);
        rvFilters.setHasFixedSize(true);
        rvFilters.setAdapter(photoFiltersAdapter);
        rvFilters.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }*/

    public static void startCameraFromLocation(int[] startingLocation, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, TakePhotoActivity.class);
        intent.putExtra(ARG_REVEAL_START_LOCATION, startingLocation);
        startingActivity.startActivity(intent);
    }

    private void startIntroAnimation() {
        vUpperPanel.animate().translationY(0).setDuration(400).setInterpolator(DECELERATE_INTERPOLATOR);
        vLowerPanel.animate().translationY(0).setDuration(400).setInterpolator(DECELERATE_INTERPOLATOR).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.onPause();
    }

    @OnClick(R.id.btn_switch_camera)
    public void onSwitchCameraClick() {
        /*if(((CustomSimpleCameraHost)cameraView.getHost()).useFrontFacingCamera == false)
            ((CustomSimpleCameraHost)cameraView.getHost()).useFrontFacingCamera = true;
        else ((CustomSimpleCameraHost)cameraView.getHost()).useFrontFacingCamera = false;*/

        if (facing == Camera.CameraInfo.CAMERA_FACING_FRONT)
            facing = Camera.CameraInfo.CAMERA_FACING_BACK;
        else facing = Camera.CameraInfo.CAMERA_FACING_FRONT;
        ((CustomSimpleCameraHost) cameraView.getHost()).initCameraId(facing);
        cameraView.onPause();
        cameraView.onResume();
    }

    @OnClick(R.id.btn_open_gallery)
    public void openGallery() {
        if (Build.VERSION.SDK_INT < 19) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        } else if (Build.VERSION.SDK_INT >= 23) {
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_DENIED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }
        } else {
            startGalleryIntent();
        }
    }

    private void startGalleryIntent() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_KITKAT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && (requestCode == PICK_IMAGE_KITKAT_REQUEST || requestCode == PICK_IMAGE_REQUEST)) {
            if (data != null && data.getData() != null) {
                final Uri uri = data.getData();
                if (requestCode == PICK_IMAGE_REQUEST) {
                    //profilePresenter.onFinishTakePhoto(requestCode, uri, getContentResolver());
                } else if (requestCode == PICK_IMAGE_KITKAT_REQUEST) {
                    final int takeFlags = data.getFlags()
                            & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                            | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    try {
                        //cameraContainer.setVisibility(View.GONE);
                        String id = uri.getLastPathSegment().split(":")[1];
                        final String[] imageColumns = {MediaStore.Images.Media.DATA};
                        final String imageOrderBy = null;
                        Uri urii = getUri();
                        Cursor imageCursor = managedQuery(urii, imageColumns,
                                MediaStore.Images.Media._ID + "=" + id, null, imageOrderBy);
                        selectedImagePath = onFinishTakeKitkatPhoto(uri, takeFlags
                                , getContentResolver(), imageCursor);
                        Glide.with(TakePhotoActivity.this).load(selectedImagePath).asBitmap().into(ivTakenPhoto);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                vUpperPanel.showNext();
                                updateState(STATE_SETUP_PHOTO);
                                vLowerPanel.animate().translationY(vLowerPanel.getHeight()).setDuration(400).setInterpolator(DECELERATE_INTERPOLATOR).start();
                            }
                        }, 1000);
                    } catch (IndexOutOfBoundsException e) {
                        //Utils.d(TAG, "out of bound exception");
                    }
                }
            }
        }
    }

    // By using this method get the Uri of Internal/External Storage for Media
    public Uri getUri() {
        String state = Environment.getExternalStorageState();
        if (!state.equalsIgnoreCase(Environment.MEDIA_MOUNTED))
            return MediaStore.Images.Media.INTERNAL_CONTENT_URI;

        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String onFinishTakeKitkatPhoto(Uri uri
            , int takeFlags, ContentResolver contentResolver, Cursor imageCursor) {
        // Check for the freshest data.
        contentResolver.takePersistableUriPermission(uri, takeFlags);

        String selectedImagePath = null;
        if (imageCursor.moveToFirst()) {
            selectedImagePath = imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DATA));
        }
        return selectedImagePath;
    }

    @OnClick(R.id.btn_accept)
    public void onBtnAcceptClick() {
        Intent i = new Intent(this, PostTakePhotoActivity.class);
        i.putExtra("imagePath", selectedImagePath);
        startActivity(i);
    }

    @OnClick(R.id.btn_back)
    public void onBackClick() {
        vUpperPanel.showPrevious();
        //cameraContainer.setVisibility(View.VISIBLE);
        ivTakenPhoto.setVisibility(View.GONE);
        updateState(STATE_TAKE_PHOTO);
        vLowerPanel.animate().translationY(0).setDuration(400).setInterpolator(DECELERATE_INTERPOLATOR).start();
    }

    @Override
    public void onBackPressed() {
        if (currentState == STATE_SETUP_PHOTO) {
            onBackClick();

        } else super.onBackPressed();
    }
}
