package com.fessor.activity;

import java.util.Random;

import com.example.memorygame.R;
import com.fessor.functions.EquationDecoder;
import com.fessor.functions.NumberGenerator;
import com.fessor.constants.Constants;

import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SkyfallActivity extends Activity implements OnClickListener{

	
	private Random random = new Random();
		
	private int key, numberOfTrueAnswers, points ;
	private String trueAnswerPosition1,trueAnswerPosition2,trueAnswerPosition3;
	private Button cloud1, cloud2, cloud3, cloud4, cloud5;
	//private String equation1, equation2, equation3, equation4, equation5;
	private int duration, delay1, delay2, delay3,delay4,delay5;
	
	private TextView keyValue, coins;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.skyfall);
	
	    key = random.nextInt(10-4)+4;
	    points=0;
	    
	    duration = 5000;
	    delay1 = 1000;
	    delay2 = 3000;
	    delay3 = 4000;
	    delay5 = 2000;
	    
	    generateRandoms();
	    generateClouds();
	    setFirstEquations();
	    generateText();
	    keyValue.setText(""+key);
	    
	    Animator animator = new Animator();
	    animator.cloud1();
	    animator.cloud2();
	    animator.cloud3();
	    animator.cloud4();
	    animator.cloud5();
	    
	}
	
	private void generateClouds(){
		
		cloud1=(Button) findViewById(R.id.plusBtn);
		cloud1.setOnClickListener(this);
		
		cloud2=(Button) findViewById(R.id.minusBtn);
		cloud2.setOnClickListener(this);
		
		cloud3=(Button) findViewById(R.id.button3);
		cloud3.setOnClickListener(this);
		
		cloud4=(Button) findViewById(R.id.button5);
		cloud4.setOnClickListener(this);
		
		cloud5=(Button) findViewById(R.id.button4);
		cloud5.setOnClickListener(this);
		
		keyValue = (TextView) findViewById(R.id.textView3);
		coins = (TextView) findViewById(R.id.gameboardCoins);
		
	}

	private void generateRandoms(){
		
		
		numberOfTrueAnswers = 3;
		
		trueAnswerPosition1 = NumberGenerator.generateRandom(0, 1, 5);
		trueAnswerPosition2 = NumberGenerator.generateRandom(0, trueAnswerPosition1, 1, 5);
		trueAnswerPosition3 = NumberGenerator.generateRandom(0, trueAnswerPosition1, trueAnswerPosition2, 1, 5);
		
		
	}
	
	private void generateText(){
		
		switch (numberOfTrueAnswers) {
		case 1:
			setPositionText(Integer.parseInt(trueAnswerPosition1));
			break;

		case 2:
			setPositionText(Integer.parseInt(trueAnswerPosition1));
			setPositionText(Integer.parseInt(trueAnswerPosition2));
			break;
			
		case 3:
			setPositionText(Integer.parseInt(trueAnswerPosition1));
			setPositionText(Integer.parseInt(trueAnswerPosition2));
			setPositionText(Integer.parseInt(trueAnswerPosition3));
			
			break;
		}
		
	}
	
	private void setPositionText(int position){
		switch (position) {
		case 1:
			cloud1.setText(EquationDecoder.equationMaker(key, Constants.plus));
			break;
			
		case 2:
			cloud2.setText(EquationDecoder.equationMaker(key, Constants.plus));
			break;
			
		case 3:
			cloud3.setText(EquationDecoder.equationMaker(key, Constants.plus));
			break;
			
		case 4:
			cloud4.setText(EquationDecoder.equationMaker(key, Constants.plus));
			break;
			
		case 5:
			cloud5.setText(EquationDecoder.equationMaker(key, Constants.plus));
			break;

		
		}
	}
	
	public void setFirstEquations(){
		
		cloud1.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
		cloud2.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
		cloud3.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
		cloud4.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
		cloud5.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
	
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.plusBtn:
			gradeAnswer(cloud1.getText().toString(), cloud1);
			break;

		case R.id.minusBtn:
			gradeAnswer(cloud2.getText().toString(), cloud2);
			break;
			
		case R.id.button3:
			gradeAnswer(cloud3.getText().toString(), cloud3);
			break;
			
		case R.id.button5:
			gradeAnswer(cloud4.getText().toString(), cloud4);
			break;
			
		case R.id.button4:
			gradeAnswer(cloud5.getText().toString(), cloud5);
			break;
			
	
		}
		
	}

	private void gradeAnswer(String answer, Button button){
		
		if (EquationDecoder.equationDecoder(answer) == key){
			button.setBackgroundResource(R.drawable.lil_cloud_1_green);
			points++;
			
		}
		else {
			button.setBackgroundResource(R.drawable.lil_cloud_1_red);
			points-=2;
		}
		coins.setText(""+points);
	}
	
	private class Animator implements AnimatorListener {
		
		ObjectAnimator moveCloud1, moveCloud2, moveCloud3, moveCloud4, moveCloud5;
		
		private void cloud1(){
			
			moveCloud1 = ObjectAnimator.ofFloat(cloud1, "translationY", 0,900);
			moveCloud1.setDuration(duration);
			moveCloud1.setRepeatCount(999);
			moveCloud1.setInterpolator(null);
			moveCloud1.setStartDelay(delay1);
			moveCloud1.addListener(this);
			moveCloud1.start();
		}

		private void cloud2(){
			
			moveCloud2 = ObjectAnimator.ofFloat(cloud2, "translationY", 0,900);
			moveCloud2.setDuration(duration);
			moveCloud2.setRepeatCount(999);
			moveCloud2.setInterpolator(null);
			moveCloud2.setStartDelay(delay2);
			moveCloud2.addListener(this);
			moveCloud2.start();
		}
	
		private void cloud3(){
	
			moveCloud3 = ObjectAnimator.ofFloat(cloud3, "translationY", 0,900);
			moveCloud3.setDuration(duration);
			moveCloud3.setRepeatCount(999);
			moveCloud3.setInterpolator(null);
			moveCloud3.setStartDelay(delay3);
			moveCloud3.addListener(this);
			moveCloud3.start();
		}
		
		private void cloud4(){
	
			moveCloud4 = ObjectAnimator.ofFloat(cloud5, "translationY", 0,900);
			moveCloud4.setDuration(duration);
			moveCloud4.setRepeatCount(999);
			moveCloud4.setInterpolator(null);
			moveCloud4.addListener(this);
			moveCloud4.start();
		}
		
		private void cloud5(){
	
			moveCloud5 = ObjectAnimator.ofFloat(cloud4, "translationY", 0,900);
			moveCloud5.setDuration(duration);
			moveCloud5.setRepeatCount(999);
			moveCloud5.setInterpolator(null);
			moveCloud5.setStartDelay(delay5);
			moveCloud5.addListener(this);
			moveCloud5.start();
		}
		
		public void onAnimationStart(
				com.nineoldandroids.animation.Animator animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationEnd(
				com.nineoldandroids.animation.Animator animation) {
			
			
		}

		@Override
		public void onAnimationCancel(
				com.nineoldandroids.animation.Animator animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationRepeat(com.nineoldandroids.animation.Animator animation) {
			
			switch (points) {
			case 1:
				
				duration = 4000;
				delay1 = 800;
				delay2 = 2400;
				delay3 = 3200;
				delay5 = 1600;	
				
				break;
				
			case 3:
				
				duration = 3000;
				delay1 = 600;
				delay2 = 1900;
				delay3 = 2600;
				delay5 = 1200;	
				
				
				break;
				
			case 4:
	
					duration = 2000;
					delay1 = 400;
					delay2 = 1400;
					delay3 = 1600;
					delay5 = 800;	
					
	
					break;

			}
			
			
			if (animation == moveCloud1){
				cloud1.setBackgroundResource(R.drawable.lil_cloud_1);
				cloud1.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
			}
			
			if (animation == moveCloud2){
				cloud2.setBackgroundResource(R.drawable.lil_cloud_1);
				cloud2.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
			}
			
			if (animation == moveCloud3){
				cloud3.setBackgroundResource(R.drawable.lil_cloud_1);
				cloud3.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
			}
			
			if (animation == moveCloud5){
				cloud4.setBackgroundResource(R.drawable.lil_cloud_1);
				cloud4.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
			}
			
			if (animation == moveCloud4){
				cloud5.setBackgroundResource(R.drawable.lil_cloud_1);
				cloud5.setText(EquationDecoder.equationMaker(random.nextInt(10-3)+3, Constants.plus));
			}
		}
		
	}
	
	
	
	








	
	
	
	
	
	
	
	















}
