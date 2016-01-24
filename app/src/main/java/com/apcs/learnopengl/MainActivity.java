package com.apcs.learnopengl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.apcs.learnopengl.Renderer.FirstOpenglRenderer;

public class MainActivity extends AppCompatActivity {
    private String LOG_TAG = MainActivity.class.getSimpleName();
    private GLSurfaceView mGLSurfaceView =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int a = 1;
        Log.d(LOG_TAG,"meow "+ a);
        mGLSurfaceView = new GLSurfaceView(this);

        //check if mGLSurfaceView supports OpenGL ES 2.0
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion>=0x20000;

        if (supportsEs2){
            Log.i(LOG_TAG, "Support es2");
            // request an OpenGL ES 2.0 compatible context
            mGLSurfaceView.setEGLContextClientVersion(2);
            mGLSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
            mGLSurfaceView.setRenderer(new FirstOpenglRenderer());

        }else {
            Log.i(LOG_TAG,"Not support es2");
            return;
        }
        setContentView(mGLSurfaceView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }
}
