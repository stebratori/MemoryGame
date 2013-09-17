package com.fessor.activity;

import java.util.List;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.functions.PopulateTable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoryGame extends Activity implements OnClickListener{

	private ImageButton btn11,btn12,btn13,btn14,btn21,btn22,btn23,btn24,btn31,btn32,btn33,btn34,btn41,btn42,btn43,btn44 ;
	public  ImageButton btnClicked1, btnClicked2, bonusButton;
	
	private TextView txt11,txt12,txt13,txt14,txt21,txt22,txt23,txt24,txt31,txt32,txt33,txt34,txt41,txt42,txt43,txt44;
	public  TextView txtClicked1, txtClicked2, txtPoints, txtBonusAnswer,txtBonusEquation,txtAnswer;
	
	int btn11clicked,btn12clicked,btn13clicked,btn14clicked,btn21clicked,btn22clicked,btn23clicked,btn24clicked,btn31clicked,
			btn32clicked,btn33clicked,btn34clicked,btn41clicked,btn42clicked,btn43clicked,btn44clicked ;
	
	private int counter, score, clickCounter, operation, medalCounter;
	List<String> content;
	
	private Handler handler = new Handler();
	private Animation fadeIn, fadeOut, blink;
	LinearLayout layout;
	Typeface font;
	ImageView medal;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.memory_game);
	
		Constants.setCoinsCloudGame(3);
		Constants.setCoinsMemoryGame(8);
		declareVariables();
		createButtons();
		createText();
		createAnimations();
		visibleText();
		setButtons();
		setBackground();
		//setFont();
		
		
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}

	public void onClick(View v){
		
		
		if (clickCounter == 0 || clickCounter == 1){
		
		
		switch(v.getId()){
		
		
		
		case R.id.btn11_4x6:
			txt11.setVisibility(View.VISIBLE);
			controller(txt11, btn11);
			break;
		
		case R.id.btn12_4x6:
			txt12.setVisibility(View.VISIBLE);
			controller(txt12, btn12);
			break;
			
		case R.id.btn13_4x6:
			txt13.setVisibility(View.VISIBLE);
			controller(txt13, btn13);
			break;
			
		case R.id.btn14_4x6:
			txt14.setVisibility(View.VISIBLE);
			controller(txt14, btn14);
			break;
			
		case R.id.btn21_4x6:
			txt21.setVisibility(View.VISIBLE);
			controller(txt21, btn21);
			break;
		
		case R.id.btn22_4x6:
			txt22.setVisibility(View.VISIBLE);
			controller(txt22, btn22);
			break;
			
		case R.id.btn23_4x6:
			txt23.setVisibility(View.VISIBLE);
			controller(txt23, btn23);
			break;
			
		case R.id.btn24_4x6:
			txt24.setVisibility(View.VISIBLE);
			controller(txt24, btn24);
			break;
			
		case R.id.btn31_4x6:
			txt31.setVisibility(View.VISIBLE);
			controller(txt31, btn31);
			break;
		
		case R.id.btn32_4x6:
			txt32.setVisibility(View.VISIBLE);
			controller(txt32, btn32);
			break;
			
		case R.id.btn33_4x6:
			txt33.setVisibility(View.VISIBLE);
			controller(txt33, btn33);
			break;
			
		case R.id.btn34_4x6:
			txt34.setVisibility(View.VISIBLE);
			controller(txt34, btn34);
			break;
			
		case R.id.btn41_4x6:
			txt41.setVisibility(View.VISIBLE);
			controller(txt41, btn41);
			break;
		
		case R.id.btn42_4x6:
			txt42.setVisibility(View.VISIBLE);
			controller(txt42, btn42);
			break;
			
		case R.id.btn43_4x6:
			txt43.setVisibility(View.VISIBLE);
			controller(txt43, btn43);
			break;
			
		case R.id.btn44_4x6:
			txt44.setVisibility(View.VISIBLE);
			controller(txt44, btn44);
			break;
			
		
		
		}
	} // clickCounter
		
	}
	
	private void declareVariables(){
		operation = Constants.plus;
		counter = 0;
		medalCounter = 0;
		clickCounter = 0;
		score = 0;
		content = PopulateTable.populateTableList(16, operation);
		txtPoints = (TextView) findViewById(R.id.txtCoins_4x6);
		layout = (LinearLayout) findViewById(R.id.memory_game);
		medal = (ImageView) findViewById(R.id.memoryGameMedal);
		btn11clicked= 0;
		btn12clicked= 0;
		btn13clicked= 0;
		btn14clicked= 0;
		btn21clicked= 0;
		btn22clicked= 0;
		btn23clicked= 0;
		btn24clicked= 0;
		btn31clicked= 0;
		btn32clicked= 0;
		btn33clicked= 0;
		btn34clicked= 0;
		btn41clicked= 0;
		btn42clicked= 0;
		btn43clicked= 0;
		btn44clicked= 0;
		//font = Typeface.createFromAsset(getAssets(), "CornFed.ttf");
	}
	
	private void controller(TextView textView, ImageButton imageButton){
		
		setMedal();
		pressedCheck(imageButton);
		
		// first button pressed
		if(counter==0){
				
			btnClicked1 = imageButton;
			txtClicked1 = textView;
			
			//// card flip
			
			btnClicked1.setBackgroundResource(R.drawable.white_button);
			
			String stringValue = txtClicked1.getText().toString();
			
			
						// if it's an equation
						if(stringValue.length()>2){
									char firstChar = stringValue.charAt(0);
									char secondChar = stringValue.charAt(2);
				
									String sNumber1=Character.toString(firstChar);
									String sNumber2=Character.toString(secondChar);
				
									int number1 = Integer.parseInt(sNumber1);
									int number2 = Integer.parseInt(sNumber2);
				
									int result = number1+number2;
									Constants.setFirstValue(result);
									
						}
						// if it's a single value
						else{
			
							int firstValue =Integer.parseInt(""+stringValue);
							Constants.setFirstValue(firstValue);
							
						}
			
			
			
			clickCounter = 1;
			counter=1;
			btnClicked1.setEnabled(false);
		}
		//second button pressed
		else {
			
			
			
			btnClicked2 = imageButton;
			txtClicked2 = textView;
			clickCounter = 2;
			
			//// card flip
			
			btnClicked2.setBackgroundResource(R.drawable.white_button);
			
			String stringValue = txtClicked2.getText().toString();
			
			
							// if it's an equation
							if(stringValue.length()>2){
									char firstChar = stringValue.charAt(0);
									char secondChar = stringValue.charAt(2);
	
									String sNumber1=Character.toString(firstChar);
									String sNumber2=Character.toString(secondChar);
	
									int number1 = Integer.parseInt(sNumber1);
									int number2 = Integer.parseInt(sNumber2);
	
									int result = number1+number2;
									Constants.setSecondValue(result);
									
							}
							// if it's a single value
							else{

								int secondValue =Integer.parseInt(""+stringValue);
								Constants.setSecondValue(secondValue);
							}
							
										int result=Constants.getFirstValue()-Constants.getSecondValue();	
			
										// correct match
										if (result==0){
											createRunnable(true, btnClicked1, btnClicked2, txtClicked1, txtClicked2);
											score++;
											txtPoints.setText(""+score);
											
											
										}
										
										// wrong match
										else{
											createRunnable(false, btnClicked1, btnClicked2, txtClicked1, txtClicked2);
											btnClicked1.setEnabled(true);
											
										}
			
			
			activateButtons();
			counter=0;
			if (score == 8){
				finishGame();
			}
			
			
		}
		
		
		
	}
			
	private void createRunnable(final boolean guessed, final ImageButton btn1, final ImageButton btn2,final TextView txt1, final TextView txt2){
		
			final Runnable task = new Runnable(){

				@Override
				public void run() {
					
					if(guessed==true){
						txtClicked1.setVisibility(View.INVISIBLE);
						txtClicked2.setVisibility(View.INVISIBLE);
						btnClicked1.setEnabled(false);
						btnClicked2.setEnabled(false);
						
						int ID = btnClicked1.getId();
						
						if(ID == R.id.btn11_4x6){
							if (btn11clicked==1){
								medalCounter--;
							}
							btn11.setVisibility(View.INVISIBLE);
							
						}
						if(ID == R.id.btn12_4x6){
							if (btn12clicked==1){
								medalCounter--;
							}
							btn12.setVisibility(View.INVISIBLE);

						}
						if(ID == R.id.btn13_4x6){
							if (btn13clicked==1){
								medalCounter--;
							}
							btn13.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn14_4x6){
							if (btn14clicked==1){
								medalCounter--;
							}
							btn14.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn21_4x6){
							if (btn21clicked==1){
								medalCounter--;
							}
							btn21.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn22_4x6){
							if (btn22clicked==1){
								medalCounter--;
							}
							btn22.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn23_4x6){
							if (btn23clicked==1){
								medalCounter--;
							}
							btn23.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn24_4x6){
							if (btn24clicked==1){
								medalCounter--;
							}
							btn24.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn31_4x6){
							if (btn31clicked==1){
								medalCounter--;
							}
							btn31.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn32_4x6){
							if (btn32clicked==1){
								medalCounter--;
							}
							btn32.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn33_4x6){
							if (btn33clicked==1){
								medalCounter--;
							}
							btn33.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn34_4x6){
							if (btn34clicked==1){
								medalCounter--;
							}
							btn34.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn41_4x6){
							if (btn41clicked==1){
								medalCounter--;
							}
							btn41.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn42_4x6){
							if (btn42clicked==1){
								medalCounter--;
							}
							btn42.setVisibility(View.INVISIBLE);
						}
					
						if(ID == R.id.btn43_4x6){
							if (btn43clicked==1){
								medalCounter--;
							}
							btn43.setVisibility(View.INVISIBLE);
						}
						if(ID == R.id.btn44_4x6){
							if (btn44clicked==1){
								medalCounter--;
							}
							btn44.setVisibility(View.INVISIBLE);
						}
						
						
						
						
						//  *** ID2 ***  //
						
						int ID2 = btnClicked2.getId();
						
						if(ID2 == R.id.btn11_4x6){
							if (btn11clicked==1){
								medalCounter--;
							}
							btn11.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn12_4x6){
							if (btn12clicked==1){
								medalCounter--;
							}
							btn12.setVisibility(View.INVISIBLE);

						}
						if(ID2 == R.id.btn13_4x6){
							if (btn13clicked==1){
								medalCounter--;
							}
							btn13.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn14_4x6){
							if (btn14clicked==1){
								medalCounter--;
							}
							btn14.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn21_4x6){
							if (btn21clicked==1){
								medalCounter--;
							}
							btn21.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn22_4x6){
							if (btn22clicked==1){
								medalCounter--;
							}
							btn22.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn23_4x6){
							if (btn23clicked==1){
								medalCounter--;
							}
							btn23.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn24_4x6){
							if (btn24clicked==1){
								medalCounter--;
							}
							btn24.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn31_4x6){
							if (btn31clicked==1){
								medalCounter--;
							}
							btn31.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn32_4x6){
							if (btn32clicked==1){
								medalCounter--;
							}
							btn32.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn33_4x6){
							if (btn33clicked==1){
								medalCounter--;
							}
							btn33.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn34_4x6){
							if (btn34clicked==1){
								medalCounter--;
							}
							btn34.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn41_4x6){
							if (btn41clicked==1){
								medalCounter--;
							}
							btn41.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn42_4x6){
							if (btn42clicked==1){
								medalCounter--;
							}
							btn42.setVisibility(View.INVISIBLE);
						}
					
						if(ID2 == R.id.btn43_4x6){
							if (btn43clicked==1){
								medalCounter--;
							}
							btn43.setVisibility(View.INVISIBLE);
						}
						if(ID2 == R.id.btn44_4x6){
							if (btn44clicked==1){
								medalCounter--;
							}
							btn44.setVisibility(View.INVISIBLE);
						}
						
						
					}
					else{
						txtClicked1.setVisibility(View.INVISIBLE);
						txtClicked2.setVisibility(View.INVISIBLE);
						setButtons();
					}
					
				}
				
			};
			if (medalCounter<0){
				medalCounter = 0;
			}
			txtPoints.setText(""+score);
			handler.postDelayed(task, 1000);
	}
	
	private void createButtons(){
		
				
		btn11 = (ImageButton) findViewById(R.id.btn11_4x6);
		btn12 = (ImageButton) findViewById(R.id.btn12_4x6);
		btn13 = (ImageButton) findViewById(R.id.btn13_4x6);
		btn14 = (ImageButton) findViewById(R.id.btn14_4x6);
		btn21 = (ImageButton) findViewById(R.id.btn21_4x6);
		btn22 = (ImageButton) findViewById(R.id.btn22_4x6);
		btn23 = (ImageButton) findViewById(R.id.btn23_4x6);
		btn24 = (ImageButton) findViewById(R.id.btn24_4x6);
		btn31 = (ImageButton) findViewById(R.id.btn31_4x6);
		btn32 = (ImageButton) findViewById(R.id.btn32_4x6);
		btn33 = (ImageButton) findViewById(R.id.btn33_4x6);
		btn34 = (ImageButton) findViewById(R.id.btn34_4x6);
		btn41 = (ImageButton) findViewById(R.id.btn41_4x6);
		btn42 = (ImageButton) findViewById(R.id.btn42_4x6);
		btn43 = (ImageButton) findViewById(R.id.btn43_4x6);
		btn44 = (ImageButton) findViewById(R.id.btn44_4x6);
		
		
		btn11.setOnClickListener(this);
		btn12.setOnClickListener(this);
		btn13.setOnClickListener(this);
		btn14.setOnClickListener(this);
		btn21.setOnClickListener(this);
		btn22.setOnClickListener(this);
		btn23.setOnClickListener(this);
		btn24.setOnClickListener(this);
		btn31.setOnClickListener(this);
		btn32.setOnClickListener(this);
		btn33.setOnClickListener(this);
		btn34.setOnClickListener(this);
		btn41.setOnClickListener(this);
		btn42.setOnClickListener(this);
		btn43.setOnClickListener(this);
		btn44.setOnClickListener(this);
		
	}
	
	private void createText(){
		
				
		txt11=(TextView) findViewById(R.id.txt11_4x6);
		txt11.setVisibility(View.INVISIBLE);
		txt11.setText(""+content.get(12));
		
		txt12=(TextView) findViewById(R.id.txt12_4x6);
		txt12.setVisibility(View.INVISIBLE);
		txt12.setText(""+content.get(13));
		
		txt13=(TextView) findViewById(R.id.txt13_4x6);
		txt13.setVisibility(View.INVISIBLE);
		txt13.setText(""+content.get(14));
		
		txt14=(TextView) findViewById(R.id.txt14_4x6);
		txt14.setVisibility(View.INVISIBLE);
		txt14.setText(""+content.get(15));
		
		txt21=(TextView) findViewById(R.id.txt21_4x6);
		txt21.setVisibility(View.INVISIBLE);
		txt21.setText(""+content.get(0));
		
		txt22=(TextView) findViewById(R.id.txt22_4x6);
		txt22.setVisibility(View.INVISIBLE);
		txt22.setText(""+content.get(1));
		
		txt23=(TextView) findViewById(R.id.txt23_4x6);
		txt23.setVisibility(View.INVISIBLE);
		txt23.setText(""+content.get(2));
		
		txt24=(TextView) findViewById(R.id.txt24_4x6);
		txt24.setVisibility(View.INVISIBLE);
		txt24.setText(""+content.get(3));
			
		txt31=(TextView) findViewById(R.id.txt31_4x6);
		txt31.setVisibility(View.INVISIBLE);
		txt31.setText(""+content.get(4));
		
		txt32=(TextView) findViewById(R.id.txt32_4x6);
		txt32.setVisibility(View.INVISIBLE);
		txt32.setText(""+content.get(5));
		
		txt33=(TextView) findViewById(R.id.txt33_4x6);
		txt33.setVisibility(View.INVISIBLE);
		txt33.setText(""+content.get(6));
		
		txt34=(TextView) findViewById(R.id.txt34_4x6);
		txt34.setVisibility(View.INVISIBLE);
		txt34.setText(""+content.get(7));
		
		txt41=(TextView) findViewById(R.id.txt41_4x6);
		txt41.setVisibility(View.INVISIBLE);
		txt41.setText(""+content.get(8));
		
		txt42=(TextView) findViewById(R.id.txt42_4x6);
		txt42.setVisibility(View.INVISIBLE);
		txt42.setText(""+content.get(9));
		
		txt43=(TextView) findViewById(R.id.txt43_4x6);
		txt43.setVisibility(View.INVISIBLE);
		txt43.setText(""+content.get(10));
		
		txt44=(TextView) findViewById(R.id.txt44_4x6);
		txt44.setVisibility(View.INVISIBLE);
		txt44.setText(""+content.get(11));
		
		
	}
	
	private void createAnimations(){
		
		fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in); 
		
		fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
		
		blink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
		
		
		
		
	}

	private void activateButtons(){
		
	final Runnable activateBut = new Runnable(){

			@Override
			public void run() {
				clickCounter = 0;
				
			}
			
		};
		handler.postDelayed(activateBut, 1000);
		
	}
	
	private void visibleText(){
		txt11.setVisibility(View.VISIBLE);
		txt12.setVisibility(View.VISIBLE);
		txt13.setVisibility(View.VISIBLE);
		txt14.setVisibility(View.VISIBLE);
		txt21.setVisibility(View.VISIBLE);
		txt22.setVisibility(View.VISIBLE);
		txt23.setVisibility(View.VISIBLE);
		txt24.setVisibility(View.VISIBLE);
		txt31.setVisibility(View.VISIBLE);
		txt32.setVisibility(View.VISIBLE);
		txt33.setVisibility(View.VISIBLE);
		txt34.setVisibility(View.VISIBLE);
		txt41.setVisibility(View.VISIBLE);
		txt42.setVisibility(View.VISIBLE);
		txt43.setVisibility(View.VISIBLE);
		txt44.setVisibility(View.VISIBLE);
		
		
		
	}
	
	private void finishGame(){
		
		
		Constants.setOverallCoins(Constants.getOverallCoins()+score);
		
		switch (Constants.memoryGameMedal) {
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
		
		final Runnable activateBut = new Runnable(){

			@Override
			public void run() {
				Intent finish	 = new Intent(MemoryGame.this, ScoreBoardActivity.class);
				startActivity(finish);
			
			}
		
		};
		handler.postDelayed(activateBut, 3000);
	
	}
	
	public void setBackground(){
		switch (Constants.presentCountry) {
		
			case Constants.iceland:
				layout.setBackgroundResource(R.drawable.iceland2);
				break;

			case Constants.denmark:
				layout.setBackgroundResource(R.drawable.denmark2);
				break;
				
			case Constants.norway:
				layout.setBackgroundResource(R.drawable.norway2);
				break;
				
			case Constants.faroe:
				layout.setBackgroundResource(R.drawable.faroe2);
				txtPoints.setTextColor(Color.parseColor("#000000"));
				break;
				
			case Constants.sweden:
				layout.setBackgroundResource(R.drawable.sweden2);
				break;
				
			case Constants.finland:
				layout.setBackgroundResource(R.drawable.finland2);
				break;
			}
	
	}
	
	public void setMedal(){
		
		if (medalCounter ==4){
			medal.setAnimation(blink);
			
		}
		if (medalCounter<=4){
			medal.setImageResource(R.drawable.gold_110);
			Constants.setMemoryGameMedal(Constants.gold);
		}
		
		if(medalCounter>4 && medalCounter <=8){
			medal.setImageResource(R.drawable.silver_110);
			Constants.setMemoryGameMedal(Constants.silver);
		}
		if (medalCounter ==8){
			medal.setAnimation(blink);
		}
		if(medalCounter>8){
			medal.setImageResource(R.drawable.bronze_110);
			Constants.setMemoryGameMedal(Constants.bronze);
		}
	}
	
	public void pressedCheck(ImageButton button){
		
		switch (button.getId()) {
		
		case R.id.btn11_4x6:
			if (btn11clicked == 0){
				btn11clicked++;
			}else {
				medalCounter++;
			}
			break;

		case R.id.btn12_4x6:
			if (btn12clicked == 0){
				btn12clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn13_4x6:
			if (btn13clicked == 0){
				btn13clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn14_4x6:
			if (btn14clicked == 0){
				btn14clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn21_4x6:
			if (btn21clicked == 0){
				btn21clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn22_4x6:
			if (btn22clicked== 0){
				btn22clicked++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn23_4x6:
			if (btn23clicked == 0){
				btn23clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn24_4x6:
			if (btn24clicked == 0){
				btn24clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn31_4x6:
			if (btn31clicked == 0){
				btn31clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn32_4x6:
			if (btn32clicked == 0){
				btn32clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn33_4x6:
			if (btn33clicked == 0){
				btn33clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn34_4x6:
			if (btn34clicked == 0){
				btn34clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
			
		case R.id.btn41_4x6:
			if (btn41clicked == 0){
				btn41clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn42_4x6:
			if (btn42clicked == 0){
				btn42clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn43_4x6:
			if (btn43clicked == 0){
				btn43clicked ++;
			}else {
				btn12clicked ++;
				medalCounter++;
			}
			break;
		case R.id.btn44_4x6:
			if (btn44clicked == 0){
				btn44clicked ++;
			} else {
				btn12clicked ++;
				medalCounter++;
			}
			break;

		}
		
	}
	
	public void setButtons(){
		switch (Constants.presentCountry) {
		
		case Constants.denmark:
			btn11.setBackgroundResource(R.drawable.btn_denmark);
			btn12.setBackgroundResource(R.drawable.btn_denmark);
			btn13.setBackgroundResource(R.drawable.btn_denmark);
			btn14.setBackgroundResource(R.drawable.btn_denmark);
			btn21.setBackgroundResource(R.drawable.btn_denmark);
			btn22.setBackgroundResource(R.drawable.btn_denmark);
			btn23.setBackgroundResource(R.drawable.btn_denmark);
			btn24.setBackgroundResource(R.drawable.btn_denmark);
			btn31.setBackgroundResource(R.drawable.btn_denmark);
			btn32.setBackgroundResource(R.drawable.btn_denmark);
			btn33.setBackgroundResource(R.drawable.btn_denmark);
			btn34.setBackgroundResource(R.drawable.btn_denmark);
			btn41.setBackgroundResource(R.drawable.btn_denmark);
			btn42.setBackgroundResource(R.drawable.btn_denmark);
			btn43.setBackgroundResource(R.drawable.btn_denmark);
			btn44.setBackgroundResource(R.drawable.btn_denmark);
			break;

		case Constants.faroe:
			btn11.setBackgroundResource(R.drawable.btn_faroe);
			btn12.setBackgroundResource(R.drawable.btn_faroe);
			btn13.setBackgroundResource(R.drawable.btn_faroe);
			btn14.setBackgroundResource(R.drawable.btn_faroe);
			btn21.setBackgroundResource(R.drawable.btn_faroe);
			btn22.setBackgroundResource(R.drawable.btn_faroe);
			btn23.setBackgroundResource(R.drawable.btn_faroe);
			btn24.setBackgroundResource(R.drawable.btn_faroe);
			btn31.setBackgroundResource(R.drawable.btn_faroe);
			btn32.setBackgroundResource(R.drawable.btn_faroe);
			btn33.setBackgroundResource(R.drawable.btn_faroe);
			btn34.setBackgroundResource(R.drawable.btn_faroe);
			btn41.setBackgroundResource(R.drawable.btn_faroe);
			btn42.setBackgroundResource(R.drawable.btn_faroe);
			btn43.setBackgroundResource(R.drawable.btn_faroe);
			btn44.setBackgroundResource(R.drawable.btn_faroe);
			break;
		case Constants.iceland:
			
			btn11.setBackgroundResource(R.drawable.btn_iceland);
			btn12.setBackgroundResource(R.drawable.btn_iceland);
			btn13.setBackgroundResource(R.drawable.btn_iceland);
			btn14.setBackgroundResource(R.drawable.btn_iceland);
			btn21.setBackgroundResource(R.drawable.btn_iceland);
			btn22.setBackgroundResource(R.drawable.btn_iceland);
			btn23.setBackgroundResource(R.drawable.btn_iceland);
			btn24.setBackgroundResource(R.drawable.btn_iceland);
			btn31.setBackgroundResource(R.drawable.btn_iceland);
			btn32.setBackgroundResource(R.drawable.btn_iceland);
			btn33.setBackgroundResource(R.drawable.btn_iceland);
			btn34.setBackgroundResource(R.drawable.btn_iceland);
			btn41.setBackgroundResource(R.drawable.btn_iceland);
			btn42.setBackgroundResource(R.drawable.btn_iceland);
			btn43.setBackgroundResource(R.drawable.btn_iceland);
			btn44.setBackgroundResource(R.drawable.btn_iceland);
			break;
		case Constants.norway:
			btn11.setBackgroundResource(R.drawable.btn_norway);
			btn12.setBackgroundResource(R.drawable.btn_norway);
			btn13.setBackgroundResource(R.drawable.btn_norway);
			btn14.setBackgroundResource(R.drawable.btn_norway);
			btn21.setBackgroundResource(R.drawable.btn_norway);
			btn22.setBackgroundResource(R.drawable.btn_norway);
			btn23.setBackgroundResource(R.drawable.btn_norway);
			btn24.setBackgroundResource(R.drawable.btn_norway);
			btn31.setBackgroundResource(R.drawable.btn_norway);
			btn32.setBackgroundResource(R.drawable.btn_norway);
			btn33.setBackgroundResource(R.drawable.btn_norway);
			btn34.setBackgroundResource(R.drawable.btn_norway);
			btn41.setBackgroundResource(R.drawable.btn_norway);
			btn42.setBackgroundResource(R.drawable.btn_norway);
			btn43.setBackgroundResource(R.drawable.btn_norway);
			btn44.setBackgroundResource(R.drawable.btn_norway);
			break;
		case Constants.finland:
			btn11.setBackgroundResource(R.drawable.btn_finland);
			btn12.setBackgroundResource(R.drawable.btn_finland);
			btn13.setBackgroundResource(R.drawable.btn_finland);
			btn14.setBackgroundResource(R.drawable.btn_finland);
			btn21.setBackgroundResource(R.drawable.btn_finland);
			btn22.setBackgroundResource(R.drawable.btn_finland);
			btn23.setBackgroundResource(R.drawable.btn_finland);
			btn24.setBackgroundResource(R.drawable.btn_finland);
			btn31.setBackgroundResource(R.drawable.btn_finland);
			btn32.setBackgroundResource(R.drawable.btn_finland);
			btn33.setBackgroundResource(R.drawable.btn_finland);
			btn34.setBackgroundResource(R.drawable.btn_finland);
			btn41.setBackgroundResource(R.drawable.btn_finland);
			btn42.setBackgroundResource(R.drawable.btn_finland);
			btn43.setBackgroundResource(R.drawable.btn_finland);
			btn44.setBackgroundResource(R.drawable.btn_finland);
			break;
		case Constants.sweden:
			btn11.setBackgroundResource(R.drawable.btn_sweden);
			btn12.setBackgroundResource(R.drawable.btn_sweden);
			btn13.setBackgroundResource(R.drawable.btn_sweden);
			btn14.setBackgroundResource(R.drawable.btn_sweden);
			btn21.setBackgroundResource(R.drawable.btn_sweden);
			btn22.setBackgroundResource(R.drawable.btn_sweden);
			btn23.setBackgroundResource(R.drawable.btn_sweden);
			btn24.setBackgroundResource(R.drawable.btn_sweden);
			btn31.setBackgroundResource(R.drawable.btn_sweden);
			btn32.setBackgroundResource(R.drawable.btn_sweden);
			btn33.setBackgroundResource(R.drawable.btn_sweden);
			btn34.setBackgroundResource(R.drawable.btn_sweden);
			btn41.setBackgroundResource(R.drawable.btn_sweden);
			btn42.setBackgroundResource(R.drawable.btn_sweden);
			btn43.setBackgroundResource(R.drawable.btn_sweden);
			btn44.setBackgroundResource(R.drawable.btn_sweden);
			break;
		}
	}
	
	public void setFont(){
		txt43.setTypeface(font);
	}





















}



























