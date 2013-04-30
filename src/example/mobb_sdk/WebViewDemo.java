
package example.mobb_sdk;

import java.util.Timer;

import java.util.TimerTask;


import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

import android.webkit.WebViewClient;

import android.widget.TextView;
import android.widget.Toast;


// load URLs in Webview -- A View that displays web pages

public class WebViewDemo extends Activity  {
	String tag;
	String urlt;
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_demo);
		//get url that pass from the other screen
		urlt =getIntent().getStringExtra("url");
		webView = (WebView)findViewById(R.id.wvDisplay);
		//create new settings for webView
		WebSettings webSetting= webView.getSettings(); 
		// enabled javascript
		webSetting.setJavaScriptEnabled(true); 
		//set up webviewclient, this set not to open the default browser when link click
		//webView.setWebViewClient(new WebViewClient()); 
		//load the web page
		webView.setWebViewClient(new WebViewClient() {
			
			 // this method will call every time when page loading is finished in webview
		      @Override
		      public void onPageFinished(final WebView view, String url) {
		    	 
		       /* code to save token in cookies   
		         CookieSyncManager.getInstance().sync();
		        // Get the cookie from cookie jar.
		        String cookie = CookieManager.getInstance().getCookie(url);
		        if (cookie == null) {
		          return;
		        }
		        // Cookie is a string like NAME=VALUE [; NAME=VALUE]
		        String[] pairs = cookie.split(";");
		        for (int i = 0; i < pairs.length; ++i) {
		          String[] parts = pairs[i].split("=", 2);
		          // If token is found, return it to the calling activity.
		          if (parts.length == 2 &&
		             parts[0].equalsIgnoreCase("token")) {
		            Intent result = new Intent();
		            result.putExtra("token", parts[1]);
		            setResult(RESULT_OK, result);
		            finish();
		          }
		        }*/
		    	  
		    	  // if url contains token then only redirect to next activity named Functions
		    	  boolean contains = url.contains("?token");
		    	  if(contains)
		    	  {
		    		  //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
		    		  //int index=url.indexOf("?token");
		    		  int in=url.indexOf("?token");
		   		   LoginRadius.Token=url.substring(in+7,in+43);
		   		   //start new activity -Functions
		    		 Intent myIntent = new Intent(getApplicationContext(), Functions.class);
		  	    	  myIntent.putExtra("url",url);
		  	    	  startActivity(myIntent);
		    	  }  
		      
		    	  	  
		      }
		      
		      @Override
		      public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		          Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
		      }
		      
		      @Override
		      public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		          	 
		            // this will ignore the Ssl error and will go forward to your site
		            handler.proceed();
		      }
		      
		    });
		webView.loadUrl(urlt);
			
	}
	
	 
	public void onRestart() 
	 {
	     Log.d(tag,"onstart activity");   	        
		 super.onRestart();
	    }
	 public void onStart() 
	 {
	     Log.d(tag,"onstart activity");   	        
		 super.onStart();
	    }
	 
	 public void onResume()
	 {
		 Log.d(tag,"onResume activity");  
	        super.onResume();
	  }
	 public void onPause()
	 {
		 Log.d(tag,"onpause activity");  
	        super.onPause();
	    }
	 public void onStop() 
	 {
		 Log.d(tag,"onstopactivity");    
		 super.onStop();
	  }
	 
	 

	

}
