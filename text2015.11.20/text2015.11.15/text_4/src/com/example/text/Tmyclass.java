package com.example.text;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sql.user;
import com.example.text.Tmyclass;
import com.example.text.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Tmyclass extends Activity {

	private Button tianjiaxuanke;
	private Button tijiaoxuanke;
	String name;
	String type;
	String donot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tmyclass);
		tianjiaxuanke=(Button) findViewById(R.id.button2);
		tijiaoxuanke=(Button) findViewById(R.id.button3);
		
		tianjiaxuanke.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user u =new user();
				name=u.getName();
				type=u.getType();
				new AsyncTask<String, Void, Void>(){

 					@Override
 					protected Void doInBackground(String... params) {
 					String url="http://115.28.69.231/android/setstate.php";//chaxun
 						HttpPost httprequest=new HttpPost(url);
 						List<NameValuePair>param=new ArrayList<NameValuePair>();
 						param.add(new BasicNameValuePair("name",name));
 						param.add(new BasicNameValuePair("type", type));
 					
 						HttpEntity httpEntity;
						try {
							httpEntity = new UrlEncodedFormEntity(param,"utf-8");
							httprequest.setEntity(httpEntity);
							HttpClient httpClient=new DefaultHttpClient();
							HttpResponse httpResponse=httpClient.execute(httprequest);
							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
 								String result=EntityUtils.toString(httpResponse.getEntity());
 								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
 								for(int i=0;i<jsonArray.length();i++){
 									
 									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
 									 donot=jsoObject.getString("do");
 									
 								}
 								if(donot.equals("yes")){
										Toast.makeText(Tmyclass.this, "您已提交选课无法修改", 1).show();
										Intent intent=new Intent(Tmyclass.this,Tmyclass.class);
						                Tmyclass.this.startActivity(intent); 
									}
									else{
										Intent intent=new Intent(Tmyclass.this,Taddclass.class);
						                Tmyclass.this.startActivity(intent); 
									}
 							}
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
 					
 						return null;
 						
 					}
 					
 				}.execute("http://115.28.69.231/index.php");
				
			}
		});
		tijiaoxuanke.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				user u= new user();
				name=u.getName();
				type=u.getType();
				new AsyncTask<String, Void, Void>(){

 					@Override
 					protected Void doInBackground(String... params) {
 					String url="http://115.28.69.231/android/login.php";
 						HttpPost httprequest=new HttpPost(url);
 						List<NameValuePair>param=new ArrayList<NameValuePair>();
 						param.add(new BasicNameValuePair("name",name));
 						param.add(new BasicNameValuePair("type", type));
 						param.add(new BasicNameValuePair("do", "yes"));
 						HttpEntity httpEntity;
						try {
							httpEntity = new UrlEncodedFormEntity(param,"utf-8");
							httprequest.setEntity(httpEntity);
							HttpClient httpClient=new DefaultHttpClient();
							HttpResponse httpResponse=httpClient.execute(httprequest);
							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
 								String result=EntityUtils.toString(httpResponse.getEntity());
 								if(result.equals("success")){
 									Toast.makeText(Tmyclass.this, "修改成功", 1).show();
 								}
 							}
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
 					
 						return null;
 						
 					}
 					
 				}.execute("http://115.28.69.231/index.php");
				Toast.makeText(Tmyclass.this, "提交申请成功", 1).show();
			}
		});
	}
	
	
}
