package com.example.androidmannagg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InformazioneEvento extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		TextView nome, info;
		Bundle extras;
		//Button indietro;
        setContentView(R.layout.infoevento);
		
        extras  = getIntent().getExtras();
        
        String nomeEvento = extras.getString("Titolo");
        String infoEvento = extras.getString("Info");
        
        nome = (TextView) findViewById(R.id.evento);
        info = (TextView) findViewById(R.id.info);
        
        nome.setText(nomeEvento);
        info.setText(infoEvento);
        
        
		
		/*---------------------button indietro-------------*/
		
       
	    
	    
		
		
		}
	
}