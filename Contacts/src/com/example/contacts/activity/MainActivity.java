package com.example.contacts.activity;

import java.util.List;

import com.example.contacts.R;
import com.example.contacts.R.id;
import com.example.contacts.R.layout;
import com.example.contacts.adapter.ContactsAdapter;
import com.example.contacts.database.DataBaseOperation;
import com.example.contacts.domain.Contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ContactsAdapter adapter;
	private int edit;
	private Button bedit;
	private TextView line;
	private Button delete;
	private Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DataBaseOperation db = new DataBaseOperation();
		/*for (int i = 0; i < 20; i++) {
			Contacts c = new Contacts();
			c.setName("name" + i);
			c.setPhone(i);
			db.insert(c);
		}*/
		List<Contacts> list = db.listAll(Contacts.class);

		adapter = new ContactsAdapter(list, MainActivity.this);

		ListView lv = (ListView) findViewById(R.id.list);                          
		lv.setAdapter(adapter);

		edit = 0;
		editclick();

	}

	public void editclick() {
		line = (TextView) super.findViewById(R.id.line);
		delete = (Button) super.findViewById(R.id.delete);
		bedit = (Button) super.findViewById(R.id.edit);
		add = (Button) super.findViewById(R.id.add);

		bedit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (edit == 0) {
					delete.setVisibility(0);
					line.setVisibility(0);
					add.setTextSize(16);
					bedit.setText("取消");
					add.setText("全选");
					edit++;
				} else {
					delete.setVisibility(8);
					line.setVisibility(8);
					add.setTextSize(28);
					bedit.setText("编辑");
					add.setText("+");
					edit--;
				}
			}

		});
	}
}
