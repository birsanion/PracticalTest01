package com.example.practicaltest01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;







import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		
		
		final CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkbox1);
		EditText edittext1 = (EditText)findViewById(R.id.edittext1);
		edittext1.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				if(s.length() != 0)
					if(isEmailValid(s.toString()))
						checkbox1.setChecked(true);
					else
						checkbox1.setChecked(false);
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
	        
	    });
		
		final CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkbox2);
		EditText edittext2 = (EditText)findViewById(R.id.edittext2);
		edittext2.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				if(s.length() != 0){
				
					if (isValidPhoneNumber(s.toString())){
						checkbox2.setChecked(true);
					}else{
						checkbox2.setChecked(false);
					}
				}
					
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
	        
	    }); 
		
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =  new Intent("com.example.practicaltest01.contactsmanager.intent.action.ContactsManagerActivity");
				intent.putExtra("check1", checkbox1.isChecked());
				intent.putExtra("check2", checkbox2.isChecked());	
				startActivityForResult(intent,1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static boolean isEmailValid(String email) {
	    boolean isValid = false;

	    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = email;

	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if (matcher.matches()) {
	        isValid = true;
	    }
	    return isValid;
	}
	
	public static final boolean isValidPhoneNumber(CharSequence target) {
	    if (target == null || TextUtils.isEmpty(target)) {
	        return false;
	    } else {
	        return android.util.Patterns.PHONE.matcher(target).matches();
	    }
	}
	
	 protected void onSaveInstanceState(Bundle savedInstanceState) {
	      // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
	      super.onSaveInstanceState(savedInstanceState);
	      EditText edittext1 = (EditText)findViewById(R.id.edittext1);
	      savedInstanceState.putString("editext1", edittext1.getText().toString());
	      EditText edittext2 = (EditText)findViewById(R.id.edittext2);
	      savedInstanceState.putString("editext2", edittext2.getText().toString());
	      Log.d("tag", "onSaveInstanceState method was invoked");
	 }
	 
	 @Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState) {
	      // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
	      super.onRestoreInstanceState(savedInstanceState);
	      EditText editext1 = (EditText)findViewById(R.id.edittext1);
	      if ((savedInstanceState != null)){
	      	String s1 = savedInstanceState.getString("editext1");
	      	editext1.setText(s1);
	      }
	      EditText editext2 = (EditText)findViewById(R.id.edittext2);
	      if ((savedInstanceState != null)){
	      	String s2 = savedInstanceState.getString("editext2");
	      	editext2.setText(s2);
	      }
	      Log.d("tag", "onRestoreInstanceState method was invoked");
	    }
}
