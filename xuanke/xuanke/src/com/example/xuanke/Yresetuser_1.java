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

//import com.example.sql.douser;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Yresetuser_1 extends Activity{
	
	private ImageButton queren,quxiao;
	private ListView yresetuser_xinxi;
	
	String zhanghao;
	String name;
	String password;
	String power;
	String phone;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_1);
		
		yresetuser_xinxi =(ListView) findViewById(R.id.yresetuser_xinxi);
		queren=(ImageButton) findViewById(R.id.y_yhgl_change_1);
		quxiao=(ImageButton) findViewById(R.id.y_yhgl_back_1);
		tv1=(TextView) findViewById(R.id.yresetuser_xingming_1);
		tv2=(TextView) findViewById(R.id.yresetuser_mima_1);
		tv3=(TextView) findViewById(R.id.yresetuser_quanxain_1);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();

		
		zhanghao=b.getString("yonghuming");
		list.add("用户名:"+zhanghao);
		name=tv1.getText().toString();
		
		password=tv2.getText().toString();
		if(tv3.getText().toString().equals("教师")){
			power="t";
		}
		else if(tv3.getText().toString().equals("教师")){
			power="x";
		}
			
		else if(tv3.getText().toString().equals("教学办")){
			power="y";
		}
	
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		yresetuser_xinxi.setAdapter(adapter);
		
		
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AsyncTask<String, Void, Void>(){

 					@Override
 					protected Void doInBackground(String... params) {
 					String url="http://115.28.69.231/android/freshuser.php";
 						HttpPost httprequest=new HttpPost(url);
 						List<NameValuePair>param=new ArrayList<NameValuePair>();
 						param.add(new BasicNameValuePair("zhanggao",zhanghao));
 						param.add(new BasicNameValuePair("name",name));
 						param.add(new BasicNameValuePair("mima",password));
 						param.add(new BasicNameValuePair("type",power));
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
		
				
				Toast.makeText(Yresetuser_1.this, "修改成功", 1).show();
				Yresetuser_1.this.finish();
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					Intent intent=new Intent(Yresetuser_1.this,Yresetuser.class);
//					Yresetuser_1.this.startActivity(intent);
					Yresetuser_1.this.finish();
				}
			});
		
		
	}	
}
		

