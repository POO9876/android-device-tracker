package com.example.androidtablayout;

import android.graphics.drawable.Drawable;
/**
 * 
 * An immutable object represents information about installed app
 * like app name, package name and app icon
 * @author MSS
 *
 */
public class InstalledApps {
	private String appName;
	private String packageName;
	private long dateTime;
	
	public InstalledApps(String appName,String packageName,long dateTme){
		this.appName=appName;
		this.packageName=packageName;
		this.dateTime=dateTme;
	}
	
	public String getPackageName(){
		return packageName;
	}
	
	public String getAppName(){
		return appName;
	}
	
	public long getDateTime(){
		return dateTime;
	}
	
}
