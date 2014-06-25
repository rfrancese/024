package com.example.androidmannagg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ModificaEventoUtente extends Activity {

	Button edit;
	EditText testo;
	Bundle extras;
	String evento;
	ModificaEvenThread edithread;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserisciinfoevento);
	
        extras  = getIntent().getExtras();
        
        evento = extras.getString("Nome");
        
        edit = (Button) findViewById(R.id.editbutton);
        testo = (EditText) findViewById(R.id.testo);
        
        edit.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	//Intent nextScreen = new Intent(getApplicationContext(),  MappaEventiUtente.class);

	            //Sending data to another Activity
	        	
	            String t = testo.getText().toString();
	            
	            t = t.replace(" ", "_");
	            evento = evento.replace(" ", "_");
	            
	            edithread = new ModificaEvenThread(evento,t);
	            
	            edithread.start();
	            while(edithread.getFlag()==0){}
	            String resp = edithread.getResponso();
	            edithread.interrupt(); edithread=null;
	            if(resp.equals("Errore")) 
	            	Toast.makeText(getApplicationContext(),
	                        "Errore nell'inserimento!", Toast.LENGTH_SHORT)
	                        .show();
	            else{
	            //startActivity(nextScreen);
	            	Toast.makeText(getApplicationContext(),
	                        "Richiesta inviata!", Toast.LENGTH_SHORT)
	                        .show();
	            finish();
	            }
	        	
	        }
	        
        });
        
	}
	
}
