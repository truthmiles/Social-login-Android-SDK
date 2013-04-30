package example.mobb_sdk;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import android.net.Proxy;

public class GetEvents 
{
	GetEvents ge; 
    
	/**
  	*getEvents
 	*
 	* this function used for get user events
 	*  
 	* @param token Authentication token
 	* @param secret LoginRadius apikey Secret
 	*/
	public String getEvents(String token, String secret) throws IOException, Exception 
    {
            return ProcessRequest(token, secret, null);
    }
    public String ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception 
    {
            
          String url;
          if (ge.isValidGuid(token) && ge.isValidGuid(secret)) 
          {
				 url = String.format("http://"+Config.Domain+"/GetEvents/%s/%s", URLEncoder.encode(secret),URLEncoder.encode( token));
		  } else 
		  {
                throw new Exception("Invalid Api key please use valid Guid format api key");
          }
           return url;

     }
     /* to check  valid API Guid Format */
	 public static boolean isValidGuid(String guid) 
     {

            String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
            return Pattern.matches(pattern, guid);
     }

}
