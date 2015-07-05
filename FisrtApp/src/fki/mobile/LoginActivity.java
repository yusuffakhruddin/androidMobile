package fki.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		TextView registerScreen = (TextView) findViewById (R.id.link_to_register);
		
		registerScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Pindah ke halaman registrasi
				Intent i = new Intent (getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
	}
}
