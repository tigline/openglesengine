package com.tcl.openglesegine.game;


import ljh.game.geom.RectBox;
import ljh.opengl.GLEx;
import ljh.opengl.LTexture;

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
