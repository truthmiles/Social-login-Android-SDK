package com.LoginRadius.lr_android_sdk;

import java.io.IOException;
import java.net.URLEncoder;

import android.net.Proxy;

public class StatusPost {
	 Utility util = new Utility();

	    public boolean PostStatus(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description) throws IOException, Exception {
	        return UpdateProcessRequest(token, secret, to, title, link, imageurl, message, caption, description, null);
	    }

	
	 
	    private boolean UpdateProcessRequest(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description, Proxy proxy) throws IOException, Exception {
	        boolean issuccess;

	        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

	            String url = String.format("http://"+Config.Domain+"/status/update/%s/%s?to=%s&title=%s&url=%s&imageurl=%s&status=%s&caption=%s&description=%s", URLEncoder.encode( secret),URLEncoder.encode( token), URLEncoder.encode(to), URLEncoder.encode(title), URLEncoder.encode(link), URLEncoder.encode(imageurl), URLEncoder.encode(message), URLEncoder.encode(caption),URLEncoder.encode( description));

	            String interfaceresponse = util.httpGetRequest(url, proxy);

	            issuccess = Boolean.parseBoolean(interfaceresponse.toLowerCase());

	        } else {
	            throw new Exception("Invalid Api key please use valid Guid format api key");
	        }

	        return issuccess;
	    }


}
