package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
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

public class Yadduser_1 extends Activity{
	
	private Button queren,quxiao;
	private ListView adduser_xinxi;
	
	String zhigonghao;
	String name;
	String password;
	String power;
	String phone;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yadduser_1);
		
		adduser_xinxi =(ListView) findViewById(R.id.adduser_xinxi);
		queren=(Button) findViewById(R.id.adduser_1_button1);
		quxiao=(Button) findViewById(R.id.adduser_1_button2);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		
		
		zhigonghao=b.getString("yadduser_zhigonghao");
		name=b.getString("yadduser_name");
		password=b.getString("yadduser_password");
		power=b.getString("yadduser_power");
		phone=b.getString("yadduser_phone");
		
		

		List<String> list=new ArrayList<String>();
		list.add("�û���:"+zhigonghao);
		list.add("����:"+name);
		list.add("��ʼ���룺"+password);
		list.add("�û�Ȩ��:"+power);
		list.add("��ϵ�绰:"+phone);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		adduser_xinxi.setAdapter(adapter);
		
		
		
		
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
				System.out.println("ccc");
				db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values("+"'"+zhigonghao+"'"+","+"'"+password+"'"+","+"'"+name+"'"+",'��ѧ��������ѧѧԺ','xx','xx',0,'xx',"+"'"+phone+"'"+","+"'"+power+"'"+")");
				 System.out.println("ddd");
				Toast.makeText(Yadduser_1.this, "��ӳɹ�", 1).show();
				Intent intent=new Intent(Yadduser_1.this,Yadduser.class);//������֮ǰ�������Ϣ��������д
				Yadduser_1.this.startActivity(intent);
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(Yadduser_1.this,Yadduser.class);//����֮ǰ�������Ϣ
					Yadduser_1.this.startActivity(intent);
				}
			});
		
		
	}		
		

	
	

}
