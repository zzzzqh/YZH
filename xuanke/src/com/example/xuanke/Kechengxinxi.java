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
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Kechengxinxi extends Activity {

	private String zhuanye;
	private String kechengmingcheng;
    private Spinner kechengming;
	private ImageButton shuaxin;
	private ArrayAdapter<String> adapter5;
	String xueqi,xuenian,nianji,zhuangye,renshu,kechen,xuanxiu,xuefen,xueshi,shiyanxueshi,shangjixueshi;
	final List<String> list5=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kechengxinxi_view);
		kechengming=(Spinner) findViewById(R.id.listView1);
		shuaxin=(ImageButton) findViewById(R.id.id_y_shuaxin_img);
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		zhuanye=b.getString("zhuanye");
		kechengmingcheng=b.getString("kechengmingcheng");
		Toast.makeText(Kechengxinxi.this, zhuanye+" "+kechengmingcheng, Toast.LENGTH_SHORT).show();
		shuaxin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AsyncTask<String, Void, Void>(){
					 //
					 					@Override
					 					protected Void doInBackground(String... params) {
					 					String url="http://115.28.69.231/android/returnclassinformation.php";
					 						HttpPost httprequest=new HttpPost(url);
					 						List<NameValuePair>param=new ArrayList<NameValuePair>();
					 						//param.add(new BasicNameValuePair("xueqi",xq));
					 						param.add(new BasicNameValuePair("kechen", kechengmingcheng.substring(1)));
					 						param.add(new BasicNameValuePair("zhuangye", zhuanye));
					 						try {
					 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
					 							httprequest.setEntity(httpEntity);
					 							HttpClient httpClient=new DefaultHttpClient();
					 							HttpResponse httpResponse=httpClient.execute(httprequest);
					 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					 								String result=EntityUtils.toString(httpResponse.getEntity());
					 								if(result.equals("error")){
					 									 Toast.makeText(Kechengxinxi.this, "用户名不存在,或密码错误", 1).show();
//					 			                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
//					 			     					 MainActivity.this.startActivity(intent);
					 								}
					 								else
					 								{
					 								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
					 								for(int i=0;i<jsonArray.length();i++){
					 									user u=new user();
					 									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
					 									list5.add("学期"+jsoObject.getString("xueqi"));
					 									list5.add("学年"+jsoObject.getString("xuenian"));
					 									list5.add("年级"+jsoObject.getString("nianji"));
					 									list5.add("专业"+jsoObject.getString("zhuangye"));
					 									list5.add("人数"+jsoObject.getString("renshu"));
					 									list5.add("课程"+jsoObject.getString("kechen"));
					 									list5.add("选修类型"+jsoObject.getString("xuanxiu"));
					 									list5.add("学分"+jsoObject.getString("xuefen"));
					 									list5.add("学时"+jsoObject.getString("xueshi"));
					 									list5.add("实验学时"+jsoObject.getString("shiyanxueshi"));
					 									list5.add("上机学时"+jsoObject.getString("shangjixueshi"));								
					 								}
					 	 
					 								}
					 							}
					 							
					 						else
					 						{
					 							Toast.makeText(Kechengxinxi.this, "连接有问题", Toast.LENGTH_SHORT).show();
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
		adapter5=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list5);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
       kechengming.setAdapter(adapter5);


	}

	
}
