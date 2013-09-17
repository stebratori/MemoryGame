package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ShopActivity extends Activity  implements OnClickListener {

	ImageButton hero, cowboy, indian, pirate;
	AlertDialog.Builder dialog;
	AlertDialog alert;
	Button back;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.shop);
	    
	    generateVariables();
	}

	
	private void generateVariables(){
		hero = (ImageButton) findViewById(R.id.shopFessorHero);
		hero.setOnClickListener(this);
		cowboy = (ImageButton) findViewById(R.id.shopFessorCowboy);
		cowboy.setOnClickListener(this);
		indian = (ImageButton) findViewById(R.id.shopFessorIndian);
		indian.setOnClickListener(this);
		pirate = (ImageButton) findViewById(R.id.shopFessorPirate);
		pirate.setOnClickListener(this);
		back = (Button) findViewById(R.id.mrzimAndroid);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent (ShopActivity.this, GameMap.class);
				startActivity(i);
				
			}
		});
	}


	@Override
	public void onClick(View v) {
		
		if (Constants.overallCoins > 10){
			Constants.setOverallCoins(Constants.getOverallCoins()-10);
			
			switch (v.getId()) {
			case R.id.shopFessorHero:
				buildDialog(Constants.fessorHero);
				
				break;

			case R.id.shopFessorCowboy:
				buildDialog(Constants.fessorCowboy);
				break;
		
		
			case R.id.shopFessorIndian:
				buildDialog(Constants.fessorIndian);
				break;
		
	
			case R.id.shopFessorPirate:
				buildDialog(Constants.fessorPirate);
				break;
				
			
		
		}
			
		}
		else{
			notEnoughCoinsDialog();
			
		}
		
		
	}
	
	
	public void buildDialog(final int costume){
		dialog = new AlertDialog.Builder(this);
		dialog.setMessage("OMG");
		dialog.setCancelable(true);
		dialog.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Constants.setFessor_costume(costume);
					coinSound();
				
				}
				});
		dialog.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
				});
		alert = dialog.create();
		alert.show();
	}
	
	public void notEnoughCoinsDialog(){
		dialog = new AlertDialog.Builder(this);
		dialog.setMessage("Not enough coins!");
		dialog.setCancelable(false);
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				
			}
		});
		alert = dialog.create();
		alert.show();
	}
	
	
	
	private void coinSound(){
		final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.coins_sound);
		mp1.start();
	}
}
