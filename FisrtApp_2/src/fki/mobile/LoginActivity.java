package fki.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private Button btnLogin, btnRegister;
	private EditText inputEmail, inputPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		inputEmail = (EditText) findViewById(R.id.email_login);
		inputPassword =(EditText) findViewById(R.id.password_login);
		btnLogin = (Button) findViewById(R.id.btnLoginTo);
		btnRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
		
		btnLogin.setOnClickListener(new View.OnClickListener(){
			public void onClick (View v) {
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();;
				//memeriksa apakah user telah memasukkan data username & password
				if (email.trim().length() > 0 && password.trim().length() > 0){
					//cek username dan pass dengan database disini
					Toast.makeText(getApplicationContext(),
							"username :" +email + "password : "+ password, Toast.LENGTH_LONG).show();
				}else {
					//user belum memasukkan data user dan pass
					Toast.makeText(getApplicationContext(),
							"Masukkan user dan pass! ", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		btnRegister.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				//pindahkan ke halaman Registrasi
				Intent i = new Intent (getApplicationContext(), RegisterActivity.class);
				startActivity(i);
				finish();
			}
		});
		}
			
}
