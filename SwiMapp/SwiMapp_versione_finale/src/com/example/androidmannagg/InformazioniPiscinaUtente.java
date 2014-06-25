package com.example.androidmannagg;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InformazioniPiscinaUtente extends Activity {
	TextView nome, info, sito;
	Bundle extras;
	Button editpiscina;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		
		//Button indietro;
        setContentView(R.layout.informazionipiscinautente);
		
        extras  = getIntent().getExtras();
        
        String nomePiscina = extras.getString("Titolo");
        String infoPiscina = extras.getString("Info");
        String sitoPiscina = extras.getString("Sito");
        
        nome = (TextView) findViewById(R.id.piscinautente);
        info = (TextView) findViewById(R.id.infopiscinautente);
        sito = (TextView) findViewById(R.id.sitopiscinautente);
        
        editpiscina = (Button) findViewById(R.id.editpiscina);
        
        nome.setText(nomePiscina);
        info.setText(infoPiscina);
        sito.setText(sitoPiscina);
		
		/*---------------------button indietro-------------*/
		
       
        editpiscina.setOnClickListener(new View.OnClickListener() {

	        public void onClick(View arg0) {
	        	
	        	Intent nextScreen = new Intent(getApplicationContext(), ModificaPiscinaUtente.class);
	        	nextScreen.putExtra("Nome", nome.getText().toString());
	            startActivity(nextScreen);
	        	
	        }
	    });
	    
		
		
		}
	
}