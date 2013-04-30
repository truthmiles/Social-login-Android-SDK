package example.mobb_sdk;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DisplayData extends Activity {
     String value="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_data);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    value = extras.getString("new_variable_name");
		}
		TextView tv=(TextView)findViewById(R.id.display);
		tv.setText(value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_data, menu);
		return true;
	}

}
