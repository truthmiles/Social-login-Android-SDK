package com.LoginRadius.lr_android_sdk;

import java.util.ArrayList;

import java.util.Iterator;

import com.google.gson.Gson;
import LoginRadiusDataObject.Provider_name;
import LoginRadiusDataObject.Root;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class ProviderListFragment extends LRUIFragment {
	 private ListView listView ;
	 private ArrayAdapter<String> listAdapter ;
	 private WebView webView;
	 private CustomListViewAdapter adapter;
	 String json_res;
	 Root data;
	 String msg[];
	 String endpoint[];
	 int i=0;


	@SuppressLint("NewApi")
	private class CustomListViewAdapter extends ArrayAdapter<String>{
      ArrayList<String> providers;
		    
      public CustomListViewAdapter(ArrayList<String> providers) {
		      super(getActivity(),0,providers);
		      //this.layoutResourceId = layoutResourceId;
		      //this.context = context;
		      this.providers=providers;  
	   }
		 
		    /*private view holder class*/
		    private class ViewHolder {
		        ImageView imageView;
		        TextView txtTitle;
		       
		    }
		    
		    // this will be called every time an item is displayed in list 
		 public View getView(int position, View convertView, ViewGroup parent) {
		        ViewHolder holder = null;
		      
		        if (convertView == null) {
		        	LayoutInflater minflater = (getActivity()).getLayoutInflater();
		            convertView = minflater.inflate(R.layout.listview_item_row,null);
		            holder = new ViewHolder();
		            
		            holder.txtTitle = (TextView) convertView.findViewById(R.id.rowTextView);
		        	holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
		           
		            convertView.setTag(holder);
		            
		        } 
		        else
		            holder = (ViewHolder) convertView.getTag();
		       
		        holder.txtTitle.setText(providers.get(position));
		        String provider=providers.get(position).toString();
		        
	            if(provider.equalsIgnoreCase("Facebook"))
	           	            	//holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
	            	 holder.imageView.setImageResource(R.drawable.lr_facebook);
	            else if(provider.equalsIgnoreCase("Twitter"))
		               	 holder.imageView.setImageResource(R.drawable.lr_twitter);
	            else if(provider.equalsIgnoreCase("Google"))
		               	 holder.imageView.setImageResource(R.drawable.lr_google); 
	            else if(provider.equalsIgnoreCase("LinkedIn"))
		   	             holder.imageView.setImageResource(R.drawable.lr_linkedin); 
	            else if(provider.equalsIgnoreCase("Yahoo"))
		     	         holder.imageView.setImageResource(R.drawable.lr_yahoo); 
	            else if(provider.equalsIgnoreCase("aol"))
		     	   	     holder.imageView.setImageResource(R.drawable.lr_aol);
	            else if(provider.equalsIgnoreCase("hyves"))
		               	 holder.imageView.setImageResource(R.drawable.lr_hyves);
	            else if(provider.equalsIgnoreCase("live"))
		               	 holder.imageView.setImageResource(R.drawable.lr_live);
	            else if(provider.equalsIgnoreCase("persona"))
		               	 holder.imageView.setImageResource(R.drawable.lr_persona);
	            else if(provider.equalsIgnoreCase("Foursquare"))
		               	 holder.imageView.setImageResource(R.drawable.lr_foursquare);
	            else if(provider.equalsIgnoreCase("vkontakte"))
		               	 holder.imageView.setImageResource(R.drawable.lr_vkontakte);
	            else if(provider.equalsIgnoreCase("Livejournal"))
		               	 holder.imageView.setImageResource(R.drawable.lr_livejournal);
	            else if(provider.equalsIgnoreCase("mixi"))
		               	 holder.imageView.setImageResource(R.drawable.lr_mixi);
	            else if(provider.equalsIgnoreCase("MyOpenId"))
		               	 holder.imageView.setImageResource(R.drawable.lr_myopenid);
	            else if(provider.equalsIgnoreCase("myspace"))
		               	 holder.imageView.setImageResource(R.drawable.lr_myspace);
	            else if(provider.equalsIgnoreCase("openid"))
		               	 holder.imageView.setImageResource(R.drawable.lr_openid);
	            else if(provider.equalsIgnoreCase("orange"))
		               	 holder.imageView.setImageResource(R.drawable.lr_orange);
	            else if(provider.equalsIgnoreCase("stachexchange"))
		               	 holder.imageView.setImageResource(R.drawable.lr_stackexchange);
	            else if(provider.equalsIgnoreCase("verisign"))
		               	 holder.imageView.setImageResource(R.drawable.lr_verisign);
	            else if(provider.equalsIgnoreCase("virgilio"))
		               	 holder.imageView.setImageResource(R.drawable.lr_virgilio);
	            else if(provider.equalsIgnoreCase("wordpress"))
		               	 holder.imageView.setImageResource(R.drawable.lr_wordpress);
	            else if(provider.equalsIgnoreCase("Github"))
		               	 holder.imageView.setImageResource(R.drawable.lr_github);
	            else if(provider.equalsIgnoreCase("QQ"))
		               	 holder.imageView.setImageResource(R.drawable.lr_qq);
	            else if(provider.equalsIgnoreCase("Kaixin"))
		               	 holder.imageView.setImageResource(R.drawable.lr_kaixin);
	            else if(provider.equalsIgnoreCase("Renren"))
		               	 holder.imageView.setImageResource(R.drawable.lr_renren);
	            else
	            {
	            	 holder.imageView.setImageResource(R.drawable.ic_launcher);
	            }
		        	 
		        return convertView;
		    }
		}
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 json_res = (ConnectionManager.res);
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
	        endpoint=new String[i];
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
	       
	        View inflatedLayout = inflater.inflate(R.layout.providerlist, container, false);
	        listView = (ListView) inflatedLayout.findViewById(R.id.listView1);
	        
	        // prepare list of providers
	        // Set the ArrayAdapter as the ListView's adapter.
	       
	        adapter = new CustomListViewAdapter(providerlist);
	        listView.setAdapter(adapter);
	        
	        // call for the endpoint on click of corresponding provider in list 
	        listView.setOnItemClickListener(new OnItemClickListener() {
	        @Override
		         public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
			     // TODO Auto-generated method stub
						getActivity().finish();        	
						showWebView(endpoint[position]);  
			}
	});
		return inflatedLayout;
	} 

}
