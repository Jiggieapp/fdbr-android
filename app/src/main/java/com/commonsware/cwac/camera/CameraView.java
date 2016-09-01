//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;

import com.commonsware.cwac.camera.CameraHost.FailureReason;
import com.commonsware.cwac.camera.CameraHost.RecordingHint;

import java.io.IOException;

public class CameraView extends ViewGroup implements AutoFocusCallback {
    static final String TAG = "CWAC-Camera";
    private PreviewStrategy previewStrategy;
    private Size previewSize;
    public Camera camera;
    private boolean inPreview;
    private CameraHost host;
    private CameraView.OnOrientationChange onOrientationChange;
    private int displayOrientation;
    private int outputOrientation;
    private int cameraId;
    private MediaRecorder recorder;
    private Parameters previewParams;
    private boolean isDetectingFaces;
    private boolean isAutoFocusing;
    private int lastPictureOrientation;

    public CameraView(Context context) {
        super(context);
        this.camera = null;
        this.inPreview = false;
        this.host = null;
        this.onOrientationChange = null;
        this.displayOrientation = -1;
        this.outputOrientation = -1;
        this.cameraId = -1;
        this.recorder = null;
        this.previewParams = null;
        this.isDetectingFaces = false;
        this.isAutoFocusing = false;
        this.lastPictureOrientation = -1;
        this.onOrientationChange = new CameraView.OnOrientationChange(context.getApplicationContext());
    }

