package com.LoginRadius.lr_android_sdk;

import android.util.Log;


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
