package example.mobb_sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ProviderList {
	String value;
	Root data;
	public String Api_key=LoginRadius.Api_Key; 
	final String url="http://hub.loginradius.com/getappsettings/"+Api_key;
	
	/* This function is used to get providers from URL 
	 * @param Context The Android Context used to access to system resources
	 */
	public void getProvider(Context con)
	{
		
		ConnectionManager.createConnection(url);
		while(ConnectionManager.res==null){}
		// When get providers then start activity to show providers as Interface 
   	      Intent i = new Intent(con, UIinterface.class);
    	  i.putExtra("result",ConnectionManager.res);
    	  con.startActivity(i);
    	   
		
	}
	
}
