package com.example.backandforth2014;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	static public String url;
	
	static final private String LOG_TAG = "main";
	public String WEBSITE = "tittle";
	public String URL = "url";
	
	public class listItem {
		String website;
		String url;
	}
	
	AppInfo appInfo;
	//CustomAdapter customListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		appInfo = AppInfo.getInstance(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences settings = getSharedPreferences(MainActivity.url, 0);
		
	}
	
	public void goOther(View V) {
		// Grab the text, and store it in a preference.
		SharedPreferences settings = getSharedPreferences(url, 0);
		SharedPreferences.Editor editor = settings.edit();
	    //editor.putString(PREF_STRING_1, );
	    //editor.commit();
	    
	    // Let's produce a string that serializes our class, just for the fun of it.
	    SerialMe me = new SerialMe();
	    me.myInt = 5;
	    me.myString = "luca";
	    // Let's build a serializer.
	    Gson gson = new Gson();
	    String s = gson.toJson(me);
	    Log.i(LOG_TAG, s);
	    
	    // Let's deserialize it now.
	    SerialMe alter = gson.fromJson(s, SerialMe.class);
	    Log.i(LOG_TAG, alter.myString);
	    String s2 = gson.toJson(appInfo);
	    AppInfo a = gson.fromJson(s2, AppInfo.class);
	    
		// Go to second activity
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
	
	

}
