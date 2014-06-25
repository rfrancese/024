package com.example.androidmannagg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ModificaPiscinaUtente extends Activity {

	Button edit;
	EditText testo;
	Bundle extras;
	String piscina;
	ModificaPiscinaThread edithread;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserisciinfopiscina);
	
        extras  = getIntent().getExtras();
        
        piscina = extras.getString("Nome");
        
        edit = (Button) findViewById(R.id.editbuttonpiscina);
        testo = (EditText) findViewById(R.id.testopiscina);
        
        edit.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	//Intent nextScreen = new Intent(getApplicationContext(),  MappaEventiUtente.class);

	            //Sending data to another Activity
	        	
	            String t = testo.getText().toString();
	            
	            t = t.replace(" ", "_");
	            piscina = piscina.replace(" ", "_");
	            
	            edithread = new ModificaPiscinaThread(piscina,t);
	            
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