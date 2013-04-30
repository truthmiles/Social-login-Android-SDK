package example.mobb_sdk;

import LoginRadiusDataObject.*;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.gson.Gson;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

/**
 *Status class
 * 
 * Status class which is  containing function for update  user status
 */
public class Statuses {


/*
 *postStatus
 *
 * this function used for  post status by user on wall
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param to Proxy host
 * @param title Status title 
  * @param link Link which image user want to post on wall
 * @param imageurl Imageurl which image user want to post on wall
 * @param message Status message
 * @param caption Status caption
 * @param description Status description
 */
    public void postStatus(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description) throws IOException, Exception {
        UpdateProcessRequest(token, secret, to, title, link, imageurl, message, caption, description, null);
    }

     
    private void UpdateProcessRequest(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description, Proxy proxy) throws IOException, Exception {
        
            String url = String.format("http://"+Config.Domain+"/status/update/%s/%s?to=%s&title=%s&url=%s&imageurl=%s&status=%s&caption=%s&description=%s", URLEncoder.encode( secret),URLEncoder.encode( token), URLEncoder.encode(to), URLEncoder.encode(title), URLEncoder.encode(link), URLEncoder.encode(imageurl), URLEncoder.encode(message), URLEncoder.encode(caption),URLEncoder.encode( description));
            // call to get response from the above url by implementing it in threads
            ConnectionManager.createConnection(url);
     }
    
    
  
}
