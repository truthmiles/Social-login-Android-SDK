package example.mobb_sdk;

import LoginRadiusDataObject.LoginRadiusContact;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.view.Menu;


public class SendMessage extends Activity 
{
	String returnurl;
    String url;
    String Token;
    LoginRadiusContact []ob;
    RadioGroup rg;
    EditText edt;
    private static final String TAG =SendMessage.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_message);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);    
        GetContacts gc = new  GetContacts();
        LinearLayout ll = (LinearLayout)findViewById(R.id.li);
        
		/* to get data from previous activity */
		Bundle extras = getIntent().getExtras();
       
		if (extras != null) 
		{
		  url = extras.getString("url");
		  int in=url.indexOf("?token");
		   Token=url.substring(in+7,in+43);
		}
            
        //Adding TextView
        TextView tx=new TextView(this);
        tx.setText("Send Message");
        ll.addView(tx);
        
        //Adding Edit Text
        edt=new EditText(this);
        edt.setId(1);
        ll.addView(edt);
        ConnectionManager.res=null;
        try
        {
            String returnurl2=gc.getContacts(Token,LoginRadius.Api_Secrete);
            //String res=new Utility().execute(returnurl2).get();
            try 
            {
                /* AsyncTask running in background */
				ConnectionManager.createConnection(returnurl2);
            }catch(Exception e){
            Log.e(TAG,e.getMessage());
            }
            while(ConnectionManager.res==null)
            {
                
            }
            //Toast.makeText(getApplicationContext(),res, Toast.LENGTH_SHORT).show();
           /* Getting Contacts and Deserialization of data */
		    ob=new Gson().fromJson(ConnectionManager.res, LoginRadiusContact[].class);
            }catch(Exception e){}        
        /*Dynamic generated contacts */
        
        //create the RadioGroup
        final RadioButton[] rb = new RadioButton[ob.length];
        rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for(int i=0; i<ob.length; i++)
        {
            rb[i]  = new RadioButton(this);
            rb[i].setText(ob[i].name);
            rb[i].setId(i);
            rg.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout
 
        }
        ll.addView(rg);
    
        //Adding Button
        Button b = new Button(this);
        b.setText("Send");
        b.setId(1);
        ll.addView(b);
        b.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) 
            {
                // TODO Auto-generated method stub
                try
                {
                    int selected = rg.getCheckedRadioButtonId();
                    v=rg.findViewById(selected);
                    int idx=rg.indexOfChild(v); //Getting ID of Selected radio button
                    
                    Toast.makeText(getBaseContext(), "Method 2 ID = "+String.valueOf(idx),Toast.LENGTH_SHORT).show();                    
                    Message msg=new Message();
                    returnurl= msg.sendMessage(Token,LoginRadius.Api_Secrete,ob[idx].id,"subject",edt.getText().toString());
                    //Toast.makeText(getApplicationContext(),returnurl, Toast.LENGTH_SHORT).show();
                    edt.setText("");
                    //String response=new Utility().execute(returnurl).get();
                    ConnectionManager.res=null;
                    ConnectionManager.createConnection(returnurl);
                    while(ConnectionManager.res==null){}
                    Boolean issuccess = Boolean.parseBoolean(ConnectionManager.res.toLowerCase());
                    if(issuccess)
                        Toast.makeText(getBaseContext(), "Your message has been sent",Toast.LENGTH_SHORT).show();        
                    
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                
             }
        });
       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_message, menu);
		return true;
	}

}
