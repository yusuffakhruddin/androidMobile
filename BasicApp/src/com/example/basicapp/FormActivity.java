package com.example.basicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends Activity {
	EditText username, pass;
	Button blogin;
	String user_name="user";
	String password="user1234";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
		username = (EditText) findViewById(R.id.inUser);
		pass = (EditText) findViewById(R.id.inPass);
		blogin = (Button) findViewById(R.id.bLogin);
		
		blogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//TODO Auto-generated method stub
				String u = username.getText().toString();
				String p = pass.getText().toString();
				checklogin (u, p);
			}
		});
		
	}
	
	protected void checklogin(String u, String p) {
		//TODO Auto-generated method stub
		if (p.equals(password) && u.equals(user_name)){
			Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(FormActivity.this, MainActivity.class);
			startActivity(intent);
			this.finish();
		} else {
			Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
		}
	}

}
