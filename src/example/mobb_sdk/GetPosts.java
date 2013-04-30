package example.mobb_sdk;

import com.google.gson.Gson;

import LoginRadiusDataObject.LoginRadiusPost;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class GetPosts extends Activity 
{
	 String url;
	 String Token;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_posts);
		/*get data from previous activity */
		Bundle extras = getIntent().getExtras();
		if (extras != null) 
		{
			  url = extras.getString("url");
			  int in=url.indexOf("?token");
			  Token=url.substring(in+7,in+43);
		}
        
       Post ob=new Post();
       try
       {
           String returnurl=ob.getPosts(Token,LoginRadius.Api_Secrete);
           ConnectionManager.res=null;
           /* AsyncTask running in background */
		   ConnectionManager.createConnection(returnurl);
           while(ConnectionManager.res==null)
           {
               
           }
           //String res=new Utility().execute(returnurl).get();
           TextView tx=(TextView)findViewById(R.id.getposts);
           tx.setText(ConnectionManager.res);
           /*Deserialzation of data */
           LoginRadiusPost data= new Gson().fromJson(ConnectionManager.res,LoginRadiusPost.class);
       }catch(Exception e)
       {
           Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

       }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_posts, menu);
		return true;
	}

}
