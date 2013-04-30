package example.mobb_sdk;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/*
 * class CustomFunctionAdapter to show list of Providers
 */
public class CustomListViewAdapter extends ArrayAdapter<String>{
	 Context context;
	 int layoutResourceId;
	 ArrayList<String> providers;
	    public CustomListViewAdapter(Context context,int layoutResourceId,ArrayList<String> providers) {
	      super(context,layoutResourceId,providers);
	      this.layoutResourceId = layoutResourceId;
	      this.context = context;
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
	        	LayoutInflater minflater = ((Activity)context).getLayoutInflater();
	            convertView = minflater.inflate(R.layout.listview_item_row,null);
	            holder = new ViewHolder();
	            
	            holder.txtTitle = (TextView) convertView.findViewById(R.id.rowTextView);
	        	holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
	           
	            convertView.setTag(holder);
	            
	        } else
	            holder = (ViewHolder) convertView.getTag();
	       
	        holder.txtTitle.setText(providers.get(position));
	        String provider=providers.get(position).toString();
	        
            if(provider.equalsIgnoreCase("Facebook"))
           	            	//holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Twitter"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_twitter);
            else if(provider.equalsIgnoreCase("Google"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_google); 
            else if(provider.equalsIgnoreCase("LinkedIn"))
	   	             holder.imageView.setImageResource(R.drawable.jr_icon_bw_linkedin); 
            else if(provider.equalsIgnoreCase("Yahoo"))
	     	         holder.imageView.setImageResource(R.drawable.jr_icon_yahoo); 
            else if(provider.equalsIgnoreCase("aol"))
	     	   	     holder.imageView.setImageResource(R.drawable.jr_icon_aol);
            else if(provider.equalsIgnoreCase("hyves"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("live"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("persona"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Foursquare"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("vkontakte"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Livejournal"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("mixi"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("MyOpenId"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("myspace"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("openid"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("orange"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("stachexchange"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("verisign"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("virgilio"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("wordpress"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Github"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("QQ"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Kaixin"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else if(provider.equalsIgnoreCase("Renren"))
	               	 holder.imageView.setImageResource(R.drawable.jr_icon_bw_facebook);
            else
            {
            	 holder.imageView.setImageResource(R.drawable.ic_launcher);
            }
	        
	 
	        return convertView;
	    }
	}

