package com.example.androidmannagg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrati extends Activity {
	EditText username, password, nome, cognome;
    Button registrati;
    Registhread reg;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.registrati);
        
        
        
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        
        registrati = (Button) findViewById(R.id.registrati);
        
        registrati.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	
	            //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), Login.class);

	            //Sending data to another Activity

	            String user = username.getText().toString();
	            String pass = password.getText().toString();
	            String n = nome.getText().toString();
	            String c = cognome.getText().toString();
	            
	            n = n.replace(" ", "_");
	            c = c.replace(" ", "_");
	            
	            reg = new Registhread(user,pass,n,c);
	            
	            reg.start();
	            while(reg.getFlag()==0){}
	            String resp = reg.getResponso();
	            reg.interrupt(); reg=null;
	            if(resp.equals("Errore")) 
	            	Toast.makeText(getApplicationContext(),
	                        "Nome utente già presente!", Toast.LENGTH_SHORT)
	                        .show();
	            else{
	            	Toast.makeText(getApplicationContext(),
	                        "Registrazione effettuata!", Toast.LENGTH_SHORT)
	                        .show();
	            startActivity(nextScreen);
	            
	            finish();}
	            
	        	}
	        
	    });
        
	
	}
	
}
