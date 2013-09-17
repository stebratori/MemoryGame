package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class CountryPicker extends Activity implements OnClickListener{

	
	Button iceland, denmark, norway,sweden,faroe,finland;
	int country, operation;
	Intent i;
	Bundle extras;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.flag_picker);
		
		
		declareButtons();
		i = new Intent(this, GameMap.class);
		
		
	}

	
	@Override
	public void onBackPressed() {
	}

	@Override
	public void onClick(View v) {

		
		
		switch (v.getId()) {
		case R.id.flagIceland:
			
			Constants.setPresentCountry(Constants.iceland);
			Constants.setMemoryGameBackground(R.drawable.iceland);
			Constants.setMemoryGameBackground(R.drawable.iceland2);
			startActivity(i);
			
			break;

		case R.id.flagDenmark:
			
			   
			Constants.setPresentCountry(Constants.denmark);
			Constants.setMemoryGameBackground(R.drawable.denmark1);
			Constants.setMemoryGameBackground(R.drawable.denmark2);
			startActivity(i);
			break;
			
		case R.id.flagFaroe:

			   
			Constants.setPresentCountry(Constants.faroe);
			Constants.setMemoryGameBackground(R.drawable.faroe1);
			Constants.setMemoryGameBackground(R.drawable.faroe2);
			startActivity(i);
			break;

		case R.id.flagNorway:

			   
			Constants.setPresentCountry(Constants.norway);
			Constants.setMemoryGameBackground(R.drawable.norway1);
			Constants.setMemoryGameBackground(R.drawable.norway2);
			startActivity(i);
			break;
			
		case R.id.flagSweden:

			  
			Constants.setPresentCountry(Constants.sweden);
			Constants.setMemoryGameBackground(R.drawable.sweden1);
			Constants.setMemoryGameBackground(R.drawable.sweden2);
			startActivity(i);
			break;

		case R.id.flagFinland:

			   
			Constants.setPresentCountry(Constants.finland);
			Constants.setMemoryGameBackground(R.drawable.finland);
			Constants.setMemoryGameBackground(R.drawable.finland2);
			startActivity(i);
			break;
		}
		
	}

	

	public void declareButtons(){
		iceland = (Button) findViewById(R.id.flagIceland);
		iceland.setOnClickListener(this);
		denmark = (Button) findViewById(R.id.flagDenmark);
		denmark.setOnClickListener(this);
		faroe = (Button) findViewById(R.id.flagFaroe);
		faroe.setOnClickListener(this);
		norway = (Button) findViewById(R.id.flagNorway);
		norway.setOnClickListener(this);
		sweden = (Button) findViewById(R.id.flagSweden);
		sweden.setOnClickListener(this);
		finland = (Button) findViewById(R.id.flagFinland);
		finland.setOnClickListener(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
