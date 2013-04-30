package example.mobb_sdk;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//Load Dynamic List of providers for User Interaction 

public class UIinterface extends Activity
 {
	 private ListView listView ;
	 private ArrayAdapter<String> listAdapter ;
	 private WebView webView;
	 String json_res;
	 Root data;
	 String msg[];
	 String endpoint[]=new String[40];
	 int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uiinterface);
		// get data from previous activity
		Bundle extras = getIntent().getExtras();
		 if (extras != null) {
		 json_res = extras.getString("result");
		 }
		 ConnectionManager.res=null;
		 
		 // Deserialize json response and store data in Root class
		 data = new Gson().fromJson(json_res, Root.class);
		 
		 // get data(Providers name and endpoints) from class
		 Iterator <Provider_name> is =data.Providers.iterator();
	    	
	        while(is.hasNext())
	        {
	    	  is.next();
	    	   i++;
	        }
	        msg=new String[i];
	    	is  =data.Providers.iterator();
	    	i=0;
	        while(is.hasNext())
	        {
	    	   Provider_name element = is.next();
	    	   msg[i]=element.Name;
	    	   endpoint[i]=element.Endpoint+"&ismobile=true";
	    	   i++;
	        }
	         
	        // add providers into list
	        ArrayList<String> providerlist = new ArrayList<String>();
	        for(int j=0;j<i;j++)
	        		providerlist.add(msg[j]);
	       
	        // prepare list of providers
	        listView=(ListView)findViewById( R.id.listView1);
	        // Set the ArrayAdapter as the ListView's adapter.
	       
	        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.listview_item_row,providerlist);
	        listView.setAdapter(adapter);
	        
	        // call for the endpoint on click of corresponding provider in list 
	        listView.setOnItemClickListener(new OnItemClickListener() {
	        @Override
		   public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
			// TODO Auto-generated method stub
						        	
	       		   
			//Launch new Activity WebViewDemo.java
	        
			Intent it = new Intent(view.getContext(),WebViewDemo.class);
			it.putExtra("url",endpoint[position]);
			startActivity(it);
			
		}
	});
   
  }
	  
}


