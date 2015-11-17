package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Ydeluser_1 extends Activity{
	
	
	private Button del;
	private Button back;
	private ListView ydeluser_xinxi;
	
	String zhanghao;
	String name;
	String password;
	String power;
	String phone;
	
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ydeluser_1);
		del=(Button) findViewById(R.id.ydeluser_1_queren);
		back=(Button) findViewById(R.id.ydeluser_1_back);
		ydeluser_xinxi=(ListView) findViewById(R.id.ydeluser_xinxi);
		
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();
		
		
		zhanghao=b.getString("yonghuming");
		name=b.getString("xingming");
		password=b.getString("mima");
		power=b.getString("quanxian");
		phone=b.getString("shouji");
		/*
		password
		power
		phone����������Ӧ����ͨ���������ݿ�����������Ϣƥ����û���Ȼ����ʾ����
		*/
		list.add("�û���:"+zhanghao);
		list.add("����:"+name);
		list.add("��ʼ���룺"+password);
		list.add("�û�Ȩ��:"+power);
		list.add("��ϵ�绰:"+phone);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		ydeluser_xinxi.setAdapter(adapter);
		

		del.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
				db.delete("usertb", "zhanghao=?", new String[]{zhanghao});
				Toast.makeText(Ydeluser_1.this, "ɾ���û��ɹ�", 1).show();
				Intent intent=new Intent(Ydeluser_1.this,Ymanageruser.class);
				Ydeluser_1.this.startActivity(intent);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Ydeluser_1.this,Ydeluser.class);
				Ydeluser_1.this.startActivity(intent);
			}
		});
	}

	

}
