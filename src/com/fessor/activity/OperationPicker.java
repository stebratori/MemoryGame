package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OperationPicker extends Activity implements OnClickListener{

	Button plus, minus;
	Intent intent ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.operation_picker);
		plus = (Button) findViewById(R.id.plusBtn);
		minus = (Button) findViewById(R.id.minusBtn);
		
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		
		Constants.setCoins(0);
		
		intent = new Intent(OperationPicker.this, CountryPicker.class);
	}

	

	
	
	@Override
	public void onBackPressed() {
		finish();
	}





	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.plusBtn:
			
			Constants.setPresentOperation(Constants.plus);
			startActivity(intent);
			break;

		case R.id.minusBtn:
			
			Constants.setPresentOperation(Constants.minus);
			startActivity(intent);
			break;
		}
		
	}
	
	

}
