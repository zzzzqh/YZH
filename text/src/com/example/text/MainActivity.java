package com.example.text;

import com.example.text.MainActivity;
import com.example.text.Tmyclass;
import com.example.text.R.id;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302307','123456','周子淇','数学与计算机科学学院','','',24,'','','教师')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302117','123456','苏逸豪','数学与计算机科学学院','','男',24,'510122600@qq.com','15659434690','教师')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('xifuzeren1','123456','陈志灏','数学与计算机科学学院','计算机系','男',24,'','','系负责人')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('yuanfuzeren1','123456','尤志明','数学与计算机科学学院','','男',24,'','','教学办')");
        
        bt0=(Button) findViewById(R.id.main_button0);
        username=(EditText) findViewById(R.id.main_user_name);
        password=(EditText) findViewById(R.id.main_input_password);
        bt0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n1=username.getText().toString().trim();
	            String p1=password.getText().toString().trim();
	            String pw = null;
	            String qx=null;
	            if(n1.equals("")|| n1.equals("")){
					Toast.makeText(MainActivity.this, "请填写完整信息", 1).show();
					Intent intent=new Intent(MainActivity.this,MainActivity.class);
					MainActivity.this.startActivity(intent);
				}
	            else
	            {
	            	 Cursor c=db.rawQuery("select * from usertb where zhanghao=?", new String[]{n1});
	            	 if(c!=null){
	                	 while (c.moveToNext()) {
	                		  pw = c.getString(c.getColumnIndex("mima")).trim();
	        				 java.lang.System.out.println(pw+"abc");
	        				 java.lang.System.out.println(pw.equals(p1));
	        				  qx = c.getString(c.getColumnIndex("quanxian")).trim();
	        			}
	                	 
	                 if(!pw.equals(p1)){
	                	 Toast.makeText(MainActivity.this, "帐号密码错误", 1).show();
	                	 java.lang.System.out.println(11111);
	                 }
	                 else
	                 {
	                	 
	                	 if("教师".equals(qx)){
	                		 java.lang.System.out.println("22222");
	                		 Intent intent=new Intent(MainActivity.this,Tmain.class);
	                		 MainActivity.this.startActivity(intent);
	                	 }
	                	 else if("系负责人".equals(qx))
	                	 {
	                		 java.lang.System.out.println("33333333");
	                		 Intent intent=new Intent(MainActivity.this,Mmain.class);
	                		 MainActivity.this.startActivity(intent);
	                	 }
	                	 else if("教学办".equals(qx))
	                	 {
	                		 Intent intent=new Intent(MainActivity.this,Ymain.class);
	                		 MainActivity.this.startActivity(intent);
	                	 }
	                 }
	                	 c.close();
	                 }
	            }
				/*
				 * 需要一个身份判断跳转到Tmain/Mmain/Ymain
				 * 当前默认跳转到Tmain
				 */
				 //Intent intent=new Intent(MainActivity.this,Tmain.class);
				//Intent intent=new Intent(MainActivity.this,Ymain.class);
	             //MainActivity.this.startActivity(intent);
				
			}
		});
        
    }

    
}


