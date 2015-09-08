package com.tcl.openglesengine.game;

import com.tcl.openglesengine.opengl.GLEx;
import com.tcl.openglesengine.opengl.LTexture;
import com.tcl.openglesengine.opengl.LTextureUtils;
import com.tcl.openglesengine.core.LTimer;

public class Animation {
 private LTexture[] images;
 private LTimer timer;
 private int index;
 private LTexture texture;
 public Animation(String filename,int width,int height,int delay)
 {	 
	 texture = new LTexture(filename);
	 images = LTextureUtils.getSplitTexture(texture, width, height);
	 timer = new LTimer(delay);
 }
 public void update(long elapsedTime)
 {
	 if(timer.action(elapsedTime))
	 {
		 index++;
		 if(index >= images.length)
			 index = 0;
	 }
 }
 public void start()
 {
	 timer.start();
 }
 public void end()
 {
	 timer.stop();
 }
 public LTexture getImage()
 {
	 return images[index];
 }
 public LTexture getTexture()
 {
	 return this.texture;
 }
}
