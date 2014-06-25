package com.example.androidmannagg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoSW extends Activity {

	TextView info;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.infosw);
        
        info = (TextView) findViewById(R.id.infosw);
        
        info.setText("Versione Software: 1.0\n");
        info.append("Sviluppatori: Emanuele Petagna\n\t Emanuele Caso\n");
        
	}
	
}
