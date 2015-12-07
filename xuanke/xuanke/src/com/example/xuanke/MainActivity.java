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
//import com.example.text.MainActivity;
//import com.example.text.Mmain;
//import com.example.text.R;
//import com.example.text.Tmain;
//import com.example.text.Ymain;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Button bt0;
	EditText username;
	EditText password;
	String user;
	String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,zhanghao text not null,mima text not null,xingming text not null,suoshuyuan text not null,suoshuxi text null,xingbie text null,nianlin integer null,youxiang text null,shouji text null,quanxian text not null)");
        //db.execSQL("create table clatb(_id integer primary key autoincrement,xuenian text not null,xueqi text not null, nianji integer not null,zhuanye text not null,zhuanyerenshu integer not null,kechengmingcheng text not null,xuanxiuleixing text not null,xuefen intger null,xueshi integer  null,shiyanxueshi integer  null,shangjixueshi integer  null)");
        //db.execSQL("create table choosetb(_id integer primary key autoincrement,nianji integer not null,zhuanye text not null,kechengmingcheng text not null,xuanxiuleixing text not null,qiqizhouxu text null,renkejiaoshi text null,jiaocaimingcheng text null,ISBN text null,xuanyong text null,beizhu text null)");

        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302307','123456','周子淇','数学与计算机科学学院','xx','xx',24,'xx','xx','教师')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302117','123456','苏逸豪','数学与计算机科学学院','xx','男',24,'510122600@qq.com','15659434690','教师')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('xifuzeren1','123456','陈志灏','数学与计算机科学学院','计算机系','男',24,'xx','xx','系负责人')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('yuanfuzeren1','123456','尤志明','数学与计算机科学学院','xx','男',24,'xx','xx','教学办')");
        
        bt0=(Button) findViewById(R.id.main_button0);
        username=(EditText) findViewById(R.id.main_user_name);
        password=(EditText) findViewById(R.id.main_input_password);
        bt0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n1=username.getText().toString().trim();
	            String p1=password.getText().toString().trim();
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
	            if(n1.equals("")|| p1.equals("")){
					Toast.makeText(MainActivity.this, "请填写完整信息", 1).show();
					Intent intent=new Intent(MainActivity.this,MainActivity.class);
					MainActivity.this.startActivity(intent);
				}
	            else
	            {
	            	Cursor c=db.rawQuery("select * from usertb where zhanghao=?", new String[]{n1});     	
	            	if(c!=null){
	                	 while (c.moveToNext()) {
	                		 
	                		  xm = c.getString(c.getColumnIndex("xingming")).trim();
	                		  pw = c.getString(c.getColumnIndex("mima")).trim();
	        				  qx = c.getString(c.getColumnIndex("quanxian")).trim();
	        				  zh=c.getString(c.getColumnIndex("zhanghao")).trim();
	        				 
	        				  nl=c.getInt(c.getColumnIndex("nianlin"));
	        				  
	        				  sy=c.getString(c.getColumnIndex("suoshuyuan")).trim();
	        				  
	        				  sx=c.getString(c.getColumnIndex("suoshuxi")).trim();
	        				 
	        				  sb=c.getString(c.getColumnIndex("xingbie")).trim();
	        				  
	        				  yx=c.getString(c.getColumnIndex("youxiang")).trim();
	        				  
	        				  sj=c.getString(c.getColumnIndex("shouji")).trim();
	        				  
	                	 }
	                	 user u=new user();
	                	 u.setMima(pw);
	                	 u.setXingming(xm);
	                	 u.setZhanghao(n1);
	                	 u.setNianlin(String.valueOf(nl));
	                	 u.setQuanxian(qx);
	                	 u.setShouji(sj);
	                	 u.setSuoshuxi(sx);
	                	 u.setSuoshuyuan(sy);
	                	 u.setYouxiang(yx);
	                	 u.setZhanghao(zh);
	                	 if(zh == null || pw == null){
	                		 Toast.makeText(MainActivity.this, "用户名不存在,或密码错误", 1).show();
	                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
	     					 MainActivity.this.startActivity(intent);
	                	 }
	                	 else{
	                		 
//		                	 if(!pw.equals(p1)){
//		                	 Toast.makeText(MainActivity.this, "帐号密码错误", 1).show();		                	 
//		                	 }
//		                	 else{
//		                		 if("教师".equals(qx)){
//		                		 Intent intent=new Intent(MainActivity.this,Tmain.class);
//		                		 MainActivity.this.startActivity(intent);
//		                		 }
//		                		 else if("系负责人".equals(qx)){
//		                		 
//		                			 Intent intent=new Intent(MainActivity.this,Mmain.class);
//		                			 MainActivity.this.startActivity(intent);
//		                		 }
		                		 //else 
		                			 if("教学办".equals(qx)){
		                			 Intent intent=new Intent(MainActivity.this,Ymain.class);
		                			 MainActivity.this.startActivity(intent);
		                		 }
		                	 }
	                	 }
	                	 c.close();
	                 }
	            }
				
				
			
		});
        
    }

    
}

