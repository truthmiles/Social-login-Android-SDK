package example.mobb_sdk;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;
	
	/**
	/* This class is used 
	for running AsyncTask 
	in background
	*/
public class ConnectionManager {
	public static String res=null;
    private static final String TAG = ConnectionManager.class.getSimpleName();
    public static void createConnection(final String url)
    {
        final Utility obj=new Utility();
        
		/*Run Thread in background */
		ThreadUtils.executeInBg(new Runnable() {
        public void run() 
        {
            try
            {
                res=obj.httpGetRequest(url, null);
                Log.e(TAG, res);
            }
            catch(Exception e){}
        
        }
        });
        
    }    

}
