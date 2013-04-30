package example.mobb_sdk;

import com.google.gson.Gson;

import LoginRadiusDataObject.LoginRadiusEvent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Events extends Activity {
	String Token;
	String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		/*get data from previous activity */
		Bundle extras = getIntent().getExtras();
		if (extras != null) 
		{
			  url = extras.getString("url");
			  int in=url.indexOf("?token");
			   Token=url.substring(in+7,in+43);
		}
       // Token=extras.getString("token");
        ConnectionManager.res=null;
        try
        {
            GetEvents ge=new GetEvents();
            String returnurl=ge.getEvents(Token, LoginRadius.Api_Secrete);
            /* AsyncTask running in background */
			ConnectionManager.createConnection(returnurl);
            while(ConnectionManager.res==null){}
            String message="Your Events : " + ConnectionManager.res;
            TextView tx=(TextView)findViewById(R.id.getevents);
            tx.setText(message);
            /* Deserialization of data*/
			LoginRadiusEvent data= new Gson().fromJson(ConnectionManager.res, LoginRadiusEvent.class);

        }catch(Exception e){}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
		return true;
	}

}
