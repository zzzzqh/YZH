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

import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Mmanager extends Activity {

	private Button weixuankejiaoshi;
	private Button tijiaoshenhe;
	String name;
	String type;
	String donot;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mmanager_view);
		weixuankejiaoshi=(Button) findViewById(R.id.mmabutton1);
		tijiaoshenhe=(Button) findViewById(R.id.mmabutton2);
		weixuankejiaoshi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmanager.this,Yunteacher.class);
				Mmanager.this.startActivity(intent); 
			}
		});
		tijiaoshenhe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user u=new user();
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
	 						try {
	 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
	 							httprequest.setEntity(httpEntity);
	 							HttpClient httpClient=new DefaultHttpClient();
	 							HttpResponse httpResponse=httpClient.execute(httprequest);
	 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
	 								String result=EntityUtils.toString(httpResponse.getEntity());
	 								if(result.equals("success")){
	 									Toast.makeText(Mmanager.this, "修改成功", 1).show();
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
				Toast.makeText(Mmanager.this, "提交申请成功", 1).show();
				Intent intent =new Intent(Mmanager.this,Mmain.class);
			}
		});
		}
			
		
	

	
}
