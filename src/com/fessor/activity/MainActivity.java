package com.fessor.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.memorygame.R;




public class MainActivity extends Activity {
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent(this, CountryPicker.class);
		startActivity(intent);
		
		
		
	}

	

	
	
	@Override
	public void onBackPressed() {
		finish();
	}





	
	
	

}
