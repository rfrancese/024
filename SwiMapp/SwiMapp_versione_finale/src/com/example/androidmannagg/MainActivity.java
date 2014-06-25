package com.example.androidmannagg;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	
	public static String user=null; 
	TextView messaggio, login, infosw;
	Button eventi, piscine;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		
        setContentView(R.layout.fragment_main);
		

        if(!isNetworkAvailable()){
        	Toast.makeText(getApplicationContext(),
                    "Nessuna connessione Internet", Toast.LENGTH_SHORT)
                    .show();
        }
		
		/*---------------------button eventi-------------*/
		
		eventi = (Button) findViewById(R.id.eventi);
		 
	    //Listening to button event
	    eventi.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	if(!isNetworkAvailable()){
	            	Toast.makeText(getApplicationContext(),
	                        "Nessuna connessione Internet", Toast.LENGTH_SHORT)
	                        .show();
	            }
	        	else{
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), ScegliProvincia.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);
	        	}
	        }
	    });
	    
	    
		/*------------------button piscine--------------*/
		
		piscine = (Button) findViewById(R.id.cercapiscine);
			 
		    //Listening to button event
		piscine.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	if(!isNetworkAvailable()){
	            	Toast.makeText(getApplicationContext(),
	                        "Nessuna connessione Internet", Toast.LENGTH_SHORT)
	                        .show();
	            }
	        	else{
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), MappaPiscine.class);

	            //Sending data to another Activity
	            
	            startActivity(nextScreen);
	        	}
	        }
	    });
		
		
		login = (TextView) findViewById(R.id.login); 
		SpannableString content = new SpannableString("Area utenti");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		login.setText(content);
		login.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	if(!isNetworkAvailable()){
	            	Toast.makeText(getApplicationContext(),
	                        "Nessuna connessione Internet", Toast.LENGTH_SHORT)
	                        .show();
	            }
	        	else{
	            //Starting a new Intent
	        		Intent nextScreen;
	        	if(user==null)
	             nextScreen = new Intent(getApplicationContext(), Login.class);
	            
	            //Sending data to another Activity
	        	else nextScreen = new Intent(getApplicationContext(), MainUtente.class);
	            startActivity(nextScreen);
	            
	        	}
	        	
	        	
	        }
	    });
		
		/*infosw = (TextView) findViewById(R.id.clickinfo); 
		SpannableString content_2 = new SpannableString("Informazioni software");
		content_2.setSpan(new UnderlineSpan(), 0, content_2.length(), 0);
		infosw.setText(content_2);
		infosw.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	            //Starting a new Intent
	        		Intent nextScreen;
	             nextScreen = new Intent(getApplicationContext(), InfoSW.class);
	            
	            //Sending data to another Activity
	        	
	            startActivity(nextScreen);
	            
	        	}
	        	
	        	
	        
	    });*/
		
		}
       
	
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();  
	    return activeNetworkInfo != null;
	}
	

}
