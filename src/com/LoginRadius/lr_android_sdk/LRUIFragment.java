package com.LoginRadius.lr_android_sdk;



import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


@SuppressLint("NewApi")
public abstract class LRUIFragment extends Fragment {
	public static final int REQUEST_WEBVIEW = 2;
	
	public abstract View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) ;
	    
	
	void showWebView(String url){
        if (getActivity() instanceof UIinterface) {
        	WebviewFragment.urlt=url;
            Bundle opts = new Bundle();
            startActivityForFragId(UIinterface.LR_WEBVIEW, REQUEST_WEBVIEW, opts);
        } 
	} 
	private void startActivityForFragId(int fragId, int requestCode, Bundle opts) {
       
        Intent i = UIinterface.createIntentForCurrentScreen(getActivity(), false);
        i.putExtra(UIinterface.LR_FRAGMENT_ID, fragId);
        
        if (opts != null) i.putExtras(opts);
        startActivityForResult(i, requestCode);
        
    }

}
