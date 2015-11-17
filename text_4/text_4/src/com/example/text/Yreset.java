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
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Yreset extends Activity {

	private Button ybt10;
	private Button ybt11;
	String password;
	String professical;
	String age;
	String sex;
	String email;
	String phone;
	private ListView y_xinxi;
	private List<String> list=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yreset_view);
		ybt10=(Button) findViewById(R.id.ybutton10);
		ybt11=(Button) findViewById(R.id.ybutton11);
		
        y_xinxi=(ListView) findViewById(R.id.y_xinxi);
		

       Intent intent = this.getIntent();
		Bundle c = intent.getBundleExtra("data");
		password=c.getString("yidentity_password");
		professical=c.getString("y_xueyuan");
		age=c.getString("yidentity_age");
		sex=c.getString("sex");
		email=c.getString("y_email");
		phone=c.getString("yphone_number");
		list.add("新密码："+password);
		list.add( "专业方向:"+professical);
		list.add("年龄："+age);
		list.add("性别："+sex);
		list.add("邮箱："+email);
		list.add("手机号码："+phone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, list);
		y_xinxi.setAdapter(adapter);
	
		
		ybt10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user u=new user();
				String xingming=u.getXingming();
				
				String zhanghao=u.getZhanghao();
				
				String suoshuxi=u.getSuoshuxi();
				
				String quanxian=u.getQuanxian();
				
				if(password.isEmpty()){
					String mima=u.getMima();
					password=mima;
					
				}
				 
				if(professical.isEmpty())
				{
					String suoshuyuan=u.getSuoshuyuan();
					professical=suoshuyuan;
				}
				
				if(age.isEmpty())
				{
					String nianlin=u.getNianlin();
					age=nianlin;
					int Age=Integer.valueOf(age);
				}
				
				if(sex.isEmpty())
				{
					String xingbie=u.getXingbie();
					sex=xingbie;
				}
				 
				if(email.isEmpty())
				{
					String youxiang=u.getYouxiang();
					email=youxiang;
				}
				
				if(phone.isEmpty())
				{
					String shouji=u.getShouji();
					phone=shouji;
				}
				 
				int Age=Integer.valueOf(age);
			
				SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
				
				db.delete("usertb", "zhanghao=?", new String[]{zhanghao});
				
				db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values("+"'"+zhanghao+"'"+","+"'"+password+"'"+","+"'"+xingming+"'"+","+"'"+professical+"'"+","+"'"+suoshuxi+"'"+","+"'"+sex+"'"+","+"'"+Age+"'"+","+"'"+email+"'"+","+"'"+phone+"'"+","+"'"+quanxian+"'"+")");
				
				Toast.makeText(Yreset.this, "个人信息修改成功", 1).show();
				Intent intent=new Intent(Yreset.this,Yidentity.class);
				Yreset.this.startActivity(intent);
			}
		});
		ybt11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yreset.this,Yidentity.class);
				Yreset.this.startActivity(intent);
			}
		});
	}

	
}
