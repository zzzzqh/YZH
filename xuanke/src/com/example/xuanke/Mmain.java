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
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Mmain extends Activity implements OnClickListener{

	private ViewPager Yviewpager;
	private PagerAdapter yadapter;
	private List<View> yViews = new ArrayList<View>();
	private LinearLayout yTabkaikexinxi;
	private LinearLayout yTabxuankeguanli;
	private LinearLayout yTabgerenshezhi;
	private ImageButton tijiaoshenhe;
	private ImageButton ykaikexinxiImg;
	private ImageButton yxuankeguanliImg;
	private ImageButton ygerenshezhiImg;
	private Spinner xuenian;
	private Spinner xueqi;
	private List<String> list=new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	private List<String> list1=new ArrayList<String>();
	private ArrayAdapter<String> adapter1;
	private Spinner zhuanye;
	private List<String> list2=new ArrayList<String>();
	private ArrayAdapter<String> adapter2;
	private Button go;
	private String xq;
	private String xn;
	private String zy;
	//定义tab上的imagebutton事件监听器
	private String kechengming;
	private String zyrecall;
	private Spinner ykkjhs;
	private ArrayAdapter<String> adapter5;
	final List<String> list5=new ArrayList<String>();
	
	private ImageButton weixuakejiaoshi;//未选课教师按钮
	private ImageButton xiugaixinxi;//修改个人信息
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mmain_view);

		initView();
		initEvents();
	}
	private void initEvents() {
		// TODO Auto-generated method stub
		 yTabkaikexinxi.setOnClickListener(this);
		 yTabxuankeguanli.setOnClickListener(this);
		 yTabgerenshezhi.setOnClickListener(this);
		
		 //声明imagebutton的监听事件
		 go.setOnClickListener(this);
		 weixuakejiaoshi.setOnClickListener(this);
		 xiugaixinxi.setOnClickListener(this);
		 tijiaoshenhe.setOnClickListener(this);
		
	}
	@SuppressWarnings("deprecation")
	private void initView() {
		// TODO Auto-generated method stub
		Yviewpager=(ViewPager) findViewById(R.id.id_viewpager);
		
		
		yTabkaikexinxi=(LinearLayout) findViewById(R.id.id_y_tab_kaikejihuashu);
		yTabxuankeguanli=(LinearLayout) findViewById(R.id.id_y_tab_xuankeguanli);
		yTabgerenshezhi=(LinearLayout) findViewById(R.id.id_y_tab_gerenshezhi);
		
		ykaikexinxiImg=(ImageButton) findViewById(R.id.id_y_tab_kaikejihuashu_img);
		yxuankeguanliImg=(ImageButton) findViewById(R.id.id_y_tab_xuankeguanli_img);
		ygerenshezhiImg=(ImageButton) findViewById(R.id.id_y_tab_gerenshezhi_img);
	    
	    
	    LayoutInflater yInflater = LayoutInflater.from(this);
		View tab01 = yInflater.inflate(R.layout.mtab01, null);
		View tab02 = yInflater.inflate(R.layout.mtab02, null);
		View tab03 = yInflater.inflate(R.layout.mtab03, null);
		
		
		/**
		 * 要获取到tab01里面的imagebutton,可以通过yInflater反射
		 * 获取到的tab01再用findviewbyid方法获取到
		 * 然后再给imagebutton注册监听事件就可以了。
		 * 
		 */
		ykkjhs=(Spinner) tab01.findViewById(R.id.y_kkjhs);
		weixuakejiaoshi=(ImageButton) tab02.findViewById(R.id.id_y_tab_weixuankejiaoshi_img);
		tijiaoshenhe=(ImageButton) tab02.findViewById(R.id.id_y_tab_tijiaoshenhe_img);
		xiugaixinxi=(ImageButton) tab03.findViewById(R.id.id_y_change_img);
		go=(Button)tab01.findViewById(R.id.y_chaxun);
		xuenian=(Spinner) tab01.findViewById(R.id.y_xuenian);
		list.add("2014"); 
		list.add("2015");
		list.add("2016"); 
		list.add("2017"); 
		list.add("2018"); 
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    xuenian.setAdapter(adapter);
		xueqi=(Spinner) tab01.findViewById(R.id.y_xueqi);
		list1.add("第一学期");
		list1.add("第二学期");
		list1.add("第三学期");
		adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    xueqi.setAdapter(adapter1);
		yViews.add(tab01);
		yViews.add(tab02);
		yViews.add(tab03);
		zhuanye=(Spinner) tab01.findViewById(R.id.y_zhuanye);
		list2.add("信息与计算科学");
		list2.add("数学类");
		list2.add("计算机科学与技术（实验班）");
		list2.add("计算机科学与技术（卓越班）");
		list2.add("计算机科学与技术");
		list2.add("计算机类");
		list2.add("软件工程");
		list2.add("数学与应用数学");
		list2.add("信息与计算科学（实验班）");
		list2.add("数学类（实验班）");
		list2.add("网络工程");
		list2.add("信息安全");
		adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    zhuanye.setAdapter(adapter2);
		yadapter = new PagerAdapter()
		{

			@Override
			public void destroyItem(ViewGroup container, int position,Object object)//删除该view
			{
				container.removeView(yViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position)//添加view
			{
				View view = yViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public int getCount()//获取当前view的下标
			{
				return yViews.size();
			}
			
		};
		
		Yviewpager.setAdapter(yadapter);

	}
	
	@Override
	public void onClick(View v)//定义每一个imagebutton的监听事件
	{
		
		switch (v.getId())
		{
		case R.id.id_y_tab_kaikejihuashu://进入响应界面，相应图标变亮
			Yviewpager.setCurrentItem(0);
			
			break;
		case R.id.id_y_tab_xuankeguanli:
			Yviewpager.setCurrentItem(1);
			
			break;
		case R.id.id_y_tab_gerenshezhi:
			Yviewpager.setCurrentItem(2);
			
			break;
		
		
		case R.id.id_y_tab_weixuankejiaoshi_img://点击开课计划书按钮跳转到Yunteacher查询未选课教师
			 Intent intent=new Intent(Mmain.this,Yunteacher.class);
			Mmain.this.startActivity(intent);
	
			break;
		case R.id.y_chaxun://点击开课计划书按钮跳转到修改个人信息界面
			xq=xueqi.getSelectedItem().toString();
			xn=xuenian.getSelectedItem().toString();
			zy=zhuanye.getSelectedItem().toString();
			
			new AsyncTask<String, Void, Void>(){
				 //
				 					@Override
				 					protected Void doInBackground(String... params) {
				 					String url="http://115.28.69.231/android/takeclassname.php";
				 						HttpPost httprequest=new HttpPost(url);
				 						List<NameValuePair>param=new ArrayList<NameValuePair>();
				 						//param.add(new BasicNameValuePair("xueqi",xq));
				 						//param.add(new BasicNameValuePair("xuenian", xn));
				 						param.add(new BasicNameValuePair("zhuangye", zy));
				 						try {
				 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
				 							httprequest.setEntity(httpEntity);
				 							HttpClient httpClient=new DefaultHttpClient();
				 							HttpResponse httpResponse=httpClient.execute(httprequest);
				 							if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				 								String result=EntityUtils.toString(httpResponse.getEntity());
				 								if(result.equals("error")){
				 									 Toast.makeText(Mmain.this, "用户名不存在,或密码错误", 1).show();
//				 			                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
//				 			     					 MainActivity.this.startActivity(intent);
				 								}
				 								else
				 								{
				 								JSONArray jsonArray=new JSONObject(result).getJSONArray("value");
				 								for(int i=0;i<jsonArray.length();i++){
				 									user u=new user();
				 									JSONObject jsoObject=(JSONObject) jsonArray.opt(i);
				 									zyrecall=jsoObject.getString("kechen");									
				 									list5.add(zyrecall);//把服务器返回的数据添加到listview									
				 								}
				 	 
				 								}
				 							}
				 							
				 						else
				 						{
				 							Toast.makeText(Mmain.this, "连接有问题", Toast.LENGTH_SHORT).show();
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
				 				adapter5=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list5);
				 		        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
				 			    ykkjhs.setAdapter(adapter5);
				 				ykkjhs.setOnItemSelectedListener(new OnItemSelectedListener() {
				 
				 					@Override
				 					public void onItemSelected(AdapterView<?> arg0, View arg1,
				 							int arg2, long arg3) {
				 						// TODO Auto-generated method stub
				 						Toast.makeText(Mmain.this, list5.get(arg2), Toast.LENGTH_SHORT).show();
				 						kechengming=list5.get(arg2);
				 		            	Toast.makeText(Mmain.this, kechengming, Toast.LENGTH_SHORT).show();
				 		            	Bundle b=new Bundle();
				 		            	
				 						b.putString("zhuanye", zy);
				 						b.putString("kechengmingcheng", kechengming);
				 	                	Intent intent=new Intent(Mmain.this,Kechengxinxi.class);
				 	                	intent.putExtra("data", b);
				 	                	Mmain.this.startActivity(intent);
				 					}
				 
				 					@Override
				 					public void onNothingSelected(AdapterView<?> arg0) {
				 						// TODO Auto-generated method stub
				 						
				 					}
				 				});

			break;
		
		case R.id.id_y_change_img://点击开课计划书按钮跳转到修改个人信息界面
			 intent=new Intent(Mmain.this,Midentity.class);
			Mmain.this.startActivity(intent);
	
			break;
		case R.id.id_y_tab_tijiaoshenhe_img://点击开课计划书按钮跳转到修改个人信息界面
			 Toast.makeText(Mmain.this, "审核提交成功", 1).show();
			 
			 
	
			break;
		default:
			break;
		}

}
	

	
}
