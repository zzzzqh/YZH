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

import com.example.sql.user;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Mreset extends Activity {

	private Button xinxixiugai;
	private Button fanhui;
	private ListView m_xinxi;
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
	private List<String> list=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mreset_view);
		
		xinxixiugai=(Button) findViewById(R.id.mrbutton1);
		fanhui=(Button) findViewById(R.id.mrbutton2);
		m_xinxi=(ListView) findViewById(R.id.m_xinxi);
		

		Intent intent = this.getIntent();
		Bundle c = intent.getBundleExtra("data");
		password=c.getString("miendtity_password");
		professical=c.getString("m_professical_aspect1");
		age=c.getString("midentity_age");
		sex=c.getString("sex");
		email=c.getString("m_email");
		phone=c.getString("mphone_number");
		list.add("新密码："+password);
		list.add( "专业方向:"+professical);
		list.add("年龄："+age);
		list.add("性别："+sex);
		list.add("邮箱："+email);
		list.add("手机号码："+phone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, list);
		m_xinxi.setAdapter(adapter);
		
		
		
		
		xinxixiugai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				user u=new user();
//				xingming=u.getName();
//				
//				 zhanghao=u.getZhanghao();
//				
//				 suoshuyuan=u.getYuan();
//				
//				 quanxian=u.getType();
//			
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
// 									Toast.makeText(Mreset.this, "修改成功", 1).show();
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

				
			
				
				 
				
				Intent intent = new Intent(Mreset.this, Midentity.class);
				Mreset.this.startActivity(intent);
			}
		});
         fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Mreset.this,Midentity.class);
//	            Mreset.this.startActivity(intent);
				Mreset.this.finish();
			}
         });
	}
	
	
}
