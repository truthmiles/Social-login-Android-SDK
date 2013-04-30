package LoginRadiusDataObject;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusEvent {
	@SerializedName("ID")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("RsvpStatus")
    public String rsvpStatus;
    @SerializedName("Location")
    public String location;

}
