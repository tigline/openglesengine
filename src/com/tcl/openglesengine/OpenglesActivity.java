package com.tcl.openglesengine;

import com.tcl.openglesengine.core.GameSystem;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class OpenglesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        onMain();
        
        GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new MyRender(this));
        setContentView(glSurfaceView);
        GameSystem.context = getApplicationContext();
        GameSystem.assetManager = getAssets();
        GameSystem.Initializing();
    }
    public void onMain()
    {
    	initialization(true, true, true);
    	GameSystem.ShowFPS = true;
    	GameSystem.ShowMemory = true;
    }
    public void initialization(boolean isOrientation,boolean FullScreen,boolean HideTitle)
    {	
    	if(HideTitle)
    		requestWindowFeature(Window.FEATURE_NO_TITLE);
    	if(FullScreen)
    		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	if(isOrientation)
    		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    	else
    		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    
}