    public CameraView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.camera = null;
        this.inPreview = false;
        this.host = null;
        this.onOrientationChange = null;
        this.displayOrientation = -1;
        this.outputOrientation = -1;
        this.cameraId = -1;
        this.recorder = null;
        this.previewParams = null;
        this.isDetectingFaces = false;
        this.isAutoFocusing = false;
        this.lastPictureOrientation = -1;
        this.onOrientationChange = new CameraView.OnOrientationChange(context.getApplicationContext());
        if(context instanceof CameraHostProvider) {
            this.setHost(((CameraHostProvider)context).getCameraHost());
        } else {
            throw new IllegalArgumentException("To use the two- or three-parameter constructors on CameraView, your activity needs to implement the CameraHostProvider interface");
        }
    }

    public CameraHost getHost() {
        return this.host;
    }

    public void setHost(CameraHost host) {
        this.host = host;
        if(host.getDeviceProfile().useTextureView()) {
            this.previewStrategy = new TexturePreviewStrategy(this);
        } else {
            this.previewStrategy = new SurfacePreviewStrategy(this);
        }

    }

    @TargetApi(14)
    public void onResume() {
        this.addView(this.previewStrategy.getWidget());
        if(this.camera == null) {
            try {
                this.cameraId = this.getHost().getCameraId();
                if(this.cameraId >= 0) {
                    this.camera = Camera.open(this.cameraId);
                    if(this.getActivity().getRequestedOrientation() != -1) {
                        this.onOrientationChange.enable();
                    }

                    this.setCameraDisplayOrientation();
                    if(VERSION.SDK_INT >= 14 && this.getHost() instanceof FaceDetectionListener) {
                        this.camera.setFaceDetectionListener((FaceDetectionListener)this.getHost());
                    }
                } else {
                    this.getHost().onCameraFail(FailureReason.NO_CAMERAS_REPORTED);
                }
            } catch (Exception var2) {
                this.getHost().onCameraFail(FailureReason.UNKNOWN);
            }
        }
        //measure(this.getMeasuredWidth(), this.getMeasuredHeight());

    }

    public void onPause() {
        if(this.camera != null) {
            this.previewDestroyed();
        }

        this.removeView(this.previewStrategy.getWidget());
        this.onOrientationChange.disable();
        this.lastPictureOrientation = -1;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = resolveSize(this.getSuggestedMinimumWidth(), widthMeasureSpec);
        int height = resolveSize(this.getSuggestedMinimumHeight(), heightMeasureSpec);
        this.setMeasuredDimension(width, height);
        if(width > 0 && height > 0 && this.camera != null) {
            Size newSize = null;

            try {
                if(this.getHost().getRecordingHint() != RecordingHint.STILL_ONLY) {
                    newSize = this.getHost().getPreferredPreviewSizeForVideo(this.getDisplayOrientation(), width, height, this.camera.getParameters(), (Size)null);
                }

                if(newSize == null || newSize.width * newSize.height < 65536) {
                    newSize = this.getHost().getPreviewSize(this.getDisplayOrientation(), width, height, this.camera.getParameters());
                }
            } catch (Exception var7) {
                Log.e(this.getClass().getSimpleName(), "Could not work with camera parameters?", var7);
            }

            if(newSize != null) {
                if(this.previewSize == null) {
                    this.previewSize = newSize;
                } else if(this.previewSize.width != newSize.width || this.previewSize.height != newSize.height) {
                    if(this.inPreview) {
                        this.stopPreview();
                    }

                    this.previewSize = newSize;
                    this.initPreview(width, height, false);
                }
            }
        }

    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed && this.getChildCount() > 0) {
            View child = this.getChildAt(0);
            int width = r - l;
            int height = b - t;
            int previewWidth = width;
            int previewHeight = height;
            if(this.previewSize != null) {
                if(this.getDisplayOrientation() != 90 && this.getDisplayOrientation() != 270) {
                    previewWidth = this.previewSize.width;
                    previewHeight = this.previewSize.height;
                } else {
                    previewWidth = this.previewSize.height;
                    previewHeight = this.previewSize.width;
                }
            }

            boolean useFirstStrategy = width * previewHeight > height * previewWidth;
            boolean useFullBleed = this.getHost().useFullBleedPreview();
            int scaledChildHeight;
            if(useFirstStrategy && !useFullBleed || !useFirstStrategy && useFullBleed) {
                scaledChildHeight = previewWidth * height / previewHeight;
                child.layout((width - scaledChildHeight) / 2, 0, (width + scaledChildHeight) / 2, height);
            } else {
                scaledChildHeight = previewHeight * width / previewWidth;
                child.layout(0, (height - scaledChildHeight) / 2, width, (height + scaledChildHeight) / 2);
            }
        }

    }

    public int getDisplayOrientation() {
        return this.displayOrientation;
    }

    public void lockToLandscape(boolean enable) {
        if(enable) {
            this.getActivity().setRequestedOrientation(6);
            this.onOrientationChange.enable();
        } else {
            this.getActivity().setRequestedOrientation(-1);
            this.onOrientationChange.disable();
        }

    }

    public void restartPreview() {
        if(!this.inPreview) {
            this.startPreview();
        }

    }

    public void takePicture(boolean needBitmap, boolean needByteArray) {
        PictureTransaction xact = new PictureTransaction(this.getHost());
        this.takePicture(xact.needBitmap(needBitmap).needByteArray(needByteArray));
    }

    public void takePicture(final PictureTransaction xact) {
        if(this.inPreview) {
            if(this.isAutoFocusing) {
                throw new IllegalStateException("Camera cannot take a picture while auto-focusing");
            } else {
                this.previewParams = this.camera.getParameters();
                Parameters pictureParams = this.camera.getParameters();
                Size pictureSize = xact.host.getPictureSize(xact, pictureParams);
                pictureParams.setPictureSize(pictureSize.width, pictureSize.height);
                pictureParams.setPictureFormat(256);
                if(xact.flashMode != null) {
                    pictureParams.setFlashMode(xact.flashMode);
                }

                if(!this.onOrientationChange.isEnabled()) {
                    this.setCameraPictureOrientation(pictureParams);
                }

                this.camera.setParameters(xact.host.adjustPictureParameters(xact, pictureParams));
                xact.cameraView = this;
                this.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            CameraView.this.camera.takePicture(xact, (PictureCallback)null, CameraView.this.new PictureTransactionCallback(xact));
                        } catch (Exception var2) {
                            Log.e(this.getClass().getSimpleName(), "Exception taking a picture", var2);
                        }

                    }
                }, (long)xact.host.getDeviceProfile().getPictureDelay());
                this.inPreview = false;
            }
        } else {
            throw new IllegalStateException("Preview mode must have started before you can take a picture");
        }
    }

    public boolean isRecording() {
        return this.recorder != null;
    }

    public void record() throws Exception {
        if(VERSION.SDK_INT < 11) {
            throw new UnsupportedOperationException("Video recording supported only on API Level 11+");
        } else if(this.displayOrientation != 0 && this.displayOrientation != 180) {
            throw new UnsupportedOperationException("Video recording supported only in landscape");
        } else {
            Parameters pictureParams = this.camera.getParameters();
            this.setCameraPictureOrientation(pictureParams);
            this.camera.setParameters(pictureParams);
            this.stopPreview();
            this.camera.unlock();

            try {
                this.recorder = new MediaRecorder();
                this.recorder.setCamera(this.camera);
                this.getHost().configureRecorderAudio(this.cameraId, this.recorder);
                this.recorder.setVideoSource(1);
                this.getHost().configureRecorderProfile(this.cameraId, this.recorder);
                this.getHost().configureRecorderOutput(this.cameraId, this.recorder);
                this.recorder.setOrientationHint(this.outputOrientation);
                this.previewStrategy.attach(this.recorder);
                this.recorder.prepare();
                this.recorder.start();
            } catch (IOException var3) {
                this.recorder.release();
                this.recorder = null;
                throw var3;
            }
        }
    }

    public void stopRecording() throws IOException {
        if(VERSION.SDK_INT < 11) {
            throw new UnsupportedOperationException("Video recording supported only on API Level 11+");
        } else {
            MediaRecorder tempRecorder = this.recorder;
            this.recorder = null;
            tempRecorder.stop();
            tempRecorder.release();
            this.camera.reconnect();
            this.startPreview();
        }
    }

    public void autoFocus() {
        if(this.inPreview) {
            this.camera.autoFocus(this);
            this.isAutoFocusing = true;
        }

    }

    public void cancelAutoFocus() {
        this.camera.cancelAutoFocus();
    }

    public boolean isAutoFocusAvailable() {
        return this.inPreview;
    }

    public void onAutoFocus(boolean success, Camera camera) {
        this.isAutoFocusing = false;
        if(this.getHost() instanceof AutoFocusCallback) {
            this.getHost().onAutoFocus(success, camera);
        }

    }

    public String getFlashMode() {
        return this.camera.getParameters().getFlashMode();
    }

    public void setFlashMode(String mode) {
        if(this.camera != null) {
            Parameters params = this.camera.getParameters();
            params.setFlashMode(mode);
            this.camera.setParameters(params);
        }

    }

    public ZoomTransaction zoomTo(int level) {
        if(this.camera == null) {
            throw new IllegalStateException("Yes, we have no camera, we have no camera today");
        } else {
            Parameters params = this.camera.getParameters();
            if(level >= 0 && level <= params.getMaxZoom()) {
                return new ZoomTransaction(this.camera, level);
            } else {
                throw new IllegalArgumentException(String.format("Invalid zoom level: %d", new Object[]{Integer.valueOf(level)}));
            }
        }
    }

    @TargetApi(14)
    public void startFaceDetection() {
        if(VERSION.SDK_INT >= 14 && this.camera != null && !this.isDetectingFaces && this.camera.getParameters().getMaxNumDetectedFaces() > 0) {
            this.camera.startFaceDetection();
            this.isDetectingFaces = true;
        }

    }

    @TargetApi(14)
    public void stopFaceDetection() {
        if(VERSION.SDK_INT >= 14 && this.camera != null && this.isDetectingFaces) {
            try {
                this.camera.stopFaceDetection();
            } catch (Exception var2) {
                ;
            }

            this.isDetectingFaces = false;
        }

    }

    public boolean doesZoomReallyWork() {
        CameraInfo info = new CameraInfo();
        Camera.getCameraInfo(this.getHost().getCameraId(), info);
        return this.getHost().getDeviceProfile().doesZoomActuallyWork(info.facing == 1);
    }

    void previewCreated() {
        if(this.camera != null) {
            try {
                this.previewStrategy.attach(this.camera);
            } catch (IOException var2) {
                this.getHost().handleException(var2);
            }
        }

    }

    void previewDestroyed() {
        if(this.camera != null) {
            this.previewStopped();
            this.camera.release();
            this.camera = null;
        }

    }

    void previewReset(int width, int height) {
        this.previewStopped();
        this.initPreview(width, height);
    }

    private void previewStopped() {
        if(this.inPreview) {
            this.stopPreview();
        }

    }

    public void initPreview(int w, int h) {
        this.initPreview(w, h, true);
    }

    @TargetApi(14)
    public void initPreview(int w, int h, boolean firstRun) {
        if(this.camera != null) {
            Parameters parameters = this.camera.getParameters();
            parameters.setPreviewSize(this.previewSize.width, this.previewSize.height);
            if(VERSION.SDK_INT >= 14) {
                parameters.setRecordingHint(this.getHost().getRecordingHint() != RecordingHint.STILL_ONLY);
            }

            this.requestLayout();
            this.camera.setParameters(this.getHost().adjustPreviewParameters(parameters));
            this.startPreview();
        }

    }

    private void startPreview() {
        this.camera.startPreview();
        this.inPreview = true;
        this.getHost().autoFocusAvailable();
    }

    private void stopPreview() {
        this.inPreview = false;
        this.getHost().autoFocusUnavailable();
        this.camera.stopPreview();
    }

    private void setCameraDisplayOrientation() {
        CameraInfo info = new CameraInfo();
        int rotation = this.getActivity().getWindowManager().getDefaultDisplay().getRotation();
        short degrees = 0;
        DisplayMetrics dm = new DisplayMetrics();
        Camera.getCameraInfo(this.cameraId, info);
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        switch(rotation) {
            case 0:
                degrees = 0;
                break;
            case 1:
                degrees = 90;
                break;
            case 2:
                degrees = 180;
                break;
            case 3:
                degrees = 270;
        }

        if(info.facing == 1) {
            this.displayOrientation = (info.orientation + degrees) % 360;
            this.displayOrientation = (360 - this.displayOrientation) % 360;
        } else {
            this.displayOrientation = (info.orientation - degrees + 360) % 360;
        }

        boolean wasInPreview = this.inPreview;
        if(this.inPreview) {
            this.stopPreview();
        }

        this.camera.setDisplayOrientation(this.displayOrientation);
        if(wasInPreview) {
            this.startPreview();
        }

    }

    private void setCameraPictureOrientation(Parameters params) {
        CameraInfo info = new CameraInfo();
        Camera.getCameraInfo(this.cameraId, info);
        if(this.getActivity().getRequestedOrientation() != -1) {
            this.outputOrientation = this.getCameraPictureRotation(this.getActivity().getWindowManager().getDefaultDisplay().getOrientation());
        } else if(info.facing == 1) {
            this.outputOrientation = (360 - this.displayOrientation) % 360;
        } else {
            this.outputOrientation = this.displayOrientation;
        }

        if(this.lastPictureOrientation != this.outputOrientation) {
            params.setRotation(this.outputOrientation);
            this.lastPictureOrientation = this.outputOrientation;
        }

    }

    private int getCameraPictureRotation(int orientation) {
        CameraInfo info = new CameraInfo();
        Camera.getCameraInfo(this.cameraId, info);
        boolean rotation = false;
        orientation = (orientation + 45) / 90 * 90;
        int rotation1;
        if(info.facing == 1) {
            rotation1 = (info.orientation - orientation + 360) % 360;
        } else {
            rotation1 = (info.orientation + orientation) % 360;
        }

        return rotation1;
    }

    Activity getActivity() {
        return (Activity)this.getContext();
    }

    private class PictureTransactionCallback implements PictureCallback {
        PictureTransaction xact = null;

        PictureTransactionCallback(PictureTransaction xact) {
            this.xact = xact;
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            camera.setParameters(CameraView.this.previewParams);
            if(data != null) {
                (new ImageCleanupTask(CameraView.this.getContext(), data, CameraView.this.cameraId, this.xact)).start();
            }

            if(!this.xact.useSingleShotMode()) {
                CameraView.this.startPreview();
            }

        }
    }

    private class OnOrientationChange extends OrientationEventListener {
        private boolean isEnabled = false;

        public OnOrientationChange(Context context) {
            super(context);
            this.disable();
        }

        public void onOrientationChanged(int orientation) {
            if(CameraView.this.camera != null && orientation != -1) {
                int newOutputOrientation = CameraView.this.getCameraPictureRotation(orientation);
                if(newOutputOrientation != CameraView.this.outputOrientation) {
                    CameraView.this.outputOrientation = newOutputOrientation;
                    Parameters params = CameraView.this.camera.getParameters();
                    params.setRotation(CameraView.this.outputOrientation);

                    try {
                        CameraView.this.camera.setParameters(params);
                        CameraView.this.lastPictureOrientation = CameraView.this.outputOrientation;
                    } catch (Exception var5) {
                        Log.e(this.getClass().getSimpleName(), "Exception updating camera parameters in orientation change", var5);
                    }
                }
            }

        }

        public void enable() {
            this.isEnabled = true;
            super.enable();
        }

        public void disable() {
            this.isEnabled = false;
            super.disable();
        }

        boolean isEnabled() {
            return this.isEnabled;
        }
    }
}
