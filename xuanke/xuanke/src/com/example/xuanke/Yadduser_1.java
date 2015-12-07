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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sql.user;

import android.R.string;
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

public class Yadduser_1 extends Activity{
	
	private Button queren,quxiao;
	private ListView adduser_xinxi;
	
	String zhigonghao;
	String name;
	String password;
	String power;
	String phone;
	String result=null;
	
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
		list.add("用户名:"+zhigonghao);
		list.add("姓名:"+name);
		list.add("初始密码："+password);
		list.add("用户权限:"+power);
		list.add("联系电话:"+phone);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		adduser_xinxi.setAdapter(adapter);
		
		
		
		
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 new AsyncTask<String, Void, Void>(){

						@Override
						protected Void doInBackground(String... params) {
						String url="http://115.28.69.231/android/adduser.php";
							HttpPost httprequest=new HttpPost(url);
							List<NameValuePair>param=new ArrayList<NameValuePair>();
							param.add(new BasicNameValuePair("zhanggao",zhigonghao));
							param.add(new BasicNameValuePair("mima",password));
							param.add(new BasicNameValuePair("name",name));
							param.add(new BasicNameValuePair("type",power));
							param.add(new BasicNameValuePair("telephone",phone));
						
							try {
								HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
								httprequest.setEntity(httpEntity);
								HttpClient httpClient=new DefaultHttpClient();
								HttpResponse httpResponse=httpClient.execute(httprequest);
								if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
									result=EntityUtils.toString(httpResponse.getEntity());
									//Toast.makeText(Yadduser_1.this,result, 1).show();
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
				
				//if(result.equals("success")){
					Intent intent=new Intent(Yadduser_1.this,Yadduser.class);
					Yadduser_1.this.startActivity(intent);
//					
//				}
//				else{
//					Toast.makeText(Yadduser_1.this,"12", 1).show();
//					Intent intent=new Intent(Yadduser_1.this,Yadduser_1.class);
//					Yadduser_1.this.startActivity(intent);
//				}
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(Yadduser_1.this, "添加成功", 1).show();
//					Intent intent=new Intent(Yadduser_1.this,Yadduser.class);//保留之前输入的信息
//					Yadduser_1.this.startActivity(intent);
					Yadduser_1.this.finish();
				}
			});
		
		
	}		
		

	
	

}
