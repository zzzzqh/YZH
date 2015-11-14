package com.example.text;

import java.util.ArrayList;

import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Mreset extends Activity {

	private Button bt1;
	private Button bt2;
	private ListView y_xinxi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mreset_view);
		
		bt1=(Button) findViewById(R.id.mrbutton1);
		bt2=(Button) findViewById(R.id.mrbutton2);
		y_xinxi=(ListView) findViewById(R.id.y_xinxi);
		
		
		Intent intent= this.getIntent();
		Bundle b= intent.getBundleExtra("data");
		
		List list=new ArrayList();
		list.add(b.getString("name"));
		list.add(b.getString("user_name"));
		list.add(b.getString("password"));
		list.add(b.getInt("age"), 0);
		list.add(b.getString("sex"));
		list.add(b.getString("email"));
		list.add(b.getString("phone"));
		
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked,list);
		y_xinxi.setAdapter(adapter);
		
		
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Mreset.this, "个人信息修改成功", 1).show();
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
		});
         bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
         });
	}
	
	
}
