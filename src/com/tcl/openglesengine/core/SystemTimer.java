package com.tcl.openglesengine.core;

public class SystemTimer {
	public static long lastTime;
	public static long currentTime;
	public static long elapsedTime;
	
	public static void run()
	{
		currentTime = System.currentTimeMillis();
		if(currentTime>lastTime)
		{
			elapsedTime = currentTime - lastTime;
		}
		lastTime = currentTime;
		RunCount++;
	}
	private static int RunCount = 0;
	private static long lastShowFPSTime = 0;
	private static String FPS = "";
	public static String getFPS()
	{	
		if(currentTime - lastShowFPSTime < 1000)
			return FPS;		
		lastShowFPSTime = currentTime;		
		FPS ="FPS:" + RunCount + "帧/sec";
		RunCount = 0;
		return  FPS;
	}
	public static String getMemory()
	{
		Runtime runtime = Runtime.getRuntime();
		long totalMemory = runtime.totalMemory();
		long currentMemory = totalMemory - runtime.freeMemory();
		String memory = ((float) ((currentMemory * 10) >> 20) / 10)
				+ " of "
				+ ((float) ((totalMemory * 10) >> 20) / 10) + " MB";		
		return "MEMORY:" + memory;
	}
}
