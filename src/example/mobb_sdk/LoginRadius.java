package example.mobb_sdk;

import java.io.IOException;
import java.net.Proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LoginRadius {

	public static boolean IsAuthenticated = false;
    public String Resonse;
    public static String Api_Secrete = "";
    public static String Api_Key = "";
    public static String lrjsonresponse;
    public static String Token=null;
    public Context mApplicationContext;
    public Activity mActivityContext;
    public static LRInterface lr_interface;
    /*
     * LoginRadius
     *
     * Load Constructor.
     *
     * @param Context  The Android Context used to access to system resources
     * @param key LoginRadius App API Key
     * @param Secrete LoginRadius App API Secret
     * @param in the object that implements LRInterface
     */
    public LoginRadius(){}
    public LoginRadius(Context context,String key, String Secrete,LRInterface in){
    	Api_Key=key;
    	Api_Secrete=Secrete;
    	lr_interface=in;
    	mApplicationContext=context;
    	mActivityContext = (Activity) context;
    	 showProviderList();
    	      
    }
    
    
   /* public LoginRadius(String Token) throws Exception 
    {
    	        ProcessRequest(Token, Api_Secrete, null);
    }*/
    
    
    /*
     * @param key LoginRadius App API Key
     * @param Secrete LoginRadius App API Secret 
     */
    public String ProcessRequest(String Token, String Api_Secrete) throws IOException {
        
               Utility util =new Utility();
               final String url = "http://"+Config.Domain+"/userprofile/" + Api_Secrete+ "/" + Token;
                try
                {
                	// call thread(AsyncTask) to call UserProfile API in background
                	ConnectionManager.createConnection(url);
                }
                catch(Exception e){}
                // this is not handled till now because of using threads
                /*if (ConnectionManager.res!= null) {
                    IsAuthenticated = true;
                } else {
                    IsAuthenticated = false;
                }*/
                return url;
    }
    
    public void showProviderList(){
    	 ProviderList pl=new ProviderList();
    	 pl.getProvider(mApplicationContext);
    	 
    }
}
