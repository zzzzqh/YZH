package com.example.text;

import com.example.sql.douser;
import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Yresetuser extends Activity {

	private Button ybt17;
	private Button ybt18;
	
	
	private EditText yonghuming,xingming;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_view);
		ybt17=(Button) findViewById(R.id.ybutton17);
		ybt18=(Button) findViewById(R.id.ybutton18);
		
		yonghuming=(EditText) findViewById(R.id.yresetuser_user_name);
		xingming=(EditText) findViewById(R.id.yresetuser_input_password);
		
		ybt17.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n1=yonghuming.getText().toString().trim();
	            String p1=xingming.getText().toString().trim();
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
					Toast.makeText(Yresetuser.this, "请填写完整信息", 1).show();
				}
	            else
	            {
	            	
	                SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
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
	                	 douser d=new douser();//获取用户的信息存放到
	                	 d.setMima(pw);
	                	 d.setXingming(xm);
	                	 d.setZhanghao(n1);
	                	 d.setNianlin(String.valueOf(nl));
	                	 d.setQuanxian(qx);
	                	 d.setShouji(sj);
	                	 d.setSuoshuxi(sx);
	                	 d.setSuoshuyuan(sy);
	                	 d.setYouxiang(yx);
	                	 
	            	}
	            	 if(zh==null||xm==null){
	            		 Toast.makeText(Yresetuser.this, "用户名不存在", 1).show();
	            	 }else
	            	 {
	            		 if(!xm.equals(p1)){
		                	 Toast.makeText(Yresetuser.this, "帐号姓名不匹配", 1).show();		                	 
		                }
	            		 else{
								Bundle b=new Bundle();
								b.putString("yonghuming", yonghuming.getText().toString());
								Intent intent=new Intent(Yresetuser.this,Yresetuser_1.class);
								intent.putExtra("data", b);
								Yresetuser.this.startActivity(intent);
	            		 }
	            	 }
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
		ybt18.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yresetuser.this,Ymanageruser.class);
				Yresetuser.this.startActivity(intent);
			}
		});
		
	}
	
	
}
