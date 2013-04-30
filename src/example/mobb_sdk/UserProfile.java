package example.mobb_sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import com.google.gson.Gson;

import LoginRadiusDataObject.BasicUserLoginRadiusProfile;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Activity UserProfile to fetch Basic user profile 
 */
public class UserProfile extends Activity {
	 private String Token;
     private String ApiSecret=LoginRadius.Api_Secrete;
     String index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		 index = extras.getString("url");
		 // fetch token from URL
		   int in=index.indexOf("?token");
		    Token=index.substring(in+7,in+43);
		  Toast.makeText(getApplicationContext(),Token, Toast.LENGTH_SHORT).show();
		}
		try
		{
		//call API to fetch user profile
		LoginRadius lr=new LoginRadius();
		lr.ProcessRequest(Token, ApiSecret);
		while(ConnectionManager.res==null){}
		// Deserialise json response and store data in BasicUserLoginRadiusProfile class data menbers
		BasicUserLoginRadiusProfile data= new Gson().fromJson(ConnectionManager.res, BasicUserLoginRadiusProfile.class);
		// call the method of interface LRInterface implemented by user.
		LoginRadius.lr_interface.showuserprofile(data);
		
		// following code can be used to show userprofile in SDK 		
		 /*Intent myIntent = new Intent(getApplicationContext(), DisplayData.class);
		   myIntent.putExtra("new_variable_name",ConnectionManager.res);
	       startActivity(myIntent);*/
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profile, menu);
		return true;
	}

}
	