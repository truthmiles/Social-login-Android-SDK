package example.mobb_sdk;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import android.net.Proxy;

public class Companies {
	Companies com; 
    
	/**
 	*getCompanies
 	*
 	* this function used for get company name which is following by user
 	*
 	* @param token Authentication token
 	* @param secret LoginRadius App API Secret
 
 	*/
	public String getCompanies(String token, String secret) throws IOException, Exception 
     {
            return ProcessRequest(token, secret, null);
     }
     public String ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception 
     {
            String url;
            if (com.isValidGuid(token) && com.isValidGuid(secret)) 
            {
                    url = String.format("http://"+Config.Domain+"/GetCompany/%s/%s",URLEncoder.encode(secret),URLEncoder.encode( token));

			} 
            else 
            {
                throw new Exception("Invalid Api key please use valid Guid format api key");
            }
            return url;

      }
     /*To check valid API Key Guid format */
	 
	 public static boolean isValidGuid(String guid) 
     {

            String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
            return Pattern.matches(pattern, guid);
     }


}
