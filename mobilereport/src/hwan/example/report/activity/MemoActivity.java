package hwan.example.report.activity;

import hwan.example.report.model.MyData;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MemoActivity extends Activity {
	private EditText titleEditText;
	private EditText memoEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memo);
		
		titleEditText = (EditText)findViewById(R.id.titleEditText1);
		memoEditText = (EditText)findViewById(R.id.memoEditText);
		Button memoAddButton = (Button)findViewById(R.id.memoaddbutton);
		
		memoAddButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
			
				String title = titleEditText.getText().toString();
				String memo = memoEditText.getText().toString();
				String date = new SimpleDateFormat("yyy-MM-dd").format(new Date());
				String time = new SimpleDateFormat("HH:mm").format(new Date());
				
				Intent intent = new Intent();
				
				intent.putExtra("title", title);
				intent.putExtra("memo", memo);
				intent.putExtra("date", date);
				intent.putExtra("time", time);

				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
		Button cancleButton = (Button)findViewById(R.id.canclebutton);
		cancleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
}
