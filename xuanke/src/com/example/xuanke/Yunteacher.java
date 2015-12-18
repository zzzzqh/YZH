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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Yunteacher extends Activity {

	private ImageButton fanhui;
	private Spinner yunteacher_xinxi;
	private ArrayAdapter<String> adapter5;
	final List<String> list5=new ArrayList<String>();
	String name;
	private ImageButton shuaxin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunteacher_view);
		fanhui=(ImageButton) findViewById(R.id.y_unchooset_back);
		yunteacher_xinxi=(Spinner) findViewById(R.id.yunteacher_xinxi);
		shuaxin=(ImageButton) findViewById(R.id.y_unteacher_remind);
		shuaxin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AsyncTask<String, Void, Void>(){
					 //
					 					@Override
					 					protected Void doInBackground(String... params) {
					 					String url="http://115.28.69.231/android/checkundoteacher.php";
					 						HttpPost httprequest=new HttpPost(url);
					 						List<NameValuePair>param=new ArrayList<NameValuePair>();
					 						//param.add(new BasicNameValuePair("xueqi",xq));
					 						//param.add(new BasicNameValuePair("xuenian", xn));
					 						//param.add(new BasicNameValuePair("zhuangye", "��ѧ��Ӧ����ѧ"));
					 						try {
					 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
					 							httprequest.setEntity(httpEntity);
					 							HttpClient httpClient=new DefaultHttpClient();
					 							HttpResponse httpResponse=httpClient.execute(httprequest);
					 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					 								String result=EntityUtils.toString(httpResponse.getEntity());
					 								if(result.equals("error")){
					 									 Toast.makeText(Yunteacher.this, "�û���������,���������", 1).show();
//					 			                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
//					 			     					 MainActivity.this.startActivity(intent);
					 								}
					 								else
					 								{
					 								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
					 								for(int i=0;i<jsonArray.length();i++){
					 									user u=new user();
					 									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
					 									name=jsoObject.getString("name");									
					 									list5.add(name);//�ѷ��������ص�������ӵ�listview									
					 								}
					 	 
					 								}
					 							}
					 							
					 						else
					 						{
					 							Toast.makeText(Yunteacher.this, "����������", Toast.LENGTH_SHORT).show();
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
       yunteacher_xinxi.setAdapter(adapter5);

//		 new AsyncTask<String, Void, Void>(){
//
//				@Override
//				protected Void doInBackground(String... params) {
//				String url="http://115.28.69.231/android/checkundoteacher.php";
//					HttpPost httprequest=new HttpPost(url);
//					
//					
//					try {
//						
//						
//						HttpClient httpClient=new DefaultHttpClient();
//						HttpResponse httpResponse=httpClient.execute(httprequest);
//						if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
//							String result=EntityUtils.toString(httpResponse.getEntity());
//							if(result.equals("error")){
//								 Toast.makeText(Yunteacher.this, "�û���������,���������", 1).show();
////		                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
////		     					 MainActivity.this.startActivity(intent);
//							}
//							else
//							{
//							JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
//							for(int i=0;i<jsonArray.length();i++){
//								user u=new user();
//								JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
//								name=jsoObject.getString("name");									
//								list5.add(name);//�ѷ��������ص�������ӵ�listview									
//							}
//
//							}
//						}
//						
//					else
//					{
//						Toast.makeText(Yunteacher.this, "����������", Toast.LENGTH_SHORT).show();
//					}
//					
//				} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (ClientProtocolException e) {
//					// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//					e.printStackTrace();
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return null;
//					
//				}
//				
//			}.execute("http://115.28.69.231/index.php");
//			adapter5=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list5);
//		    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
//		    yunteacher_xinxi.setAdapter(adapter5);
		
//		yunteacher_xinxi.setOnItemClickListener(new OnItemClickListener(){
//
// 
//
//            @Override
//
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//
//                    long arg3) {
//
//                // TODO Auto-generated method stub
//
//                if(list.get(arg2).equals("����"))
//
//                {
//                	System.out.println("aa");
//                	Toast.makeText(Yunteacher.this, "����", 1).show();
//                	Bundle b=new Bundle();
//					b.putString("yonghuming", "����");
//                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
//                	intent.putExtra("data", b);
//                	Yunteacher.this.startActivity(intent);
//
//                }
//
//                if(list.get(arg2).equals("����"))
//
//                {
//
//                	Toast.makeText(Yunteacher.this, "����", 1).show();
//                	Bundle b=new Bundle();
//					b.putString("yonghuming", "����");
//                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
//                	intent.putExtra("data", b);
//                	Yunteacher.this.startActivity(intent);
//
//                }
//
//                if(list.get(arg2).equals("����"))
//
//                {
//
//                	Toast.makeText(Yunteacher.this, "����", 1).show();
//                	Bundle b=new Bundle();
//					b.putString("yonghuming","����");
//                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
//                	intent.putExtra("data", b);
//                	Yunteacher.this.startActivity(intent);
//                }
//
//                if(list.get(arg2).equals("����"))
//
//                {
//
//                	Toast.makeText(Yunteacher.this, "����", 1).show();
//                	Bundle b=new Bundle();
//					b.putString("yonghuming", "����");
//                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
//                	intent.putExtra("data", b);
//                	Yunteacher.this.startActivity(intent);
//
//                }
//
//                if(list.get(arg2).equals("�¶�"))
//
//                {
//
//                	Toast.makeText(Yunteacher.this, "�¶�", 1).show();
//                	Bundle b=new Bundle();
//					b.putString("yonghuming", "�¶�");
//                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
//                	intent.putExtra("data", b);
//                	Yunteacher.this.startActivity(intent);
//
//                }
//
//            }
            

//        });
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Yunteacher.this.finish();
//				user u=new user();
//				String quanxian=u.getQuanxian();
//				if(quanxian.equals("ϵ������")){
//					Intent intent=new Intent(Yunteacher.this,Mmanager.class);
//					Yunteacher.this.startActivity(intent);
//				}
//				if(quanxian.equals("��ѧ��")){
//					Intent intent=new Intent(Yunteacher.this,Ymanagerclass.class);
//					Yunteacher.this.startActivity(intent);
//				}
				
			}
		});
	}

	
}
