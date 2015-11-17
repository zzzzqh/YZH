package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.example.sql.user;
import com.example.text.Treset;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Treset extends Activity {

	private Button bt9;
	private Button bt10;
	private ListView t_xinxi;
	private List<String> list=new ArrayList<String>();
	
	String password;
	String professical;
	String age;
	String sex;
	String email;
	String phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treset_view);
		
		bt9=(Button) findViewById(R.id.button9);
		bt10=(Button) findViewById(R.id.button10);
		t_xinxi=(ListView) findViewById(R.id.t_xinxi);
		
		

		
			Intent intent = this.getIntent();
			Bundle c = intent.getBundleExtra("data");
			password=c.getString("tiendtity_password");
			professical=c.getString("t_professical_aspect1");
			age=c.getString("tidentity_age");
			sex=c.getString("sex");
			email=c.getString("t_email");
			phone=c.getString("tphone_number");
			list.add("新密码："+password);
			list.add( "专业方向:"+professical);
			list.add("年龄："+age);
			list.add("性别："+sex);
			list.add("邮箱："+email);
			list.add("手机号码："+phone);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, list);
			t_xinxi.setAdapter(adapter);
			
			
			bt9.setOnClickListener(new OnClickListener() {

				@SuppressLint("ShowToast")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					user u=new user();
					String xingming=u.getXingming();
					
					String zhanghao=u.getZhanghao();
					
					String suoshuyuan=u.getSuoshuyuan();
					
					String quanxian=u.getQuanxian();
					
					if(password.isEmpty()){
						String mima=u.getMima();
						password=mima;
						
					}
					 
					if(professical.isEmpty())
					{
						String suoshuxi=u.getSuoshuxi();
						professical=suoshuxi;
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
					
					db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values("+"'"+zhanghao+"'"+","+"'"+password+"'"+","+"'"+xingming+"'"+","+"'"+suoshuyuan+"'"+","+"'"+professical+"'"+","+"'"+sex+"'"+","+"'"+Age+"'"+","+"'"+email+"'"+","+"'"+phone+"'"+","+"'"+quanxian+"'"+")");
					
					 
					
					Toast.makeText(Treset.this, "个人信息修改成功", 1).show();
					Intent intent = new Intent(Treset.this, Tidentity.class);
					Treset.this.startActivity(intent);
				}
			});
			bt10.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Treset.this, Tidentity.class);
					Treset.this.startActivity(intent);
				}
			});
		} 

	
}
