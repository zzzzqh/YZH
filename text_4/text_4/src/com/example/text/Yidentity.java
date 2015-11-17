package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sql.user;
import com.example.text.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Yidentity extends Activity {

	private Button ybt8;
	private Button ybt9;
	private TextView tv1;
	private TextView tv2;
	private EditText yidentity_password,yidentity_age,y_email,yphone_number;
	private RadioButton yidentity_boy;
	private Spinner y_xueyuan;
	private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
		
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yidentity_view);
		ybt8=(Button) findViewById(R.id.ybutton8);
		ybt9=(Button) findViewById(R.id.ybutton9);
		tv1=(TextView) findViewById(R.id.yidentity_zhanghao);
		tv2=(TextView) findViewById(R.id.yidentity_mima);
		yidentity_password=(EditText) findViewById(R.id.yidentity_password);
		yidentity_age=(EditText) findViewById(R.id.yidentity_age);
		y_email=(EditText) findViewById(R.id.y_email);
		yphone_number=(EditText) findViewById(R.id.yphone_number);
		yidentity_boy=(RadioButton) findViewById(R.id.yidentity_boy);
		y_xueyuan=(Spinner) findViewById(R.id.y_xueyuan);
		
		user u=new user();
		String xingming=u.getXingming();
		String mima=u.getMima();
		tv1.setText("姓名:"+ xingming);
		tv2.setText("原始密码:"+ mima);
	    list.add("数计学院");
        list.add("机械学院");
        list.add("管理学院");
        list.add("电气学院");
        list.add("物信学院");
        list.add("材料学院");
        list.add("生物工程学院");     
        /*为列表定义一个适配器，这里用前面的List*/		
        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        /*为适配器设置下拉列表样式*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        //未spinner加載適配器
        y_xueyuan.setAdapter(adapter);
	
		
		ybt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Bundle c=new Bundle();
            	c.putString("yidentity_password",yidentity_password.getText().toString());
            	c.putString("yidentity_age",yidentity_age.getText().toString());
            	c.putString("y_email",y_email.getText().toString());
            	c.putString("yphone_number",yphone_number.getText().toString());
            	c.putString("y_xueyuan", y_xueyuan.getSelectedItem().toString());
            	
            	if(yidentity_boy.isChecked()){
    				c.putString("sex", "男");
    			}else{
    				c.putString("sex", "女");
    			}
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yidentity.this,Yreset.class);
				intent.putExtra("data", c);
				
				Yidentity.this.startActivity(intent);
			}
		});
		ybt9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yidentity.this,Ymain.class);
				Yidentity.this.startActivity(intent);
			}
		});
	}
	
	
}
