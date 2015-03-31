package com.example.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		EditText text1 = (EditText)findViewById(R.id.edittext11);
		EditText text2 = (EditText)findViewById(R.id.edittext22);
		
		Intent intent = getIntent();
		if (intent != null) {
			boolean b1 = intent.getBooleanExtra("check1", false);
			boolean b2 = intent.getBooleanExtra("check2", false);
			if(b1)
				text1.setText("true");
			else
				text1.setText("false");
			if(b2)
				text2.setText("true");
			else
				text2.setText("false");
		}
	}
	
	
}
