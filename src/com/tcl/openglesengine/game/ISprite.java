package com.tcl.openglesengine.game;


import com.tcl.openglesengine.game.geom.RectBox;
import com.tcl.openglesengine.opengl.GLEx;
import com.tcl.openglesengine.opengl.LTexture;

public interface ISprite {
	
	void setLocation(float x,float y);
	void setImage(LTexture image);
	void setSize(float width,float height);
	float getWidth();
	float getHeight();
	float getX();
	float getY();
	int getLayer();
	void setLayer(int layer);
	void draw(GLEx gl);
	void setVisible(boolean visible);
	boolean isVisible();
	void update(long elapsedTime);
	LTexture getImage();
	RectBox getCollided();
	boolean isCollided(RectBox box);
}	
