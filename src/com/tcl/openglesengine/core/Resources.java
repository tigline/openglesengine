package com.tcl.openglesengine.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class Resources {
	
	public static Bitmap getBitmap(Context context,String filename)
	{	
		filename = filename.trim().toLowerCase();
		InputStream in;
		try {
			in = open(context,filename);
			Bitmap bitmap = BitmapFactory.decodeStream(in);
			in.close();
			return bitmap;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public static Bitmap getBitmap(String filename)
	{	
		filename = filename.trim().toLowerCase();
		InputStream in;
		try {
			in = open(filename);
			Bitmap bitmap = BitmapFactory.decodeStream(in);
			in.close();
			return bitmap;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public static InputStream open(String filename)
	{
		
		filename = filename.trim().toLowerCase(); //去除多余字符并转成小写
		Log.d("Resouce", "filename = " + filename);
		
		InputStream in = null;
		try {
			if(filename.startsWith("assets/"))
			{   

				filename = filename.substring(7);
				Log.d("Resouce", "image = " + filename);				

			}
			else if(filename.startsWith(sdPath))
			{
			   if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED)
			   {
				   in = new FileInputStream(filename);
			   }
			}
			else
			{
				try
				{
				 in = new FileInputStream(filename);
				}
				catch (Exception e) {
					// TODO: handle exception
					in = null;
					System.out.println("没找到文件!");
				}
			}
			return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public static String sdPath =	Environment.getExternalStorageDirectory().getAbsolutePath();
	public static void resetSDpath()
	{
		sdPath =Environment.getExternalStorageDirectory().getAbsolutePath();
	}
	public static InputStream open(Context context,String filename)
	{
		
		filename = filename.trim().toLowerCase(); //去除多余字符并转成小写
		Log.d("Resouce", "filename = " + filename);
		
		InputStream in = null;
		try {
			if(filename.startsWith("assets/"))
			{   
				AssetManager assetManager = context.getResources().getAssets();
				filename = filename.substring(7);
				Log.d("Resouce", "image = " + filename);				
				//new GameSystem(context);
				in = assetManager.open(filename);	//
				//in = GameSystem.assetManager.open(filename);
			}
			else if(filename.startsWith(sdPath))
			{
			   if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED)
			   {
				   in = new FileInputStream(filename);
			   }
			}
			else
			{
				try
				{
				 in = new FileInputStream(filename);
				}
				catch (Exception e) {
					// TODO: handle exception
					in = null;
					System.out.println("没找到文件!");
				}
			}
			return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
