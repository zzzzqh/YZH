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
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
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
		 new AsyncTask<String, Void, Void>(){

				@Override
				protected Void doInBackground(String... params) {
				String url="http://115.28.69.231/android/delete.php";
					HttpPost httprequest=new HttpPost(url);
					List<NameValuePair>param=new ArrayList<NameValuePair>();
					param.add(new BasicNameValuePair("zhanggao",zhanghao));
				
					try {
						HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
						httprequest.setEntity(httpEntity);
						HttpClient httpClient=new DefaultHttpClient();
						HttpResponse httpResponse=httpClient.execute(httprequest);
						if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
							String result=EntityUtils.toString(httpResponse.getEntity());
							JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
							for(int i=0;i<jsonArray.length();i++){
								user u=new user();
								JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
								zhanghao=jsoObject.getString("zhanggao");
								password=jsoObject.getString("mima");
								name=jsoObject.getString("name");
								phone=jsoObject.getString("telephone");
								power=jsoObject.getString("type");
							
							
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
		
		/*
		password
		power
		phone这三个舒心应该是通过查找数据库中与输入信息匹配的用户，然后显示出来
		*/
		list.add("用户名:"+zhanghao);
		list.add("姓名:"+name);
		list.add("初始密码："+password);
		list.add("用户权限:"+power);
		list.add("联系电话:"+phone);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		ydeluser_xinxi.setAdapter(adapter);
		

		del.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 new AsyncTask<String, Void, Void>(){

						@Override
						protected Void doInBackground(String... params) {
						String url="http://115.28.69.231/android/login.php";
							HttpPost httprequest=new HttpPost(url);
							List<NameValuePair>param=new ArrayList<NameValuePair>();
							param.add(new BasicNameValuePair("zhanggao",zhanghao));
						
							try {
								HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
								httprequest.setEntity(httpEntity);
								HttpClient httpClient=new DefaultHttpClient();
								HttpResponse httpResponse=httpClient.execute(httprequest);
		
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
				
				Toast.makeText(Ydeluser_1.this, "删除用户成功", 1).show();
				Intent intent=new Intent(Ydeluser_1.this,Ymanageruser.class);
				Ydeluser_1.this.startActivity(intent);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				Intent intent=new Intent(Ydeluser_1.this,Ydeluser.class);
//				Ydeluser_1.this.startActivity(intent);
				Ydeluser_1.this.finish();
			}
		});
	}

	

}
