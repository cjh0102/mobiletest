package hwan.example.report.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memo);
		
		Button memoAddButton = (Button)findViewById(R.id.memoaddbutton);
		
		memoAddButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				
				EditText titleEditText = (EditText)findViewById(R.id.titleEditText1);
				EditText memoEditText = (EditText)findViewById(R.id.memoEditText);

			
				String title = titleEditText.getText().toString();
				String memo = memoEditText.getText().toString();
				if (title.length() == 0) {
					Toast.makeText(MemoActivity.this, "제목을 입력하세요", Toast.LENGTH_SHORT).show();
				} else if (memo.length() == 0) {
					Toast.makeText(MemoActivity.this, "메모내용을 입력하세요", Toast.LENGTH_SHORT).show();
				} else {
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
