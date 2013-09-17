package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreBoardActivity extends Activity {

	
	private TextView coinsCloud, coinsMemory;
	ImageView medalClouds, medalMemory;
	ImageButton next;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.statistics_screen);
	    
	    declareVariables();
	    setCoins();
	    setMedals();
	    next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ScoreBoardActivity.this, GameMap.class);
				startActivity(intent);				
			}
		});
	    
	    
	}
	
	
	private void declareVariables(){
		coinsCloud = (TextView) findViewById(R.id.cloudGameCoins);
		coinsMemory = (TextView) findViewById(R.id.memoryGameCoins);
		medalClouds = (ImageView) findViewById(R.id.cloudGameMedal);
		medalMemory = (ImageView) findViewById(R.id.memoryMedal);
		next = (ImageButton) findViewById(R.id.arrow);
		
	}
	
	private void setCoins(){
		coinsCloud.setText(""+Constants.coinsCloudGame);
		coinsMemory.setText(""+Constants.coinsMemoryGame);
	}
	
	private void setMedals(){
		
		switch (Constants.getCloudGameMedal()) {
		
		case Constants.gold:
			medalClouds.setImageResource(R.drawable.gold_150);
			break;

		case Constants.silver:
			medalClouds.setImageResource(R.drawable.silver_150);
			break;
		case Constants.bronze:
			medalClouds.setImageResource(R.drawable.bronze_150);
			break;
		}
		
		switch (Constants.getMemoryGameMedal()) {
		
		case Constants.gold:
			medalMemory.setImageResource(R.drawable.gold_150);
			break;

		case Constants.silver:
			medalMemory.setImageResource(R.drawable.silver_150);
			break;
		case Constants.bronze:
			medalMemory.setImageResource(R.drawable.bronze_150);
			break;
		}
	}
	
	
	
	

}
