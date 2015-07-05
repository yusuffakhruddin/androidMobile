package fki.mobile;

import java.sql.Date;
import java.text.SimpleDateFormat;
import fki.mobile.helper.SQLiteHandler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	private Button btnLinkToLogin, btnRegister;
	private EditText inputEmail, inputPassword, inputFullName;
	
	private SQLiteHandler db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		inputFullName = (EditText) findViewById(R.id.name_register);
		inputEmail = (EditText) findViewById(R.id.email_register);
		inputPassword =(EditText) findViewById(R.id.password_register);
		btnRegister = (Button) findViewById(R.id.btnRegisterTo);
		btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
		
		//SQLite database handler
		db = new SQLiteHandler(getApplicationContext());
		
		btnRegister.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			String name = inputFullName.getText().toString();
			String email = inputEmail.getText().toString();
			String password = inputPassword.getText().toString();
				
			if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
				registerUser(name, email, password);
				} else {
					Toast.makeText(getApplicationContext(),
							"Please enter your details!", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		btnLinkToLogin.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				GoToLogin();
			}
		});
		}
	private void GoToLogin(){
		Intent i = new Intent(getApplicationContext(), LoginActivity.class);
		startActivity(i);
		finish();
	}
	
	private void registerUser(final String name, final String email, final String password){
		//string tag_string_req="req_register";
		String uid = name;
		Date tanggal = new Date(0);
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd");
		String created_at = ft.format(tanggal); //"0000-00-00";
		
		db.addUser(name, email, password, uid, created_at);
	
	}
}

