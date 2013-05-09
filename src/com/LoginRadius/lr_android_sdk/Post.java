package com.LoginRadius.lr_android_sdk;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import android.net.Proxy;

public class Post 
{
	String url;
    
	/**
 	*getPosts
 	*
 	* this function used for  get user posts
 	*  
 	* @param token Authentication token
 	* @param secret LoginRadius apikey Secret
	*/
	
	public String getPosts(String token, String secret) throws IOException, Exception 
    {
        return ProcessRequest(token, secret, null);
    }
     private String ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception 
     {
            
            if (Post.isValidGuid(token) && Post.isValidGuid(secret)) 
            {
                url = String.format("http://"+Config.Domain+"/GetPosts/%s/%s", URLEncoder.encode(secret), URLEncoder.encode(token));
			} 
            else 
            {
                throw new Exception("Invalid Api key please use valid Guid format api key");
            }
            return url;

     }
     /* To check Valid API Guid format */
	 public static boolean isValidGuid(String guid) 
     {

            String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
            return Pattern.matches(pattern, guid);
     }
}
