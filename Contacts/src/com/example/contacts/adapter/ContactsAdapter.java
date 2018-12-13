package com.example.contacts.adapter;

import java.util.List;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.contacts.R;
import com.example.contacts.domain.Contacts;

public class ContactsAdapter extends BaseAdapter {
	private List<Contacts> data;
	private Context context;

	public ContactsAdapter(List<Contacts> data, Context context) {
		super();
		this.data = data;
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.adapter, parent, false);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.election = (CheckBox) convertView
					.findViewById(R.id.election);
			convertView.setTag(holder); // 将Holder存储到convertView中
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(data.get(position).getName());
		holder.election.setVisibility(4);
		return convertView;
	}

	static class ViewHolder {
		TextView name;
		CheckBox election;
	}

}
