package com.example.swimapp;

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
 
public class MappaPiscine extends Activity {
 
  private Button back;
  Intent indietro;
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.mappapiscine);
 
	indietro = new Intent(this, MainActivity.class);

	back = (Button) findViewById(R.id.indietro);

	addListenerOnButton();
  }
 
 

	
  // get the selected dropdown list value
  public void addListenerOnButton() {
 
	
	
	back.setOnClickListener(new OnClickListener() {
		  @Override
		  public void onClick(View v) {
	 
				startActivity(indietro);
		  }
		  

		  
	 
		});
	
  }
}