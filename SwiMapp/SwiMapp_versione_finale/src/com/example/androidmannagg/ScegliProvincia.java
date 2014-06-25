package com.example.androidmannagg;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
 
public class ScegliProvincia extends Activity {
 
  private Spinner spinner1;
  private Button btnSubmit;
  private String value;

  Intent nuovaPagina, indietro;
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.scegliprovincia);
	
	addListenerOnButton();
	addListenerOnSpinnerItemSelection();
  }
 
  // add items into spinner dynamically
 
  public void addListenerOnSpinnerItemSelection() {
	spinner1 = (Spinner) findViewById(R.id.spinner1);
	spinner1.setOnItemSelectedListener(new CustomOnItemListener());
  }

	
  // get the selected dropdown list value
  public void addListenerOnButton() {
	spinner1 = (Spinner) findViewById(R.id.spinner1);
	btnSubmit = (Button) findViewById(R.id.cerca);
	
	btnSubmit.setOnClickListener(new OnClickListener() {
	  @Override
	  public void onClick(View v) {
 
		  value = String.valueOf(spinner1.getSelectedItem());
		  
			nuovaPagina = new Intent(getApplicationContext(), MappaEventi.class);
					  
			nuovaPagina.putExtra("Provincia", value);
			
			startActivity(nuovaPagina);
	  }

	  
	});
	
	
	
	
	
  }
  
}