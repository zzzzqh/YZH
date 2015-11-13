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
        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,zhanghao text not null,mima text not null,xingming text not null,suoshuyuan text not null,suoshuxi text null,xingbie text null,nianlin integer null,youxiang text null,shouji text null,quanxian text not null,zhuangtai text not null)");
        db.execSQL("create table if not exists clatb(_id integer primary key autoincrement,xuenian text not null,xueqi text not null, nianji integer not null,zhuanye text not null,zhuanyerenshu integer not null,kechengmingcheng text not null,xuanxiuleixing text not null,xuefen intger null,xueshi integer  null,shiyanxueshi integer  null,shangjixueshi integer  null)");
        db.execSQL("create table if not exists choosetb(_id integer primary key autoincrement,nianji integer not null,zhuanye text not null,kechengmingcheng text not null,xuanxiuleixing text not null,qiqizhouxu text null,renkejiaoshi text null,jiaocaimingcheng text null,ISBN text null,xuanyong text null,beizhu text null,zhuangtaix text not null,zhuangtaiy not null)");
        
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302307','123456','�����','��ѧ��������ѧѧԺ','','',24,'','','��ʦ','δѡ��')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302117','123456','���ݺ�','��ѧ��������ѧѧԺ','','��',24,'510122600@qq.com','15659434690','��ʦ','δѡ��')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('xifuzeren1','123456','��־�','��ѧ��������ѧѧԺ','�����ϵ','��',24,'','','ϵ������','δѡ��')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('yuanfuzeren1','123456','��־��','��ѧ��������ѧѧԺ','','��',24,'','','��ѧ��','δѡ��')");
        
        db.execSQL("insert into usertb(xuenian,xueqi,nianji,zhuanye,zhuanyerenshu,kechengmingcheng,xuanxiuleixing,xuefen,xueshi,shiyanxueshi,shangjixueshi)values('2015ѧ��','��һѧ��','2012','�������ѧ�뼼����ʵ��ࣩ',62,'��ҵ��ƣ����ģ�','��ҵ���',15,'','','')");
        
        
       // db.execSQL("insert into usertb(z,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('2015ѧ��','��һѧ��','2012','�������ѧ�뼼����ʵ��ࣩ',62,'��ҵ��ƣ����ģ�','��ҵ���',15,'','','')");
        
        
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
	            String zh=null;
	            if(n1.equals("")|| n1.equals("")){
					Toast.makeText(MainActivity.this, "����д������Ϣ", 1).show();
					Intent intent=new Intent(MainActivity.this,MainActivity.class);
					MainActivity.this.startActivity(intent);
				}
	            else
	            {
	            	 
	            
	            	Cursor c=db.rawQuery("select * from usertb where zhanghao=?", new String[]{n1});
	            	Log.i("==", "11");;//������
	            	
	            	
	            	
	            	
	            	if(c!=null){
	                	 while (c.moveToNext()) {
	                		  pw = c.getString(c.getColumnIndex("mima")).trim();
	        				  qx = c.getString(c.getColumnIndex("quanxian")).trim();
	        				  zh=c.getString(c.getColumnIndex("zhanghao")).trim();
	                	 }
	                	 
	                	 if(zh == null || pw == null){
	                		 Toast.makeText(MainActivity.this, "�û���������,���������", 1).show();
	                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
	     					 MainActivity.this.startActivity(intent);
	                	 }
	                	 else{
	                	 
		                	 if(!pw.equals(p1)){
		                	 Toast.makeText(MainActivity.this, "�ʺ��������", 1).show();
		                	 
		                	 }
		                	 else{
		                	
		                	 
		                		 if("��ʦ".equals(qx)){
		                		 
		                		 Intent intent=new Intent(MainActivity.this,Tmain.class);
		                		 MainActivity.this.startActivity(intent);
		                		 }
		                		 else if("ϵ������".equals(qx)){
		                		 
		                			 Intent intent=new Intent(MainActivity.this,Mmain.class);
		                			 MainActivity.this.startActivity(intent);
		                		 }
		                		 else if("��ѧ��".equals(qx)){
		                			 Intent intent=new Intent(MainActivity.this,Ymain.class);
		                			 MainActivity.this.startActivity(intent);
		                		 }
		                	 }
	                	 }
	                	 c.close();
	                 }
	            }
				/*
				 * ��Ҫһ������ж���ת��Tmain/Mmain/Ymain
				 * ��ǰĬ����ת��Tmain
				 */
				 //Intent intent=new Intent(MainActivity.this,Tmain.class);
				//Intent intent=new Intent(MainActivity.this,Ymain.class);
	             //MainActivity.this.startActivity(intent);
				
			}
		});
        
    }

    
}


