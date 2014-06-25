package com.example.androidmannagg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.*;

public class MainUtente extends Activity {

	Button eventi, piscine;
	TextView logout;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuutente);
        
        eventi = (Button) findViewById(R.id.eventi);
        piscine = (Button) findViewById(R.id.piscineutente);
        
        eventi.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	
	            
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), ScegliProvinciaUtente.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);
	            //finish();
	        	}
	        
	
	});
        
        piscine.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	
	            
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), MappaPiscineUtente.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);
	            //finish();
	        	}
	        
	
	});
        

		logout = (TextView) findViewById(R.id.logout); 
		SpannableString content = new SpannableString("Log out");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		logout.setText(content);
		logout.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	MainActivity.user=null;
	        	
	        	/*Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
	        	
	        	startActivity(nextScreen);*/
	        	finish();
	        	
	        }
	});
	}
}
