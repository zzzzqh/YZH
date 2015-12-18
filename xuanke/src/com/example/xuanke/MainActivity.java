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
import com.example.xuanke.MainActivity;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button denglu;
	EditText username;
	EditText password;
	String user;
	
	String n1,p1;
    String mima=null;
    String type=null;
    String zhanghao=null;
    String name=null;
    String age=null;
    String xi=null;
    String email=null;
    String yuan=null;
    String sex=null;
    String telephone=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        denglu=(Button) findViewById(R.id.main_button0);
        username=(EditText) findViewById(R.id.main_user_name);
        password=(EditText) findViewById(R.id.main_input_password);
        denglu.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 n1=username.getText().toString().trim();
	             p1=password.getText().toString().trim();
	     
	            if(n1.equals("")|| p1.equals("")){
					Toast.makeText(MainActivity.this, "请填写完整信息", 1).show();
					Intent intent=new Intent(MainActivity.this,MainActivity.class);
					MainActivity.this.startActivity(intent);
				}
	            else
	            {
	            	 new AsyncTask<String, Void, Void>(){

	 					@Override
	 					protected Void doInBackground(String... params) {
	 					String url="http://115.28.69.231/android/login.php";
	 						HttpPost httprequest=new HttpPost(url);
	 						List<NameValuePair>param=new ArrayList<NameValuePair>();
	 						param.add(new BasicNameValuePair("zhanggao",n1));
	 						param.add(new BasicNameValuePair("mima", p1));
	 						try {
	 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
	 							httprequest.setEntity(httpEntity);
	 							HttpClient httpClient=new DefaultHttpClient();
	 							HttpResponse httpResponse=httpClient.execute(httprequest);
	 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
	 								String result=EntityUtils.toString(httpResponse.getEntity());
	 								if(result.toString().trim().equals("error")){
	 									 Toast.makeText(MainActivity.this, "用户名不存在,或密码错误", 1).show();
	 			                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
	 			     					 MainActivity.this.startActivity(intent);
	 								}
	 								else
	 								{
	 								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
	 								for(int i=0;i<jsonArray.length();i++){
	 									user u=new user();
	 									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
	 									zhanghao=jsoObject.getString("zhanggao");u.setZhanghao(zhanghao);
	 									mima=jsoObject.getString("mima");u.setMima(mima);
	 									name=jsoObject.getString("name");u.setName(name);
	 									yuan=jsoObject.getString("yuan");u.setYuan(yuan);
	 									xi=jsoObject.getString("xi");u.setXi(xi);
	 									age=jsoObject.getString("age");u.setAge(age);
	 									sex=jsoObject.getString("sex");u.setSex(sex);
	 									email=jsoObject.getString("email");u.setEmail(email);
	 									telephone=jsoObject.getString("telephone");u.setTelephone(telephone);
	 									type=jsoObject.getString("type");u.setType(type);
	 									
	 								
	 								}
	 			                		 
	 				                	
	 				                		 if("t".equals(type)){
	 				                		 Intent intent=new Intent(MainActivity.this,Tmain.class);
	 				                		 MainActivity.this.startActivity(intent);
	 				                		 }
	 				                		 else if("x".equals(type)){
	 				                		 
	 				                			 Intent intent=new Intent(MainActivity.this,Mmain.class);
	 				                			 MainActivity.this.startActivity(intent);
	 				                		 }
	 				                		 else if("y".equals(type)){
	 				                			 Intent intent=new Intent(MainActivity.this,Ymain.class);
	 				                			 MainActivity.this.startActivity(intent);
	 				                		 }
	 				                	 
	 								}
	 							}
	 							
	 						else
	 						{
	 							Toast.makeText(MainActivity.this, "连接有问题", Toast.LENGTH_SHORT).show();
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
			}
        
	 		
	 		});
		
       
    }
    
    
}


