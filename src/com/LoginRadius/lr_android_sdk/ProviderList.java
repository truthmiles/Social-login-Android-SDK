package com.LoginRadius.lr_android_sdk;

import LoginRadiusDataObject.Root;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;

public class ProviderList {
	String value;
	public String Api_key=LoginRadius.Api_Key; 
	final String url="http://hub.loginradius.com/getappsettings/"+Api_key;
	
	/* This function is used to get providers from URL 
	 * @param Context The Android Context used to access to system resources
	 */
	public void getProvider()
	{
		ConnectionManager.createConnection(url);
		   	   
	}

	
	
}
