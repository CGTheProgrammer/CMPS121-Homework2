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

	static final public String MYPREFS = "myprefs";
	static final public String PREF_STRING_1 = "string_1";
	
	static final private String LOG_TAG = "main";
	
	AppInfo appInfo;
	
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
		SharedPreferences settings = getSharedPreferences(MainActivity.MYPREFS, 0);
		String myText = settings.getString(MainActivity.PREF_STRING_1, "");
		EditText edv = (EditText) findViewById(R.id.editText1);
		edv.setText(myText);
	}
	
	
	
	public void goOther(View V) {
		// Grab the text, and store it in a preference.
		EditText edv = (EditText) findViewById(R.id.editText1);
		String text1 = edv.getText().toString();
		SharedPreferences settings = getSharedPreferences(MYPREFS, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putString(PREF_STRING_1, text1);
	    editor.commit();
	    
	    // The second string we store it in the singleton class.
		EditText edv2 = (EditText) findViewById(R.id.editText2);
		String text2 = edv2.getText().toString();
	    appInfo.sharedString = text2;
	    
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
