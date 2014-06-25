package com.example.androidmannagg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class AggiungiPiscina extends Activity {

	EditText piscina,indirizzo,citta;
	Button add;
	AddPiscinaThread a;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.aggiungipiscina);
        
        piscina = (EditText) findViewById(R.id.nomepiscina);
        indirizzo = (EditText) findViewById(R.id.indirizzo);
        citta = (EditText) findViewById(R.id.paese);
        
        add = (Button) findViewById(R.id.aggiungipiscina);
        
        add.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	//Intent nextScreen = new Intent(getApplicationContext(),  MappaEventiUtente.class);

	            //Sending data to another Activity

	            String p = piscina.getText().toString();
	            String i = indirizzo.getText().toString();
	            String c = citta.getText().toString();
	            
	            p = p.replace(" ", "_");
	            i = i.replace(" ", "_");
	            c = c.replace(" ", "_");
	            
	            a = new AddPiscinaThread(p,i,c);
	            
	            a.start();
	            while(a.getFlag()==0){}
	            String resp = a.getResponso();
	            a.interrupt(); a=null;
	            if(resp.equals("Errore")) 
	            	Toast.makeText(getApplicationContext(),
	                        "Errore nell'inserimento!", Toast.LENGTH_SHORT)
	                        .show();
	            else{
	            //startActivity(nextScreen);
	            	Toast.makeText(getApplicationContext(),
	                        "Dati inviati!", Toast.LENGTH_SHORT)
	                        .show();
	            finish();
	            }
	        	
	        }
	        
        });
        
	}
	
}
