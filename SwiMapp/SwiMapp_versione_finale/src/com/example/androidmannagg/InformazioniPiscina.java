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

public class InformazioniPiscina extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		TextView nome, info, sito;
		Bundle extras;
		//Button indietro;
        setContentView(R.layout.informazioni);
		
        extras  = getIntent().getExtras();
        
        String nomePiscina = extras.getString("Titolo");
        String infoPiscina = extras.getString("Info");
        String sitoPiscina = extras.getString("Sito");
        
        nome = (TextView) findViewById(R.id.piscina);
        info = (TextView) findViewById(R.id.info);
        sito = (TextView) findViewById(R.id.sito);
        
        nome.setText(nomePiscina);
        info.setText(infoPiscina);
        sito.setText(sitoPiscina);
		
		/*---------------------button indietro-------------*/
		
       
	    
	    
		
		
		}
	
}
