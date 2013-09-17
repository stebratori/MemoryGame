package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameMap extends Activity implements OnClickListener {

	private int country;
	private ImageView fessor;
	
	private Animation shop_denmark,shop_norway,shop_sweden,shop_finland,shop_faroe,shop_island;
	private Animation island_finland,island_faroe, island_norway, island_denmark,island_sweden;
	private Animation denmark_iceland, denmark_norway, denmark_sweden, denmark_faroe,denmark_finland;
	private Animation finland_iceland,finland_sweden,finland_norway,finland_faroe,finland_denmark;
	private Animation faroe_iceland,faroe_norway,faroe_sweden,faroe_finland,faroe_denmark;
	private Animation sweden_iceland,sweden_norway,sweden_finland,sweden_denmark,sweden_faroe;
	private Animation norway_iceland, norway_denmark, norway_sweden, norway_finland,norway_faroe;
	
	LinearLayout.LayoutParams params;
	Handler handler = new Handler();
	Intent intent;
	Button icelandbtn, faroebtn, norwaybtn,swedenbtn,finlandbtn,denmarkbtn;
	TextView coins, gold, silver, bronze;
	ImageButton shop;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gamemap);
	    
	    declareVariables();
	    country = Constants.getPresentCountry();
	    intent = new Intent(GameMap.this,Gameboard.class );
	    
	    fessor = (ImageView) findViewById(R.id.fessor);
	    
	    dressFessor();
	    createAnimations();
	    placeFessor(1);
	    declareButtons();
	    enableButtons();
	    if (Constants.isFirstTime()){
		   disableButtons();
	    	handler.postDelayed(runCountry, 3000);
	    	Constants.setFirstTime(false);
	    }
	    
	 
	    
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		
	}
	
	private void declareButtons(){
		faroebtn = (Button) findViewById(R.id.faroeBtn);
		faroebtn.setOnClickListener(this);
		icelandbtn = (Button) findViewById(R.id.islandBtn);
		icelandbtn.setOnClickListener(this);
		swedenbtn = (Button) findViewById(R.id.swedenButton);
		swedenbtn.setOnClickListener(this);
		finlandbtn = (Button) findViewById(R.id.finlandButton);
		finlandbtn.setOnClickListener(this);
		norwaybtn = (Button) findViewById(R.id.norwayButton);
		norwaybtn.setOnClickListener(this);
		denmarkbtn = (Button) findViewById(R.id.denmarkButton);
		denmarkbtn.setOnClickListener(this);
		shop = (ImageButton) findViewById(R.id.imageButtonShop);
		shop.setOnClickListener(this);
	}

	private void placeFessor(int duration){
		switch (country) {
	    	
		case Constants.iceland:
			shop_island.setDuration(duration);
			fessor.startAnimation(shop_island);
			break;

		case Constants.denmark:
			shop_denmark.setDuration(duration);
			fessor.startAnimation(shop_denmark);
			break;
			
		case Constants.norway:
			shop_norway.setDuration(duration);
			fessor.startAnimation(shop_norway);
			break;
			
		case Constants.faroe:
			shop_faroe.setDuration(duration);
			fessor.startAnimation(shop_faroe);
			break;
			
		case Constants.sweden:
			shop_sweden.setDuration(duration);
			fessor.startAnimation(shop_sweden);
			break;
		case Constants.finland:
			shop_finland.setDuration(duration);
			fessor.startAnimation(shop_finland);
			break;
		}
	}

	private void createAnimations(){
		
		// island
		
		island_faroe = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.island_faroe);
				
		island_sweden = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.island_sweden);
		
		island_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.island_norway);
		
		island_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.island_finland);
		
		island_denmark = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.island_denmark);
		
		//denmark
		
		denmark_iceland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.denmark_iceland);
		
		denmark_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.denmark_norway);
		
		denmark_faroe = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.denmark_faroe);
		
		denmark_sweden = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.denmark_sweden);
		
		denmark_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.denmark_finland);
		
		//finland
		
		finland_iceland =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.finland_iceland);
		
		finland_sweden = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.finland_sweden);
		
		finland_faroe =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.finland_faroe);
		
		finland_denmark = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.finland_denmark);
		
		finland_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.finland_norway);
		
		//faroe
		
		faroe_iceland =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faroe_iceland);
		
		faroe_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faroe_norway);
		
		faroe_denmark =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faroe_denmark);
		
		faroe_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faroe_finland);
		
		faroe_sweden =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faroe_sweden);
		
		
		// norway
		norway_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.norway_finland);
		norway_iceland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.norway_iceland);
		norway_denmark = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.norway_denmark);
		norway_sweden = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.norway_sweden);
		norway_faroe = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.norway_faroe);
		
		//sweden
		
		sweden_denmark = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sweden_denmark);
		sweden_iceland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sweden_iceland);
		sweden_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sweden_norway);
		sweden_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sweden_finland);
		sweden_faroe = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sweden_faroe);
		
		//shop
		shop_denmark = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_denmark);
		shop_denmark.setDuration(1500);
		
		
		shop_norway = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_norway);
		
		shop_sweden = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_sweden);
		
		shop_finland = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_finland);
		
		shop_faroe = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_faroe);
		
		shop_island = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shop_island);
	}

	private Runnable runCountry = new Runnable() {
		
		@Override
		public void run() {
			
			startActivity(intent);
		}
	};
	
	public void onClick(View v) {
		
		disableButtons();
		
		switch (v.getId()) {
		
		case R.id.faroeBtn:
			faroeSwitch();
			//disableButtons();
			Constants.setPresentCountry(Constants.faroe);
			handler.postDelayed(runCountry, 2000);
			
			break;

		case R.id.swedenButton:
			swedenSwitch();
			//disableButtons();
			Constants.setPresentCountry(Constants.sweden);
			handler.postDelayed(runCountry, 2000);
			
			break;
			
		case R.id.norwayButton:
			norwaySwitch();
			//disableButtons();
			Constants.setPresentCountry(Constants.norway);
			handler.postDelayed(runCountry, 2000);
			
			break;
			
		case R.id.finlandButton:
			finlandSwitch();
		//	disableButtons();
			Constants.setPresentCountry(Constants.finland);
			handler.postDelayed(runCountry, 2000);
			
			break;
			
		case R.id.denmarkButton:
			denmarkSwitch();
			//disableButtons();
			Constants.setPresentCountry(Constants.denmark);
		handler.postDelayed(runCountry, 2000);
			
			break;
			
		case R.id.islandBtn:
			icelandSwitch();
		//	disableButtons();
			Constants.setPresentCountry(Constants.iceland);
			handler.postDelayed(runCountry, 2000);
			
			break;
			
		case R.id.imageButtonShop:
			Intent shop = new Intent(this, ShopActivity.class);
			startActivity(shop);
			
			break;
			
			
		
		}

	}

	private void denmarkSwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.iceland:
			fessor.startAnimation(island_denmark);
			break;

		case Constants.faroe:
			fessor.startAnimation(faroe_denmark);
			break;
		case Constants.sweden:
			fessor.startAnimation(sweden_denmark);
			break;
		case Constants.finland:
			fessor.startAnimation(finland_denmark);
			break;
		case Constants.norway:
			fessor.startAnimation(norway_denmark);
			break;
		}
	}
	
	private void icelandSwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.denmark:
			fessor.startAnimation(denmark_iceland);
			break;

		case Constants.faroe:
			fessor.startAnimation(faroe_iceland);
			break;
		case Constants.sweden:
			fessor.startAnimation(sweden_iceland);
			break;
		case Constants.finland:
			fessor.startAnimation(finland_iceland);
			break;
		case Constants.norway:
			fessor.startAnimation(norway_iceland);
			break;
		}
	}
	
	private void swedenSwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.iceland:
			fessor.startAnimation(island_sweden);
			break;

		case Constants.faroe:
			fessor.startAnimation(faroe_sweden);
			break;
		case Constants.denmark:
			fessor.startAnimation(denmark_sweden);
			break;
		case Constants.finland:
			fessor.startAnimation(finland_sweden);
			break;
		case Constants.norway:
			fessor.startAnimation(norway_sweden);
			break;
		}
	}
	
	private void norwaySwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.iceland:
			fessor.startAnimation(island_norway);
			break;

		case Constants.faroe:
			fessor.startAnimation(faroe_norway);
			break;
		case Constants.sweden:
			fessor.startAnimation(sweden_norway);
			break;
		case Constants.finland:
			fessor.startAnimation(finland_norway);
			break;
		case Constants.denmark:
			fessor.startAnimation(denmark_norway);
			break;
		}
	}

	private void finlandSwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.iceland:
			fessor.startAnimation(island_finland);
			break;

		case Constants.faroe:
			fessor.startAnimation(faroe_finland);
			break;
		case Constants.sweden:
			fessor.startAnimation(sweden_finland);
			break;
		case Constants.denmark:
			fessor.startAnimation(denmark_finland);
			break;
		case Constants.norway:
			fessor.startAnimation(norway_finland);
			break;
		}
	}

	private void faroeSwitch(){
		switch (Constants.presentCountry) {
		
		case Constants.iceland:
			fessor.startAnimation(island_faroe);
			break;

		case Constants.denmark:
			fessor.startAnimation(denmark_faroe);
			break;
		case Constants.sweden:
			fessor.startAnimation(sweden_faroe);
			break;
		case Constants.finland:
			fessor.startAnimation(finland_faroe);
			break;
		case Constants.norway:
			fessor.startAnimation(norway_faroe);
			break;
		}
	}

	private void declareVariables(){
		
		coins = (TextView) findViewById(R.id.gamemapCoins);
		gold = (TextView) findViewById(R.id.gamemapGoldMedal);
		silver = (TextView) findViewById(R.id.gamemapSilverMedal);
		bronze = (TextView) findViewById(R.id.gamemapBronzeMedal);
		
		coins.setText(""+Constants.getOverallCoins());
		gold.setText(""+Constants.getOverallGoldMedals());
		silver.setText(""+Constants.getOverallSilverMedals());
		bronze.setText(""+Constants.getOverallBronzeMedals());
	}

	private void disableButtons(){
		icelandbtn.setEnabled(false);
		faroebtn.setEnabled(false);
		norwaybtn.setEnabled(false);
		swedenbtn.setEnabled(false);
		finlandbtn.setEnabled(false);
		denmarkbtn.setEnabled(false);
		
	}
	
	private void enableButtons(){
		icelandbtn.setEnabled(true);
		faroebtn.setEnabled(true);
		norwaybtn.setEnabled(true);
		swedenbtn.setEnabled(true);
		finlandbtn.setEnabled(true);
		denmarkbtn.setEnabled(true);
		
	}

	private void dressFessor(){
		
		switch (Constants.fessor_costume) {
		
		case 1:
			fessor.setBackgroundResource(R.drawable.fessor_figurine_medium);
			break;

		case 2:
			fessor.setBackgroundResource(R.drawable.fessor_cowboy_medium);
			break;

		case 3:
			fessor.setBackgroundResource(R.drawable.fessor_indian_medium);
			break;

		case 4:
			fessor.setBackgroundResource(R.drawable.fessor_pirate_medium);
			break;
		}
	}








}
