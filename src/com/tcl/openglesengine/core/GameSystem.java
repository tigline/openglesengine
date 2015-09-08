package com.tcl.openglesengine.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

import ljh.game.AnimationManager;
import ljh.game.geom.RectBox;
import ljh.opengl.GLEx;
import ljh.opengl.LColor;
import ljh.opengl.command.GLFont;
import android.content.Context;
import android.content.res.AssetManager;

public class GameSystem {
	public static Context context;
	public static RectBox screenBox;
	public static AssetManager assetManager;
	public static boolean ShowFPS = false;
	public static boolean ShowMemory = false;
	private static boolean isDrawing = false;
	public static Screen CurrentScreen = null;
	public static LinkedList<Screen> screenList = new LinkedList<Screen>();
	private static LinkedList<Runnable> DrawingHandle = new LinkedList<Runnable>();
	public static void Initializing()
	{}
	public static void setScreen(Screen screen)
	{
		if(CurrentScreen!=null)
		{
			CurrentScreen.dispose();
		}
		screen.setSize((int)screenBox.width, (int)screenBox.height);
		CurrentScreen = screen;
		screenList.add(screen);		
	}	 
	public static void setDrawingStart()
	{		
		isDrawing = true;
		runDrawingRunnable();
	}
	public static void setDrawingEnd()
	{
		isDrawing = false;
	}
	public static boolean getIsDrawing()
	{
		return isDrawing;
	}
	
	public static void update(long elapsedTime)
	{	
		AnimationManager.update(elapsedTime);
		GLFont.update();
		if(CurrentScreen != null)
			CurrentScreen.update(elapsedTime);
		
	}
	public static void paint(GLEx g)
	{			
		if(CurrentScreen != null)
		CurrentScreen.paint(g);
		
		if(ShowFPS)
		{
			g.setColor(LColor.white);
			g.drawString(SystemTimer.getFPS(), 0, 0);
		}
		if(ShowMemory)
		{
			g.setColor(LColor.white);
			g.drawString(SystemTimer.getMemory(), 0, 20);
		}
	}
	public static void addDrawingRunnable(Runnable runnable)
	{
		DrawingHandle.add(runnable);
	}
	private static void runDrawingRunnable()
	{

		for(Runnable runnable : DrawingHandle)
		{
			runnable.run();
		}
		DrawingHandle.clear();
	}
	public static void removeDrawingRunnable(Runnable runnable)
	{
		DrawingHandle.remove(runnable);
	}
}
