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
import android.widget.Toast;

public class Ydeluser_1 extends Activity{
	
	
	private ImageButton del;
	private ImageButton back;
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
		del=(ImageButton) findViewById(R.id.y_yhgl_del_1);
		back=(ImageButton) findViewById(R.id.y_yhgl_del_back_1);
		ydeluser_xinxi=(ListView) findViewById(R.id.ydeluser_xinxi);
		
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();
		
		
		zhanghao=b.getString("yonghuming");
		name=b.getString("xingming");
		password=b.getString("chushimima");
		power=b.getString("yonghuquanxian");
		if(power.equals("y")){
			power="��ѧ��";
		}
		else if(power.equals("t")){
			power="��ʦ";
		}
		else if(power.equals("x")){
			power="ϵ������";
		}
		phone=b.getString("phone");
		/*
		password
		power
		phone����������Ӧ����ͨ���������ݿ�����������Ϣƥ����û���Ȼ����ʾ����
		*/
		list.add("�û���:"+zhanghao);
		list.add("����:"+name);
		list.add("��ʼ���룺"+password);
		list.add("�û�Ȩ��:"+power);
		list.add("��ϵ�绰:"+phone);
		
		
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
				
				Toast.makeText(Ydeluser_1.this, "ɾ���û��ɹ�", 1).show();
				Ydeluser_1.this.finish();
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
