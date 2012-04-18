package hwan.example.report.adapter;

import hwan.example.report.activity.R;
import hwan.example.report.model.MyData;

import java.util.List;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {
	private Context context;
	private int layoutId;
	private List<MyData> items;
	private LayoutInflater layoutInflater;

	public CustomAdapter(Context context, int layoutId, List<MyData> items) {
		super();
		this.context = context;
		this.layoutId = layoutId;
		this.items = items;
		this.layoutInflater = (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount() {
		return items.size();
	}

	public Object getItem(int index) {
		return items.get(index);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int index, View view, ViewGroup viewGroup) {
		final int position = index;
		if (view == null) {
			view = layoutInflater.inflate(layoutId, null);
		}
		
		TextView timeTextView = (TextView)view.findViewById(R.id.timeView);
		TextView memoTitleTextView = (TextView)view.findViewById(R.id.memotitleView);
		TextView dateTextView = (TextView)view.findViewById(R.id.dateView);

		timeTextView.setText(items.get(position).getTime());
		memoTitleTextView.setText(items.get(position).getTitle());
		dateTextView.setText(items.get(position).getDate());
		
		Button removeButton = (Button)view.findViewById(R.id.removebutton);
		removeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				items.remove(position);
				notifyDataSetChanged();
			}
		});
		view.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			Toast.makeText(context, items.get(position).getMemo(), Toast.LENGTH_SHORT).show();	
			}
		});
		return view;
	}

}
