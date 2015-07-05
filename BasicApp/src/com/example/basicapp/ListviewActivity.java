package com.example.basicapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends Activity {
	ListView lv;
	String[] item = { "Nasi Goreng", "Mie Goreng", "Mie Rebus", "Magelangan", "Soto Ayam", "Sop Ayam", "Ayam Goreng"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		lv = (ListView) findViewById(R.id.idListview);
		
		ArrayAdapter<String> array_item = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, item);
		lv.setAdapter(array_item);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				//TODO Auto-generated method stub
				Toast.makeText(ListviewActivity.this, "Kamu memilih" + item[arg2], Toast.LENGTH_SHORT).show();
			}
		});
	}

}
