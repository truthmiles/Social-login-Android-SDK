package example.mobb_sdk;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/*
 * shows different APIs in List and call their corresponding functions
 */

public class Functions extends Activity {
	String url ;
	private ListView listView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_functions);
		ArrayList<String> ai=new ArrayList<String>();
		View v = null;
		ai.add("Direct Message");
		ai.add("Post Status");
		ai.add("User Profile");
		ai.add("Get Status");
		ai.add("Get Events");
		ai.add("Get Groups");
		ai.add("Company Follow");
		
		
		listView=(ListView)findViewById( R.id.listView);
        // Set the ArrayAdapter as the ListView's adapter.
       
        CustomFunctionAdapter adapter = new CustomFunctionAdapter(this, R.layout.listview_row_item,ai);
        listView.setAdapter(adapter);
        
        /*
         * Add different functions on click of different items in list
         */
        listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
	   public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
		// TODO Auto-generated method stub
        	// get text of item that is clicked
        	String function=listView.getItemAtPosition(position).toString();
        	
        	  	
       	    // if post status is clicked then call Post Status API	
        	if(function.equalsIgnoreCase("Post Status"))
       		   {
       			   post_status(view);
       		   }
        	  // if User Profile is clicked then call User Profile API
       		   else if(function.equalsIgnoreCase("User Profile"))
       		   {
       			   user_profile(view);
       		   }
        	// if Direct Message is clicked then call Direct Message API
       		else if(function.equalsIgnoreCase("Direct Message"))
    		   {
    			   send_message(view);
    		   }
        	// if Get Status is clicked then call Get Status API
       		else if(function.equalsIgnoreCase("Get Status"))
    		   {
    			   get_posts(view);
    		   }
        	// if Get Event is clicked then call Get Event API
       		else if(function.equalsIgnoreCase("Get Events"))
    		   {
    			   get_events(view);
    		   }
        	// if get Group is clicked then call get Group API
       		else if(function.equalsIgnoreCase("get Groups"))
    		   {
    			   get_groups(view);
    		   }
        	// if Company Follow is clicked then call Company Follow API
       		else if(function.equalsIgnoreCase("Company Follow"))
    		   {
    			   company_follow(view);
    		   }
		
	}
});
	}
	
	//  call to post status API
	public void post_status(View view) {
		Bundle extras = getIntent().getExtras();
		// get data from previous activity
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,PostStatus.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to user profile API
	public void user_profile(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,UserProfile.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to send message API
	public void send_message(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,SendMessage.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to get posts API
	public void get_posts(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,GetPosts.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to get groups API
	public void get_groups(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,Groups.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to get events API
	public void get_events(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,Events.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
//  call to company follow API
	public void company_follow(View view) {
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		  url = extras.getString("url");
		}
		// send data to next activity and start next activity to post status
	    Intent intent = new Intent(this,CompanyFollow.class);
	     intent.putExtra("url",url);
	    startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.functions, menu);
		return true;
	}

}
