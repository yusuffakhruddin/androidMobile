package fki.mobile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListView extends ListActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		String[] ormawa_fki = getResources().getStringArray(R.array.ormawa_fki);
		
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, ormawa_fki));
		
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id){
				String product = ((TextView) view).getText().toString();
				Intent i = new Intent(getApplicationContext(), SingleListItem.class);
				i.putExtra("product", product);
				startActivity(i);
			}
		});
	}
}
