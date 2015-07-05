package fki.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btnLogout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogout = (Button) findViewById(R.id.btnLogout);
		
		//logout button click event
		btnLogout.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				logoutUser();
				
			}
		});
		
	}
	//fungsi logout
	private void logoutUser(){
		//perintah2 yang perlu dijalankan
		//saat proses logouot ada disini
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}
