package com.example.androidmannagg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class InformazioniEventoUtente extends Activity {
	TextView nome, info;
	Bundle extras;
	Button modifica;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		
        setContentView(R.layout.infoeventoutente);
		
        extras  = getIntent().getExtras();
        
        String nomeEvento = extras.getString("Titolo");
        String infoEvento = extras.getString("Info");
        
        nome = (TextView) findViewById(R.id.evento);
        info = (TextView) findViewById(R.id.info);
        
        modifica = (Button) findViewById(R.id.edit);
        
        nome.setText(nomeEvento);
        info.setText(infoEvento);
        
        
		
		/*---------------------button modifica-------------*/
		
       
	    modifica.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	Intent nextScreen = new Intent(getApplicationContext(), ModificaEventoUtente.class);
	        	nextScreen.putExtra("Nome", nome.getText().toString());
	            startActivity(nextScreen);
	        	
	        }
	    });
		
		}

}
