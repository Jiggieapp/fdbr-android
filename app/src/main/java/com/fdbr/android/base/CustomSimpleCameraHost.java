package com.fdbr.android.base;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.Surface;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraUtils;
import com.commonsware.cwac.camera.DeviceProfile;
import com.commonsware.cwac.camera.PictureTransaction;
import com.fdbr.android.utils.Utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomSimpleCameraHost implements CameraHost {
    private static final String[] SCAN_TYPES = new String[]{"image/jpeg"};
    private Context ctxt = null;
    private int cameraId = -1;
    private DeviceProfile profile = null;
    private File photoDirectory = null;
    private File videoDirectory = null;
    private RecordingHint recordingHint = null;
    private boolean mirrorFFC = false;
    public boolean useFrontFacingCamera = false;
    private boolean scanSavedImage = true;
    private boolean useFullBleedPreview = true;
    private boolean useSingleShotMode = false;

    public CustomSimpleCameraHost(Context _ctxt) {
        this.ctxt = _ctxt.getApplicationContext();
    }

    public Camera.Parameters adjustPictureParameters(PictureTransaction xact, Camera.Parameters parameters) {
        return parameters;
    }

    public Camera.Parameters adjustPreviewParameters(Camera.Parameters parameters) {
        return parameters;
    }

    public void configureRecorderAudio(int cameraId, MediaRecorder recorder) {
        recorder.setAudioSource(5);
    }

    public void configureRecorderOutput(int cameraId, MediaRecorder recorder) {
        recorder.setOutputFile(this.getVideoPath().getAbsolutePath());
    }

    @TargetApi(11)
    public void configureRecorderProfile(int cameraId, MediaRecorder recorder) {
        if(Build.VERSION.SDK_INT >= 11 && !CamcorderProfile.hasProfile(cameraId, 1)) {
            if(Build.VERSION.SDK_INT < 11 || !CamcorderProfile.hasProfile(cameraId, 0)) {
                throw new IllegalStateException("cannot find valid CamcorderProfile");
            }

            recorder.setProfile(CamcorderProfile.get(cameraId, 0));
        } else {
            recorder.setProfile(CamcorderProfile.get(cameraId, 1));
        }

    }

    public int getCameraId() {
        if(this.cameraId == -1) {
            this.initCameraId(Camera.CameraInfo.CAMERA_FACING_BACK);
        }

        return this.cameraId;
    }

    public void initCameraId(int facing) {
        int count = Camera.getNumberOfCameras();
        int result = -1;
        /*if(count > 0) {
            result = 0;
            Camera.CameraInfo info = new Camera.CameraInfo();

            for(int i = 0; i < count; ++i) {
                Camera.getCameraInfo(i, info);
                if(info.facing == 0 && !this.useFrontFacingCamera()) {
                    result = i;
                    break;
                }

                if(info.facing == 1 && this.useFrontFacingCamera()) {
                    result = i;
                    break;
                }

            }
        }*/

        this.cameraId = facing;
    }

    public void initCameraId() {
        int count = Camera.getNumberOfCameras();
        int result = -1;
        if(count > 0) {
            result = 0;
            Camera.CameraInfo info = new Camera.CameraInfo();
            for(int i = 0; i < count; ++i) {
                Camera.getCameraInfo(i, info);
                if(info.facing == 0 && !this.useFrontFacingCamera()) {
                    result = i;
                    break;
                }

                if(info.facing == 1 && this.useFrontFacingCamera()) {
                    result = i;
                    break;
                }
            }
        }

        this.cameraId = result;
    }

    public DeviceProfile getDeviceProfile() {
        if(this.profile == null) {
            this.initDeviceProfile(this.ctxt);
        }

        return this.profile;
    }

    private void initDeviceProfile(Context ctxt) {
        this.profile = DeviceProfile.getInstance(ctxt);
    }

    public Camera.Size getPictureSize(PictureTransaction xact, Camera.Parameters parameters) {
        return CameraUtils.getLargestPictureSize(this, parameters);
    }

    public Camera.Size getPreviewSize(int displayOrientation, int width, int height, Camera.Parameters parameters) {
        return CameraUtils.getBestAspectPreviewSize(displayOrientation, width, height, parameters);
    }

    @TargetApi(11)
    public Camera.Size getPreferredPreviewSizeForVideo(int displayOrientation, int width, int height, Camera.Parameters parameters, Camera.Size deviceHint) {
        return deviceHint != null?deviceHint:(Build.VERSION.SDK_INT >= 11?parameters.getPreferredPreviewSizeForVideo():null);
    }

    public Camera.ShutterCallback getShutterCallback() {
        return null;
    }

    public void handleException(Exception e) {
        Log.e(this.getClass().getSimpleName(), "Exception in setPreviewDisplay()", e);
    }

    public boolean mirrorFFC() {
        return this.mirrorFFC;
    }

    public void saveImage(PictureTransaction xact, Bitmap bitmap) {
    }

    public void saveImage(PictureTransaction xact, byte[] image) {
        File photo = this.getPhotoPath();
        if(photo.exists()) {
            photo.delete();
        }

        try {
            FileOutputStream e = new FileOutputStream(photo.getPath());
            BufferedOutputStream bos = new BufferedOutputStream(e);
            bos.write(image);
            bos.flush();
            e.getFD().sync();
            bos.close();
            if(this.scanSavedImage()) {
                MediaScannerConnection.scanFile(this.ctxt, new String[]{photo.getPath()}, SCAN_TYPES, (MediaScannerConnection.OnScanCompletedListener)null);
            }
        } catch (IOException var6) {
            this.handleException(var6);
        }

    }

    @TargetApi(16)
    public void onAutoFocus(boolean success, Camera camera) {
        if(success && Build.VERSION.SDK_INT >= 16) {
            (new MediaActionSound()).play(1);
        }

    }

    public boolean useSingleShotMode() {
        return this.useSingleShotMode;
    }

    public void autoFocusAvailable() {
    }

    public void autoFocusUnavailable() {
    }

    public RecordingHint getRecordingHint() {
        if(this.recordingHint == null) {
            this.initRecordingHint();
        }

        return this.recordingHint;
    }

    private void initRecordingHint() {
        this.recordingHint = this.profile.getDefaultRecordingHint();
        if(this.recordingHint == RecordingHint.NONE) {
            this.recordingHint = RecordingHint.ANY;
        }

    }

    public void onCameraFail(FailureReason reason) {
        //Log.e("CWAC-Camera", String.format("Camera access failed: %d", new Object[]{Integer.valueOf(reason.value)}));
    }

    public boolean useFullBleedPreview() {
        return this.useFullBleedPreview;
    }

    public float maxPictureCleanupHeapUsage() {
        return 1.0F;
    }

    protected File getPhotoPath() {
        File dir = this.getPhotoDirectory();
        dir.mkdirs();
        return new File(dir, this.getPhotoFilename());
    }

    protected File getPhotoDirectory() {
        if(this.photoDirectory == null) {
            this.initPhotoDirectory();
        }

        return this.photoDirectory;
    }

    private void initPhotoDirectory() {
        this.photoDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    }

    protected String getPhotoFilename() {
        String ts = (new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)).format(new Date());
        return "Photo_" + ts + ".jpg";
    }

    protected File getVideoPath() {
        File dir = this.getVideoDirectory();
        dir.mkdirs();
        return new File(dir, this.getVideoFilename());
    }

    protected File getVideoDirectory() {
        if(this.videoDirectory == null) {
            this.initVideoDirectory();
        }

        return this.videoDirectory;
    }

    private void initVideoDirectory() {
        this.videoDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
    }

    protected String getVideoFilename() {
        String ts = (new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)).format(new Date());
        return "Video_" + ts + ".mp4";
    }

    protected boolean useFrontFacingCamera() {
        return this.useFrontFacingCamera;
    }

    protected boolean scanSavedImage() {
        return this.scanSavedImage;
    }

    public static class Builder {
        private CustomSimpleCameraHost host;

        public Builder(Context ctxt) {
            this(new CustomSimpleCameraHost(ctxt));
        }

        public Builder(CustomSimpleCameraHost host) {
            this.host = null;
            this.host = host;
        }

        public CustomSimpleCameraHost build() {
            return this.host;
        }

        public CustomSimpleCameraHost.Builder cameraId(int cameraId) {
            this.host.cameraId = cameraId;
            return this;
        }

        public CustomSimpleCameraHost.Builder deviceProfile(DeviceProfile profile) {
            this.host.profile = profile;
            return this;
        }

        public CustomSimpleCameraHost.Builder mirrorFFC(boolean mirrorFFC) {
            this.host.mirrorFFC = mirrorFFC;
            return this;
        }

        public CustomSimpleCameraHost.Builder photoDirectory(File photoDirectory) {
            this.host.photoDirectory = photoDirectory;
            return this;
        }

        public CustomSimpleCameraHost.Builder recordingHint(RecordingHint recordingHint) {
            this.host.recordingHint = recordingHint;
            return this;
        }

        public CustomSimpleCameraHost.Builder scanSavedImage(boolean scanSavedImage) {
            this.host.scanSavedImage = scanSavedImage;
            return this;
        }

        public CustomSimpleCameraHost.Builder useFrontFacingCamera(boolean useFrontFacingCamera) {
            this.host.useFrontFacingCamera = useFrontFacingCamera;
            return this;
        }

        public CustomSimpleCameraHost.Builder useFullBleedPreview(boolean useFullBleedPreview) {
            this.host.useFullBleedPreview = useFullBleedPreview;
            return this;
        }

        public CustomSimpleCameraHost.Builder useSingleShotMode(boolean useSingleShotMode) {
            this.host.useSingleShotMode = useSingleShotMode;
            return this;
        }

        public CustomSimpleCameraHost.Builder videoDirectory(File videoDirectory) {
            this.host.videoDirectory = videoDirectory;
            return this;
        }
    }

    public static void setCameraDisplayOrientation(Activity activity,
                                                   int cameraId, android.hardware.Camera camera) {
        android.hardware.Camera.CameraInfo info =
                new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 180;
        switch (rotation) {
            case Surface.ROTATION_0: degrees = 0; break;
            case Surface.ROTATION_90: degrees = 90; break;
            case Surface.ROTATION_180: degrees = 180; break;
            case Surface.ROTATION_270: degrees = 270; break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }
}

