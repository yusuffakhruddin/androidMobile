package fki.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private Button btnLinkToLogin, btnRegister;
	private EditText inputEmail, inputPassword, inputFullName;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		inputFullName = (EditText) findViewById(R.id.name_register);
		inputEmail = (EditText) findViewById(R.id.email_register);
		inputPassword =(EditText) findViewById(R.id.password_register);
		btnRegister = (Button) findViewById(R.id.btnRegisterTo);
		btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
		
		btnRegister.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				String name = inputFullName.getText().toString();
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();
				
				if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
					Toast.makeText(getApplicationContext(),
							"Disini akan diproses registrasi user baru", Toast.LENGTH_LONG).show();
					//registerUser (name, email, password);
				} else {
					Toast.makeText(getApplicationContext(),
							"Please enter your details!", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		btnLinkToLogin.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				//pindahkan ke halaman Login
				Intent i = new Intent (getApplicationContext(), LoginActivity.class);
				startActivity(i);
				finish();
			}
		});
		}
}

