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

import com.example.sql.douser;
import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Yresetuser extends Activity {

	private Button xiugai;
	private Button fanhui;
	   String pw=null;
       String qx=null;
       String zh=null;
       String xm=null;
       int nl=0;
       String sj=null;
       String yx=null;
       String sy=null;
       String sx=null;
       String sb=null;
       String n1=null;
       String p1=null;
	private EditText yonghuming,xingming;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_view);
		xiugai=(Button) findViewById(R.id.ybutton17);
		fanhui=(Button) findViewById(R.id.ybutton18);
		
		yonghuming=(EditText) findViewById(R.id.yresetuser_user_name);
		xingming=(EditText) findViewById(R.id.yresetuser_input_password);
		
		xiugai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 n1=yonghuming.getText().toString().trim();
	           p1=xingming.getText().toString().trim();
	         
	            if(n1.equals("")|| p1.equals("")){
					Toast.makeText(Yresetuser.this, "请填写完整信息", 1).show();
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
	 						param.add(new BasicNameValuePair("name", p1));
	 						try {
	 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
	 							httprequest.setEntity(httpEntity);
	 							HttpClient httpClient=new DefaultHttpClient();
	 							HttpResponse httpResponse=httpClient.execute(httprequest);
	 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
	 								String result=EntityUtils.toString(httpResponse.getEntity());
	 								if(result.equals("error")){
	 									 Toast.makeText(Yresetuser.this, "帐号姓名不匹配", 1).show();
	 			                		 Intent intent=new Intent(Yresetuser.this,Yresetuser.class);
	 			                		Yresetuser.this.startActivity(intent);
	 								}
	 								else
	 								{
	 									
	 					            	 
	 					            		
	 					            		
	 												Bundle b=new Bundle();
	 												b.putString("yonghuming", yonghuming.getText().toString());
	 												Intent intent=new Intent(Yresetuser.this,Yresetuser_1.class);
	 												intent.putExtra("data", b);
	 												Yresetuser.this.startActivity(intent);
	 					            		 
	 					            	 
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
	               
	            	
	           }
			}
//				Bundle b=new Bundle();
//				b.putString("yonghuming", yonghuming.getText().toString());
//				b.putString("mima", xingming.getText().toString());
//				
//				Intent intent=new Intent(Yresetuser.this,Yresetuser_1.class);
//				intent.putExtra("data", b);
//				Yresetuser.this.startActivity(intent);
				//所选用户的信息按照adduser_1的形势展示。
				
			
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Yresetuser.this,Ymanageruser.class);
//				Yresetuser.this.startActivity(intent);
				Yresetuser.this.finish();
			}
		});
		
	}
	
	
}
