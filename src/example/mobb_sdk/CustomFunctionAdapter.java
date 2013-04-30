package example.mobb_sdk;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/*
 * class CustomFunctionAdapter to show list of different APIs.
 */

public class CustomFunctionAdapter extends ArrayAdapter<String>{
	 Context context;
	 int layoutResourceId;
	 ArrayList<String> func;
	    public CustomFunctionAdapter(Context context,int layoutResourceId,ArrayList<String> func) {
	      super(context,layoutResourceId,func);
	      this.layoutResourceId = layoutResourceId;
	      this.context = context;
	      this.func=func;  
	    }
	 
	    /*private view holder class*/
	    private class ViewHolder {
	        TextView txtTitle;
	       
	    }
	    // this will be called every time an item is displayed in list 
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ViewHolder holder = null;
	       
	        if (convertView == null) {
	        	LayoutInflater minflater = ((Activity)context).getLayoutInflater();
	            convertView = minflater.inflate(R.layout.listview_row_item,null);
	            holder = new ViewHolder();
	            
	            holder.txtTitle = (TextView) convertView.findViewById(R.id.TextView);
	        	           
	            convertView.setTag(holder);
	            
	        } else
	            holder = (ViewHolder) convertView.getTag();
	       
	        holder.txtTitle.setText(func.get(position));
	        
	 
	        return convertView;
	    }
	

}
