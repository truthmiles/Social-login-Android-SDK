package example.mobb_sdk;

import com.google.gson.Gson;

import LoginRadiusDataObject.LoginRadiusCompanyFollow;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CompanyFollow extends Activity 
{
	 String Token;
	 String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_follow);
		/* get data From Previous Activity */
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
            Companies ob =new Companies(); 
            String returnurl=ob.getCompanies(Token, LoginRadius.Api_Secrete);
            
			/* AsyncTask Running in background */
			ConnectionManager.createConnection(returnurl);
            
			while(ConnectionManager.res==null){}
            String message ="Companies Followed By You : "+ConnectionManager.res;
            TextView tx=(TextView)findViewById(R.id.companyfollow);
            tx.setText(message);
            
			/* Deserialization of data */
			LoginRadiusCompanyFollow data= new Gson().fromJson(ConnectionManager.res, LoginRadiusCompanyFollow.class);

        }catch(Exception e){}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.company_follow, menu);
		return true;
	}

}
