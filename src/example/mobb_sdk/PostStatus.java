package example.mobb_sdk;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/*
 * Activity PostStatus to show user interface for post status 
 */
public class PostStatus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_status);
	}
	// call on click of button to post status
	public void PostStatus(View view) {
		String url="";
		String Token="";
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		  
		  //get token from url
		  int in=url.indexOf("?token");
		   Token=url.substring(in+7,in+43);
		   
		}
		try
		{
			//get data(text of Post) from textbox
			EditText editText = (EditText) findViewById(R.id.edit_message);
	    Statuses status=new Statuses();
	    // call the API
	    status.postStatus(Token, LoginRadius.Api_Secrete,"", "", "", "",editText.getText().toString(),"", "");
	    Toast.makeText(getApplicationContext(),"Status Posted Successfully", Toast.LENGTH_SHORT).show();
		}
		catch(Exception e){
			Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_status, menu);
		return true;
	}

}
