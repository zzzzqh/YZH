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

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Kechengliebiao extends Activity {

	private ListView ykkjhs;
	private String zhuanye;
	private String xuenian;
	private String xueqi;
	private String kechengming;
	private ImageButton shuaxin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kechengliebiao_view);
		shuaxin=(ImageButton) findViewById(R.id.id_y_shuaxin_img);
//		Intent intent= this.getIntent();
		ykkjhs=(ListView) findViewById(R.id.listView1);
		final List<String> list=new ArrayList<String>();
//		Bundle b = intent.getBundleExtra("data");
//		zhuanye=b.getString("zy");
//		xuenian=b.getString("xn");
//		xueqi=b.getString("xq");
		zhuanye="计算机实验班";
		shuaxin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AsyncTask<String, Void, Void>(){
					
					@Override
					protected Void doInBackground(String... params) {
					String url="http://115.28.69.231/android/takeclassname.php";
						HttpPost httprequest=new HttpPost(url);
						List<NameValuePair>param=new ArrayList<NameValuePair>();
						//param.add(new BasicNameValuePair("xueqi",xq));
						//param.add(new BasicNameValuePair("xuenian", xn));
						param.add(new BasicNameValuePair("zhuangye", zhuanye));
						try {
							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
							httprequest.setEntity(httpEntity);
							HttpClient httpClient=new DefaultHttpClient();
							HttpResponse httpResponse=httpClient.execute(httprequest);
							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
								String result=EntityUtils.toString(httpResponse.getEntity());
								if(result.equals("error")){
//									 Toast.makeText(Ymain.this, "用户名不存在,或密码错误", 1).show();
//			                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
//			     					 MainActivity.this.startActivity(intent);
								}
								else
								{
								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
								for(int i=0;i<jsonArray.length();i++){
//									user u=new user();
									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
									kechengming=jsoObject.getString("kechen");									
									list.add(kechengming);									
								}
	 
								}
							}
							
						else
						{
							Toast.makeText(Kechengliebiao.this, "连接有问题", Toast.LENGTH_SHORT).show();
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
		
		
							ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
							ykkjhs.setAdapter(adapter);
	}

	
}
