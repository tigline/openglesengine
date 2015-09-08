package com.tcl.openglesengine.core;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.integer;

import ljh.game.ISprite;
import ljh.opengl.GLEx;
import ljh.opengl.LTexture;

public abstract class Screen {
	
	public LTexture background;
	int width,height;
	public void setBackground(String filename)
	{
		this.background = new LTexture(filename);
	}	
	
	public void paint(GLEx g)
	{
		if(background!=null)
			g.drawTexture(background, 0,0,width,height);		
		draw(g);			
	}
	public void update(long elapsedTime)
	{
		alter(elapsedTime);
	}
	public void setSize(int width,int height)
	{
		this.width = width;
		this.height = height;
	}
	
	protected void onPressed(int keycode) {
		// TODO Auto-generated method stub

	}
	protected void onReleased(int keycode)
	{
		
	}
	public void addSprite(ISprite sprite)
	{
		
	}
	public void addSprite(ISprite sprite,int layer)
	{
		
	}
	public void dispose()
	{};
	public abstract void draw(GLEx g);
	public abstract void alter(long elapsedTime);
	
}
