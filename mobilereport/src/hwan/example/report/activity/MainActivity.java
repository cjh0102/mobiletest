package hwan.example.report.activity;

import hwan.example.report.adapter.CustomAdapter;
import hwan.example.report.model.MyData;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	enum MessageType {
		SUCCESS, FAIL
	}
	private List<MyData> items;
	private CustomAdapter customAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		items = new ArrayList<MyData>();
		
		customAdapter = new CustomAdapter(this, R.layout.items_list_view, items);
		ListView listView = (ListView)findViewById(R.id.memolistview);
		listView.setAdapter(customAdapter);
				
		Button addButton  = (Button)findViewById(R.id.addbutton);
		addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, MemoActivity.class);
				startActivityForResult(intent, MessageType.SUCCESS.ordinal());
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == MessageType.SUCCESS.ordinal()) {
			if (resultCode == RESULT_OK) {
				MyData myData = new MyData();

				myData.setTitle(intent.getStringExtra("title"));
				myData.setMemo(intent.getStringExtra("memo"));
				myData.setTime(intent.getStringExtra("time"));
				myData.setDate(intent.getStringExtra("date"));
				
				items.add(myData);
				customAdapter.notifyDataSetChanged();
			} else if (resultCode == RESULT_CANCELED) {
				;
			}
		}
	}
}