package example.mobb_sdk;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import android.net.Proxy;

public class Message 
{
	/**
 	*sendMessage
 	*
 	* this function used for send message by user 
 	*  
 	* @param token Authentication token
 	* @param secret LoginRadius apikey Secret
 	* @param sendto User id which will Receive message
 	* @param subject Message subject
 	* @param message Message text  
 	*/
	
	public String sendMessage(String token, String secret, String sendto, String subject, String message) throws IOException, Exception 
    {
           return UpdateProcessRequest(token, secret, sendto, subject, message, null);
    }
    
    public String UpdateProcessRequest(String token, String secret, String sendto, String subject, String message, Proxy proxy) throws IOException, Exception 
    {
           String url;

           if (Message.isValidGuid(token) && Message.isValidGuid(secret)) 
          {
               url = String.format("http://"+Config.Domain+"/directmessage/%s/%s?sendto=%s&subject=%s&message=%s", URLEncoder.encode(secret), URLEncoder.encode(token), URLEncoder.encode(sendto), URLEncoder.encode(subject),URLEncoder.encode( message));
               
		  } else {
              throw new Exception("Invalid Api key please use valid Guid format api key");
          }
		  return url;
    }
    /* To check Valid API Guid Format */
	public static boolean isValidGuid(String guid) 
    {

           String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
           return Pattern.matches(pattern, guid);
     }

}
