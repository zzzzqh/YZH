package com.example.text;

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
import android.widget.TextView;
import android.widget.Toast;

public class Ydeluser extends Activity {

	private Button del;
	private Button back;
	private TextView yonghuming,xingming;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ydeluser_view);
		del=(Button) findViewById(R.id.ybutton19);
		back=(Button) findViewById(R.id.ybutton20);
		
		
		yonghuming=(TextView) findViewById(R.id.ydeluser_user_name);
		xingming=(TextView) findViewById(R.id.ydeluser_input_password);
		
		
		
		del.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n1=yonghuming.getText().toString().trim();
	            String p1=xingming.getText().toString().trim();
	            String pw=null;
	            String qx=null;
	            String zh=null;
	            String xm=null;
	            String sj=null;
	            if(n1.equals("")|| p1.equals("")){
					Toast.makeText(Ydeluser.this, "请填写完整信息", 1).show();
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
	       				  sj=c.getString(c.getColumnIndex("shouji")).trim();
	                	 }
	            	}
	            	 if(zh==null||xm==null){
	            		 Toast.makeText(Ydeluser.this, "用户名不存在", 1).show();
	            	 }
	            	 else
	            	 {
	            		 if(!xm.equals(p1)){
		                	 Toast.makeText(Ydeluser.this, "帐号姓名不匹配", 1).show();		                	 
		                }
	            		 else{
								Bundle b=new Bundle();
								b.putString("yonghuming", yonghuming.getText().toString());
								b.putString("xingming", xingming.getText().toString());
								b.putString("mima", pw);
								b.putString("quanxian", qx);
								b.putString("shouji", sj);
								Intent intent=new Intent(Ydeluser.this,Ydeluser_1.class);
								intent.putExtra("data", b);
								Ydeluser.this.startActivity(intent);
	            		 }
	            	 }
	           }
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Ydeluser.this,Ymanageruser.class);
				Ydeluser.this.startActivity(intent);
			}
		});
	}

	
}
