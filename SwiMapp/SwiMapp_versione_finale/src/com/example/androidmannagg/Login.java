package com.example.androidmannagg;

import java.util.ArrayList;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class Login extends Activity{
	EditText username, password;
    Button login, registrati;
    ThreadLogin t;
    Utente _utenti;
    JSONERUtenti json;
    public static int flag=0;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.login);
        
       
        _utenti = new Utente();
        
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        
        login = (Button) findViewById(R.id.login);
        registrati = (Button) findViewById(R.id.registrati);

        registrati.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), Registrati.class);

	            //Sending data to another Activity
	            

	            startActivity(nextScreen);
	            
	            finish();
	            
	        	}
	        
	    });
        
        
        
        login.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), MainUtente.class);
	            
	            //Sending data to another Activity
	            t = new ThreadLogin(username.getText().toString(), password.getText().toString());
	            
	            t.start();

		       
	           while(t.getFlag()!=1){}
	           _utenti = t.inviaDati();
	           t.interrupt(); t = null;
	           
	          
	           
	           if(_utenti!=null){
	            startActivity(nextScreen);
	            MainActivity.user=_utenti.getUsername();
	            _utenti = null;
	            finish();} 
	           else
	            Toast.makeText(getApplicationContext(),
	                    "Username o password errati", Toast.LENGTH_SHORT)
	                    .show();
	            
	            
	        	}
	        
	    });
	
	}
	
	

}
