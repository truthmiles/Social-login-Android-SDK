package LoginRadiusDataObject;

import java.sql.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BasicUserLoginRadiusProfile 
{
    @SerializedName("ID")
    public String ID;
    @SerializedName("Provider")
    public String Provider;
    @SerializedName("Prefix")
    public String Prefix ;
    @SerializedName("FirstName")
    public String FirstName;
    @SerializedName("MiddleName")
    public String MiddleName;
    @SerializedName("LastName")
    public String LastName ;
    @SerializedName("Suffix")
    public String Suffix;
    @SerializedName("FullName")
    public String FullName ;
    @SerializedName("NickName")
    public String NickName ;
    @SerializedName("ProfileName")
    public String ProfileName ;
    @SerializedName("BirthDate")
    public String BirthDate ;
    @SerializedName("Gender")
    public String Gender;
    @SerializedName("ImageUrl")
    public String ImageUrl;
    @SerializedName("ThumbnailImageUrl")
    public String ThumbnailImageUrl;
    @SerializedName("Email")
    public List<LoginRadiusEmail> Email ;
    @SerializedName("Country")
    public LoginRadiusCountry Country ;
    @SerializedName("CreatedDate")
    public Date CreatedDate; 
    @SerializedName("ModifiedDate")
    public Date ModifiedDate  ;
    @SerializedName("LocalCountry")
    public String LocalCountry;  
    @SerializedName("ProfileCountry")
    public String ProfileCountry;
    

}
