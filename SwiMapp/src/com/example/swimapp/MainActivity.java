package com.example.swimapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
		Button eventi;
		
		
		
		eventi = (Button) findViewById(R.id.eventi);
		 
	    //Listening to button event
	    eventi.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), ScegliProvincia.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);

	        }
	    });
	}
	
	
	
	

}
