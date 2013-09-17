package com.fessor.activity;

import java.util.Random;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.functions.EquationDecoder;
import com.fessor.functions.NumberGenerator;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Gameboard extends Activity implements AnimationListener{

	private Animation move1a,move2a,move3a, move4a, fadeIn, blink;
	private ImageView fessor, cloudQuestion;
	private ImageButton move1, move2, move3, move4, cloudAnswer1,cloudAnswer2,cloudAnswer3,cloudAnswer4;
	private TextView txtCloudEquation, txtCloudAnswer1,txtCloudAnswer2,txtCloudAnswer3,txtCloudAnswer4, gameboardCoins;
	private String equation,answer2,answer3,answer4;
	private boolean correct = false;
	private Random random = new Random();
	private Handler handler = new Handler();
	private Intent memoryGame;
	private int count=1;
	private int medalCounter;
	private int points = 0;
	private int equationValue;
	int redCloud,greenCloud,operation;
	LinearLayout layout;
	ImageView medal;
	
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gameboard);
	  
	    
	    declareVariables();
	    dressFessor();
	    generateClouds();
	    generateAnimations();
	    setBackground();
	    cloudsOnClickListeners();
	    
	    
	    handler.postDelayed(firstMove, 1000); 
	    
	
	}
	
	private void declareVariables(){
		memoryGame = new Intent(Gameboard.this, MemoryGame.class);
	    operation = Constants.plus;
	    answer2=null;
	    answer3=null;
	    redCloud = R.drawable.lil_cloud_1_red;
	    greenCloud = R.drawable.lil_cloud_1_green;
	    fessor = (ImageView) findViewById(R.id.fessorFigurine);
	    layout=(LinearLayout) findViewById(R.id.gameboard);
	    gameboardCoins = (TextView) findViewById(R.id.gameboardCoins);
	    gameboardCoins.setVisibility(View.INVISIBLE);
	    medal = (ImageView) findViewById(R.id.gameboardMedal);
	    medalCounter=0;
	    fessor = (ImageView) findViewById(R.id.fessorFigurine);
	   
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		if (animation==fadeIn){
			txtCloudEquation.setVisibility(View.VISIBLE);
			txtCloudAnswer1.setVisibility(View.VISIBLE);
			txtCloudAnswer2.setVisibility(View.VISIBLE);
			txtCloudAnswer3.setVisibility(View.VISIBLE);
			txtCloudAnswer4.setVisibility(View.VISIBLE);
			
			
		}
		
		if (animation==move4a){
			finishGame();
		}
		
		
		
	}

	@Override
	public void onBackPressed() {
	finish();
	}
	
	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	public void resetClouds(){
		cloudAnswer1.setImageResource(R.drawable.lil_cloud_1);
		cloudAnswer2.setImageResource(R.drawable.lil_cloud_1);
		cloudAnswer3.setImageResource(R.drawable.lil_cloud_1);
		cloudAnswer4.setImageResource(R.drawable.lil_cloud_1);
		
		
	}
	
	public void disableClouds(){
		cloudAnswer1.setEnabled(false);
		cloudAnswer2.setEnabled(false);
		cloudAnswer3.setEnabled(false);
		cloudAnswer4.setEnabled(false);
	}
	
	public void enableClouds(){
		cloudAnswer1.setEnabled(true);
		cloudAnswer2.setEnabled(true);
		cloudAnswer3.setEnabled(true);
		cloudAnswer4.setEnabled(true);
	}
	
	public boolean answer(String equation, String answer){
		
		equationValue = EquationDecoder.equationDecoder(equation);
		int answerValue = Integer.parseInt(answer);
		
		if (equationValue-answerValue==0){
			return true;
		}
		else {
			
			return false;
		}
		
	}
	
	public void generateEquation(){
		
		
		
		int result = random.nextInt(10-3)+3;
		
		answer2 = NumberGenerator.generateRandom(result, 3, 10);
		answer3 = NumberGenerator.generateRandom(result, answer2, 3, 10);
		answer4 = NumberGenerator.generateRandom(result, answer2, answer3, 3, 10);		
		
		String generated_equation = EquationDecoder.equationMaker(result, operation);
		
		
		int position = random.nextInt(5-1)+1;
		
		switch (position) {
		
		case 1:
			txtCloudAnswer1.setText(result+"");
			txtCloudAnswer2.setText(answer2);
			txtCloudAnswer3.setText(answer3);
			txtCloudAnswer4.setText(answer4);
			break;
			
		case 2:
			txtCloudAnswer2.setText(result+"");
			txtCloudAnswer1.setText(answer2);
			txtCloudAnswer3.setText(answer3);
			txtCloudAnswer4.setText(answer4);
			break;
		case 3:
			txtCloudAnswer3.setText(result+"");
			txtCloudAnswer2.setText(answer2);
			txtCloudAnswer1.setText(answer4);
			txtCloudAnswer4.setText(answer3);
			break;
				
		case 4:
			txtCloudAnswer4.setText(result+"");	
			txtCloudAnswer2.setText(answer2);
			txtCloudAnswer3.setText(answer3);
			txtCloudAnswer1.setText(answer4);
			break;

		}
		
		equation = generated_equation;
	}
	
	private void generateClouds(){
		cloudQuestion = (ImageView) findViewById(R.id.cloudQuestion);
	    cloudQuestion.setVisibility(View.INVISIBLE);
	    cloudAnswer1 = (ImageButton) findViewById(R.id.cloudAnswer1);
	    cloudAnswer1.setVisibility(View.INVISIBLE);
	    cloudAnswer2 = (ImageButton) findViewById(R.id.cloudAnswer2);
	    cloudAnswer2.setVisibility(View.INVISIBLE);
	    cloudAnswer3 = (ImageButton) findViewById(R.id.cloudAnswer3);
	    cloudAnswer3.setVisibility(View.INVISIBLE);
	    cloudAnswer4 = (ImageButton) findViewById(R.id.cloudAnswer4);
	    cloudAnswer4.setVisibility(View.INVISIBLE);
	    
	    
	    
	    txtCloudEquation = (TextView) findViewById(R.id.txtCloudEquation);
	    txtCloudEquation.setVisibility(View.INVISIBLE);
	    
	    txtCloudAnswer1 = (TextView) findViewById(R.id.txtCloudAnswer1);
	    txtCloudAnswer1.setVisibility(View.INVISIBLE);
	    
	    txtCloudAnswer2 = (TextView) findViewById(R.id.txtCloudAnswer2);
	    txtCloudAnswer2.setVisibility(View.INVISIBLE);
	    
	    txtCloudAnswer3 = (TextView) findViewById(R.id.txtCloudAnswer3);
	    txtCloudAnswer3.setVisibility(View.INVISIBLE);
	    
	    txtCloudAnswer4 = (TextView) findViewById(R.id.txtCloudAnswer4);
	    txtCloudAnswer4.setVisibility(View.INVISIBLE);
	    
	    
	    move1 = (ImageButton) findViewById(R.id.move1);
	    move2 = (ImageButton) findViewById(R.id.move2);
	    move3 = (ImageButton) findViewById(R.id.move3);
	    move4 = (ImageButton) findViewById(R.id.move44);
	}
	
	private void generateAnimations(){
		
		move1a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move1);
	    move1a.setAnimationListener(this);
	    
	    move2a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move2);
	    move2a.setAnimationListener(this);
	    
	    move3a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move3);
	    move3a.setAnimationListener(this);
	    
	    move4a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move4);
	    move4a.setAnimationListener(this);
	    
	    fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
	    fadeIn.setAnimationListener(this);
	
	    blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
	
		
		move1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(count==1){
					
					
					
					fessor.startAnimation(move1a);
					move1.setEnabled(false);
				
					cloudQuestion.startAnimation(fadeIn);
					cloudAnswer1.startAnimation(fadeIn);
					cloudAnswer2.startAnimation(fadeIn);
					cloudAnswer3.startAnimation(fadeIn);
					cloudAnswer4.startAnimation(fadeIn);
					
					generateEquation();
					txtCloudEquation.setText(equation);
				
				}
				
				
			}
		}); 
	    move2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(count ==2 && correct==true){
					
					
				}
				
				
			}
		});
	    move3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(count == 3 && correct==true){
					
					
				}
			}
		});
	    move4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(count == 4 && correct==true){
					
					//correct=false;
					///resetClouds();
					//enableClouds();
					//generateEquation();
					//txtCloudEquation.setText(equation);
					
					
					
				}
			}
		});
	}
	
	private void cloudsOnClickListeners(){
		
		cloudAnswer1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				disableClouds();
				String answered = txtCloudAnswer1.getText().toString();
				
				int cloud2 = Integer.parseInt(txtCloudAnswer2.getText().toString());
				int cloud3 = Integer.parseInt(txtCloudAnswer3.getText().toString());
				int cloud4 = Integer.parseInt(txtCloudAnswer4.getText().toString());
				
				
				
				boolean correctAnswer = answer(equation, answered);
				
				if (correctAnswer == true){
					
					cloudAnswer1.setImageResource(greenCloud);
					txtCloudAnswer1.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
				}else{
					
					medalCounter++;
					if (cloud2-equationValue==0){
						cloudAnswer2.setImageResource(greenCloud);
						cloudAnswer1.setImageResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setImageResource(greenCloud);
						cloudAnswer1.setImageResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setImageResource(greenCloud);
						cloudAnswer1.setImageResource(redCloud);
					}
					
					handler.postDelayed(runnable, 2000);
					
				}
				setMedal();
			}
		});
	    cloudAnswer2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				disableClouds();
				String answered = txtCloudAnswer2.getText().toString();
				int cloud1 = Integer.parseInt(txtCloudAnswer1.getText().toString());
				int cloud3 = Integer.parseInt(txtCloudAnswer3.getText().toString());
				int cloud4 = Integer.parseInt(txtCloudAnswer4.getText().toString());
				
				boolean correctAnswer = answer(equation, answered);
				
				if (correctAnswer==true){
					
					cloudAnswer2.setImageResource(greenCloud);
					txtCloudAnswer2.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
				}
				else{
					
					medalCounter++;
					if (cloud1-equationValue==0){
						cloudAnswer1.setImageResource(greenCloud);
						cloudAnswer2.setImageResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setImageResource(greenCloud);
						cloudAnswer2.setImageResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setImageResource(greenCloud);
						cloudAnswer2.setImageResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
				setMedal();
			}
		});
	    cloudAnswer3.setOnClickListener(new View.OnClickListener() {
	
	    	@Override
	    	public void onClick(View v) {
	    		disableClouds();
	    		String answered = txtCloudAnswer3.getText().toString();
	    		int cloud2 = Integer.parseInt(txtCloudAnswer2.getText().toString());
				int cloud1 = Integer.parseInt(txtCloudAnswer1.getText().toString());
				int cloud4 = Integer.parseInt(txtCloudAnswer4.getText().toString());
				
				boolean correctAnswer = answer(equation, answered);
		
	    		if (correctAnswer==true){
	    			
					cloudAnswer3.setImageResource(greenCloud);
					txtCloudAnswer3.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
	    		}
	    		else{
	    			
	    			medalCounter++;
	    			
	    			if (cloud2-equationValue==0){
						cloudAnswer2.setImageResource(greenCloud);
						cloudAnswer3.setImageResource(redCloud);
					}
					if (cloud1-equationValue==0){
						cloudAnswer1.setImageResource(greenCloud);
						cloudAnswer3.setImageResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setImageResource(greenCloud);
						cloudAnswer3.setImageResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
	    		setMedal();
	    	}
	    });
	    cloudAnswer4.setOnClickListener(new View.OnClickListener() {
	
	    	@Override
	    	public void onClick(View v) {
	    		disableClouds();
	    		String answered = txtCloudAnswer4.getText().toString();
	    		int cloud2 = Integer.parseInt(txtCloudAnswer2.getText().toString());
				int cloud3 = Integer.parseInt(txtCloudAnswer3.getText().toString());
				int cloud1 = Integer.parseInt(txtCloudAnswer1.getText().toString());
				
				boolean correctAnswer = answer(equation, answered);
		
	    		if (correctAnswer==true){
	    			
					cloudAnswer4.setImageResource(greenCloud);
					txtCloudAnswer4.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
	    		}
	    		else{
	    			medalCounter++;
	    			if (cloud2-equationValue==0){
						cloudAnswer2.setImageResource(greenCloud);
						cloudAnswer4.setImageResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setImageResource(greenCloud);
						cloudAnswer4.setImageResource(redCloud);
					}
					if (cloud1-equationValue==0){
						cloudAnswer1.setImageResource(greenCloud);
						cloudAnswer4.setImageResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
	    		setMedal();
	    	}
	    });
	
	    moveFessor();
	
	
	}
	
	public void moveFessor(){
		
		
		Runnable move = new Runnable() {
			
			@Override
			public void run() {
				if (correct){
					
					switch (count) {
					
					
					case 2:
						correct=false;
						resetClouds();
						enableClouds();
						generateEquation();
						txtCloudEquation.setText(equation);
						fessor.startAnimation(move2a);
						move2.setEnabled(false);
						break;
						
					case 3:
						correct=false;
						resetClouds();
						enableClouds();
						generateEquation();
						txtCloudEquation.setText(equation);
						fessor.startAnimation(move3a);
						move3.setEnabled(false);
						break;
						
					case 4:
						fessor.startAnimation(move4a);
						move4.setEnabled(false);
						break;
				}
				
			}
				
			}
		};
		
		
		handler.postDelayed(move, 1000);
			
	
	}
	
	private Runnable firstMove = new Runnable() {
		
		@Override
		public void run() {
			fessor.startAnimation(move1a);
			move1.setEnabled(false);
		
			cloudQuestion.startAnimation(fadeIn);
			cloudAnswer1.startAnimation(fadeIn);
			cloudAnswer2.startAnimation(fadeIn);
			cloudAnswer3.startAnimation(fadeIn);
			cloudAnswer4.startAnimation(fadeIn);
			
			generateEquation();
			txtCloudEquation.setText(equation);
			gameboardCoins.setVisibility(View.VISIBLE);
		}
	};
	
	public Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			resetClouds();
			generateEquation();
			txtCloudEquation.setText(equation);
			enableClouds();
		}
	};
	
	public void setBackground(){
		switch (Constants.presentCountry) {
		
			case Constants.iceland:
				layout.setBackgroundResource(R.drawable.iceland);
				break;

			case Constants.denmark:
				layout.setBackgroundResource(R.drawable.denmark1);
				break;
				
			case Constants.norway:
				layout.setBackgroundResource(R.drawable.norway1);
				break;
				
			case Constants.faroe:
				layout.setBackgroundResource(R.drawable.faroe1);
				break;
				
			case Constants.sweden:
				layout.setBackgroundResource(R.drawable.sweden1);
				break;
				
			case Constants.finland:
				layout.setBackgroundResource(R.drawable.finland);
				break;
			}
	
	}
	
	public void setMedal(){
		
		
		if (medalCounter<2){
			medal.setImageResource(R.drawable.gold_110);
			Constants.setCloudGameMedal(Constants.gold);
		}
		
		if (medalCounter == 1 || medalCounter == 3){
			medal.setAnimation(blink);
			
		}
		
		if(medalCounter>1 && medalCounter <=3){
			medal.setImageResource(R.drawable.silver_110);
			Constants.setCloudGameMedal(Constants.silver);
		}
		
		
		if(medalCounter>4){
			medal.setImageResource(R.drawable.bronze_110);
			Constants.setCloudGameMedal(Constants.bronze);
		}
	}
	
	private void finishGame(){
		
		Constants.setOverallCoins(Constants.getOverallCoins()+points);

		switch (Constants.cloudGameMedal) {
			case Constants.gold:
			Constants.setOverallGoldMedals(Constants.getOverallGoldMedals()+1);
				break;

			case Constants.silver:
			Constants.setOverallSilverMedals(Constants.getOverallSilverMedals()+1);
				break;
			
			case Constants.bronze:
			Constants.setOverallBronzeMedals(Constants.getOverallBronzeMedals()+1);
				break;
		}
		
		startActivity(memoryGame);
	}
	
	private void dressFessor(){
		
		switch (Constants.fessor_costume) {
		
		case 1:
			fessor.setBackgroundResource(R.drawable.fessor_figurine_glow);
			break;

		case 2:
			fessor.setBackgroundResource(R.drawable.fessor_cowboy_large);
			break;

		case 3:
			fessor.setBackgroundResource(R.drawable.fessor_indian_large);
			break;

		case 4:
			fessor.setBackgroundResource(R.drawable.fessor_pirate_large);
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
