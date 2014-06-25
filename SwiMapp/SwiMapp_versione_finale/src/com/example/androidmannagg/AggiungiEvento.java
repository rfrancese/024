package com.example.androidmannagg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AggiungiEvento extends Activity {

	EditText evento,data,luogo,citta;
	Button add;
	AddEventhread a;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.aggiungievento);
        
        evento = (EditText) findViewById(R.id.nomeevento);
        data = (EditText) findViewById(R.id.dataevento);
        luogo = (EditText) findViewById(R.id.luogo);
        citta = (EditText) findViewById(R.id.citta);
        
        add = (Button) findViewById(R.id.aggiungi);
        
        add.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	//Intent nextScreen = new Intent(getApplicationContext(),  MappaEventiUtente.class);

	            //Sending data to another Activity

	            String n = evento.getText().toString();
	            String d = data.getText().toString();
	            String l = luogo.getText().toString();
	            String c = citta.getText().toString();
	            
	            n = n.replace(" ", "_");
	            d = d.replace(" ", "_");
	            l = l.replace(" ", "_");
	            c = c.replace(" ", "_");
	            
	            a = new AddEventhread(n,d,l,c);
	            
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
