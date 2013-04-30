package example.mobb_sdk;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import android.net.Proxy;

public class GetContacts 
{
	GetContacts gc;
    
    /**
 	*getContacts
 	*
 	* this function used for get user contact
 	*
 	* @param token Authentication token
 	* @param secret LoginRadius App API Secret
 
 	*/
	public String getContacts(String token, String secret) throws IOException, Exception 
    {
        return ProcessRequest(token, secret, null);
    }
     public String ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception 
     {
         String res;
         String url;

            if (gc.isValidGuid(token) && gc.isValidGuid(secret)) 
            {
                    url = String.format("http://"+Config.Domain+"/contacts/%s/%s", URLEncoder.encode(secret),URLEncoder.encode(token));

            } 
            else 
            {
				throw new Exception("Invalid Api key please use valid Guid format api key");
            }
            return url;

     }
     public static boolean isValidGuid(String guid) 
     {

            String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
            return Pattern.matches(pattern, guid);
     }
     
}
