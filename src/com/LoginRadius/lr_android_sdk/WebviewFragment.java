package com.LoginRadius.lr_android_sdk;



import java.io.IOException;

import com.google.gson.Gson;
import android.graphics.Bitmap;

import LoginRadiusDataObject.BasicUserLoginRadiusProfile;
import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebviewFragment extends LRUIFragment {
	String tag;
	static String urlt;
	private WebView webView;
	private ProgressBar mProgressSpinner ;
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_webview_demo, container, false);
        webView = (WebView)view.findViewById(R.id.wvDisplay);
        WebSettings webSetting= webView.getSettings(); 
		// enabled javascript
		webSetting.setJavaScriptEnabled(true); 
		mProgressSpinner = (ProgressBar)view.findViewById(R.id.jr_webview_progress);
    	webView.setWebViewClient(new WebViewClient() {
    		
			@Override
    		public void onPageStarted(WebView view, String url, Bitmap favicon) {
    		showProgressSpinner();
    		}

    		
			 // this method will call every time when page loading is finished in webview
		      @Override
		     public void onPageFinished(final WebView view, String url) {
		    	  hideProgressSpinner();
		    	  // if url contains token then only redirect to next activity named Functions
		    	  //boolean contains = url.contains("?token");
		    	  if(url.contains("?token"))
		    	  {
		    		  int in=url.indexOf("?token");
		   		      LoginRadius.Token=url.substring(in+7,in+43);
		   			  getActivity().finish();		   		  
		   		   
		   			  try
		   			  {
		   				  //call API to fetch user profile
		   				  LoginRadius lr=new LoginRadius();
		   				  lr.ProcessRequest(LoginRadius.Token, LoginRadius.Api_Secrete);
		   				  while(ConnectionManager.res==null){}
		   				  if(ConnectionManager.res.equalsIgnoreCase("error"))
		   				  {
		   					  Toast.makeText(lr.mApplicationContext,"Something is going wrong", Toast.LENGTH_SHORT).show();
		   				  }
		                
		   				  else
		   				  {
		   					  // Deserialise json response and store data in BasicUserLoginRadiusProfile class data menbers
		   					  BasicUserLoginRadiusProfile data= new Gson().fromJson(ConnectionManager.res, BasicUserLoginRadiusProfile.class);
		   					  // call the method of interface LRInterface implemented by user.
		   					  LoginRadiusDataObject.ExtendedUserLoginRadiusUserProfile data1=new Gson().fromJson(ConnectionManager.res, LoginRadiusDataObject.ExtendedUserLoginRadiusUserProfile.class);
		   					  LoginRadius.lr_interface.showuserprofile(data1);
		   					}
		   			  	}
		   			  	catch(IOException e)
		   			  	{
		   			  			//textView.setText("Hello");
		   			  	}
		   			  	catch(Exception e1)
		   			  	{
		   			  		//textVsiew.setText(e1.getMessage()+"hello");
		   			  	}
		    	  	}  
		      	    	  	  
		      	}
		      
		        @Override
		        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		          //Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
		        }
		      
		        @Override
		        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		          	
		            // this will ignore the Ssl error and will go forward to your site
		            handler.proceed();
		      }
		      
		    });
				webView.loadUrl(urlt);
				return view;
	}
	
		private void showProgressSpinner() {
			mProgressSpinner.setVisibility(View.VISIBLE);
		}
	
		private void hideProgressSpinner() {
			mProgressSpinner.setVisibility(View.GONE);
		}

}
