package com.example.xuanke;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sql.user;
import com.example.xuanke.R.id;

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

	private Button querenxiugai;
	private Button fanhui;
	String password;
	String professical;
	String age;
	String sex;
	String email;
	String phone;
	String xingming=null;
	
	String zhanghao=null;
	String suoshuyuan=null;
	
	String quanxian=null;
	private ListView y_xm;
	private ListView y_mm;
	private ListView y_pf;
	private ListView y_em;
	private ListView y_ph;
	private ListView y_sex;
	private ListView y_age;
	
	private List<String> xm=new ArrayList<String>();
	private List<String> mm=new ArrayList<String>();
	private List<String> pf=new ArrayList<String>();
	private List<String> em=new ArrayList<String>();
	private List<String> ph=new ArrayList<String>();
	private List<String> s=new ArrayList<String>();
	private List<String> ag=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yreset_view);
		querenxiugai=(Button) findViewById(R.id.ybutton10);
		fanhui=(Button) findViewById(R.id.ybutton11);
		
        y_xm=(ListView) findViewById(R.id.yreset_name);
        y_mm=(ListView) findViewById(R.id.yreset_mima);
        y_pf=(ListView) findViewById(R.id.yreset_xueyuan);
        y_em=(ListView) findViewById(R.id.yreset_email);
        y_ph=(ListView) findViewById(R.id.yreset_phone);
        y_sex=(ListView) findViewById(R.id.yreset_sex);
        y_age=(ListView) findViewById(R.id.yreset_age);
        
		

        Intent intent = this.getIntent();
		Bundle c = intent.getBundleExtra("data");
		password=c.getString("yidentity_password");
		professical=c.getString("y_xueyuan");
		age=c.getString("yidentity_age");
		sex=c.getString("sex");
		email=c.getString("y_email");
		phone=c.getString("yphone_number");
		mm.add("新密码："+password);
		pf.add( "专业方向:"+professical);
		ag.add("年龄："+age);
		s.add("性别："+sex);
		em.add("邮箱："+email);
		ph.add("手机号码："+phone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, pf);
		y_pf.setAdapter(adapter);
	
		
		querenxiugai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user u=new user();
//				xingming=u.getName();
//				
//				 zhanghao=u.getZhanghao();
//				
//				 suoshuyuan=u.getYuan();
//				
//				 quanxian=u.getType();
			
//				if(password.isEmpty()){
//					String mima=u.getMima();
//					password=mima;
//					
//				}
//				 
//				if(professical.isEmpty())
//				{
//					String suoshuxi=u.getXi();
//					professical=suoshuxi;
//				}
//				
//				if(age.isEmpty())
//				{
//					String nianlin=u.getAge();
//					age=nianlin;
//					
//				}
//				
//				if(sex.isEmpty())
//				{
//					String xingbie=u.getSex();
//					sex=xingbie;
//				}
//				 
//				if(email.isEmpty())
//				{
//					String youxiang=u.getEmail();
//					email=youxiang;
//				}
//				
//				if(phone.isEmpty())
//				{
//					String shouji=u.getTelephone();
//					phone=shouji;
//				}
//				new AsyncTask<String, Void, Void>(){
//
// 					@Override
// 					protected Void doInBackground(String... params) {
// 					String url="http://115.28.69.231/android/changgeoneself.php";
// 						HttpPost httprequest=new HttpPost(url);
// 						List<NameValuePair>param=new ArrayList<NameValuePair>();
// 						param.add(new BasicNameValuePair("zhanggao",zhanghao));
// 						param.add(new BasicNameValuePair("mima", password));
// 						param.add(new BasicNameValuePair("name",xingming));
// 						param.add(new BasicNameValuePair("yuan",suoshuyuan));
// 						param.add(new BasicNameValuePair("xi", professical));
// 						param.add(new BasicNameValuePair("age", age));
// 						param.add(new BasicNameValuePair("sex", sex));
// 						param.add(new BasicNameValuePair("email", email));
// 						param.add(new BasicNameValuePair("telephone", phone));
// 						try {
//							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
//							httprequest.setEntity(httpEntity);
// 							HttpClient httpClient=new DefaultHttpClient();
// 							HttpResponse httpResponse=httpClient.execute(httprequest);
// 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
// 								String result=EntityUtils.toString(httpResponse.getEntity());
// 								if(result.equals("success")){
// 									Toast.makeText(Yreset.this, "修改成功", 1).show();
// 								}
// 							}
//						} catch (UnsupportedEncodingException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (ClientProtocolException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
// 						return null;
// 						
// 					}
// 					
// 				}.execute("http://115.28.69.231/index.php");
//
//				
//			
//				
//				 
				
				Yreset.this.finish();
			}
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Yreset.this,Yidentity.class);
//				Yreset.this.startActivity(intent);
				Yreset.this.finish();
			}
		});
	}

	
}
