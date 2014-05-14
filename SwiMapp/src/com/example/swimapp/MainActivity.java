package com.example.swimapp;



import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

public class MainActivity extends Activity {
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
		Button eventi, piscine, esci;
		
		
		/*---------------------button eventi-------------*/
		
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
	    
	    
		/*------------------button piscine--------------*/
		
		piscine = (Button) findViewById(R.id.piscine);
			 
		    //Listening to button event
		piscine.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), MappaPiscine.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);

	        }
	    });
		
		/*-----------------button esci------------------*/
		
		esci = (Button) findViewById(R.id.esci);
		 
	    //Listening to button event
	esci.setOnClickListener(new View.OnClickListener() {

        public void onClick(View arg0) {
            //Starting a new Intent
           
        	finish();

        }
    });
	}
	
	
	

}
