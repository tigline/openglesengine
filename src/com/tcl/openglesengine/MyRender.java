package com.tcl.openglesengine;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.tcl.openglesengine.core.GameSystem;
import com.tcl.openglesengine.core.SystemTimer;
import com.tcl.openglesengine.game.Sprite;
import com.tcl.openglesengine.game.geom.RectBox;
import com.tcl.openglesengine.opengl.GLEx;
import com.tcl.openglesengine.opengl.GLHelper;


import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class MyRender implements Renderer{

	Sprite sprite = null;
	Sprite sprite1 = null;
	/**
	 * @param openglesActivity
	 */
	public MyRender() {
		
		
	}
	public MyRender(Context context) {
		
		sprite = new Sprite(context,"assets/circle.png");
		sprite1 = new Sprite(context,"assets/circle.png");
	}


	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub		
		GLHelper.clear(gl);
		GLHelper.openTransparent(gl);		
		GameSystem.setDrawingStart();
		SystemTimer.run();
		GameSystem.update(SystemTimer.elapsedTime);
		
		GameSystem.paint(glex);
		sprite.setPosition(540.0f, 260.0f);
		sprite.setSize(437.0f, 437.0f);
		sprite.draw(glex);
		
		sprite1.setPosition(340.0f, 160.0f);
		sprite1.setSize(437.0f, 437.0f);
		sprite1.draw(glex);

		
		GLHelper.disableBlend(gl);
		
		
		GameSystem.setDrawingEnd();
	}
	GLEx glex;
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
//		gl.glOrthof(0, width, height, 0, 1, -100);
		GLU.gluOrtho2D(gl, 0, width, height, 0);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GameSystem.screenBox = new RectBox(0, 0, width, height);
		glex = new GLEx(gl);
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		// TODO Auto-generated method stub
		
		gl.glClearColor(0, 0, 0, 1);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
	}

}
