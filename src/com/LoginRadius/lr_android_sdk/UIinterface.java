package com.LoginRadius.lr_android_sdk;


import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import LoginRadiusDataObject.Provider_name;
import LoginRadiusDataObject.Root;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.app.*;

@SuppressLint("NewApi")
public class UIinterface extends FragmentActivity {
	
	public static final String LR_PROVIDER = "LR_PROVIDER";
	 public static final int LR_PROVIDER_LIST = 1;
	 public static final int LR_WEBVIEW = 2;
	 public static final String LR_FRAGMENT_ID = "com.janrain.android.engage.LR_FRAGMENT_ID";
	 static LRUIFragment obj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uiinterface);
		 switch (getFragmentId()) {
         case LR_PROVIDER_LIST:
             obj = new ProviderListFragment();
             getFragmentManager().beginTransaction().add(R.id.lr_fragment_container, obj).commit();
             break;
         case LR_WEBVIEW:
        	 obj = new WebviewFragment();
        	 getFragmentManager().beginTransaction().replace(R.id.lr_fragment_container, obj).commit();
             break;
         
     }
		
		
	}
	
	 private int getFragmentId() {
	        return getIntent().getExtras().getInt(LR_FRAGMENT_ID);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uiinterface, menu);
		return true;
	}
	
	 public static Intent createIntentForCurrentScreen(Activity activity, boolean showTitleBar) {
	        Intent intent;
	        intent = new Intent(activity, UIinterface.class);
	        
	        return intent;
	    }

	    public static Intent createProviderListIntent(Activity activity) {
	        Intent i = createIntentForCurrentScreen(activity, true);
	        i.putExtra(LR_FRAGMENT_ID, LR_PROVIDER_LIST);
	        return i;
	    }

}
