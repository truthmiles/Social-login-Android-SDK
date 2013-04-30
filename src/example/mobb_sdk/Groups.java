package example.mobb_sdk;

import com.google.gson.Gson;

import LoginRadiusDataObject.LoginRadiusGroups;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Groups extends Activity 
{
	 String Token;
	 String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        /* get data from previous activity */
		Bundle extras = getIntent().getExtras();
        if (extras != null) 
		{
  		  url = extras.getString("url");
  		  int in=url.indexOf("?token");
  		   Token=url.substring(in+7,in+43);
  		}
        
        //Token=extras.getString("token");
        ConnectionManager.res=null;
        try
        {
            GetGroups ob=new GetGroups();
            String returnurl=ob.getGroups(Token, LoginRadius.Api_Secrete);
            /* AsyncTask running in background */
			ConnectionManager.createConnection(returnurl);
            while(ConnectionManager.res==null){}
            TextView tx=(TextView)findViewById(R.id.getgroups);
            tx.setText(ConnectionManager.res);
            //Deserialzation of data
            LoginRadiusGroups data= new Gson().fromJson(ConnectionManager.res, LoginRadiusGroups.class);
        }catch(Exception e){}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.groups, menu);
		return true;
	}

}
