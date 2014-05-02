package com.example.backandforth2014;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

	AppInfo appInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		appInfo = AppInfo.getInstance(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		// Writes the string from main activity.
		SharedPreferences settings = getSharedPreferences(MainActivity.MYPREFS, 0);
		String myText = settings.getString(MainActivity.PREF_STRING_1, "");
		TextView tv = (TextView) findViewById(R.id.textView2);
		tv.setText(myText);
		
		// and the one from the singleton object
		TextView tv2 = (TextView) findViewById(R.id.textView3);
		tv2.setText(appInfo.sharedString);		
		
	}
	
	public void clickBack(View V) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		// finish();
	}


}
