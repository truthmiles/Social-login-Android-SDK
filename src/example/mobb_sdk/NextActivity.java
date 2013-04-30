package example.mobb_sdk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

//  Get provider List and endpoints using API key of app which is created by user on loginradius  by calling service getAppSettings.

public class NextActivity extends Activity {
	String value;
	Root data;
	//static String res;
	//Url containing API key
	public String Api_key=LoginRadius.Api_Key; 
	final String url="http://hub.loginradius.com/getappsettings/"+Api_key;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		ConnectionManager.createConnection(url);
		while(ConnectionManager.res==null){}
		Intent myIntent = new Intent(getApplicationContext(), UIinterface.class);
    	myIntent.putExtra("result",ConnectionManager.res);
    	startActivity(myIntent);
	}
}
