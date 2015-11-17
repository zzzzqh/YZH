package com.example.text;

import java.util.ArrayList;
import java.util.List;

import com.example.sql.douser;
import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Yresetuser_1 extends Activity{
	
	private Button queren,quxiao;
	private ListView yresetuser_xinxi;
	
	String zhanghao;
	String name;
	String password;
	String power;
	String phone;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_1);
		
		yresetuser_xinxi =(ListView) findViewById(R.id.yresetuser_xinxi);
		queren=(Button) findViewById(R.id.yresetuser_1_button1);
		quxiao=(Button) findViewById(R.id.yresetuser_1_button2);
		tv1=(TextView) findViewById(R.id.yresetuser_xingming_1);
		tv2=(TextView) findViewById(R.id.yresetuser_mima_1);
		tv3=(TextView) findViewById(R.id.yresetuser_quanxain_1);
		tv4=(TextView) findViewById(R.id.yresetuser_phone_number_1);
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();

		System.out.println("222");
		zhanghao=b.getString("yonghuming");
		list.add("用户名:"+zhanghao);
		name=tv1.getText().toString();
		System.out.println(name);
		password=tv2.getText().toString();
		power=tv3.getText().toString();
		phone=tv4.getText().toString();
		System.out.println(power);
		System.out.println("333");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		yresetuser_xinxi.setAdapter(adapter);
		
		
		
		System.out.println("111");
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				douser d=new douser();
				String xingming=d.getXingming();
				String suoshuyuan=d.getSuoshuyuan();
				String quanxian=d.getQuanxian();
				String shouji=d.getShouji();
				String nianlin=d.getNianlin();
				String xingbie=d.getXingbie();
				System.out.println("888");
				String youxiang=d.getYouxiang();
				System.out.println("777");
				String suoshuxi=d.getSuoshuxi();
				System.out.println("666");
				String mima=d.getMima();
				int Age;
				System.out.println("999");
				if(nianlin==null)
				{
					Age=0;
				}
				else{
					Age=Integer.valueOf(nianlin);
				}
				System.out.println("000");
				if(phone.isEmpty())
				{
					phone=shouji;
				}
				if(password.isEmpty())
				{
					password=mima;
				}
				if(power.isEmpty())
				{
					power=quanxian;
				}
				if(name.isEmpty())
				{
					name=mima;
				}
				SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
				System.out.println("aaa");
				db.delete("usertb", "zhanghao=?", new String[]{zhanghao});
				System.out.println("bbb");
				db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values("+"'"+zhanghao+"'"+","+"'"+password+"'"+","+"'"+name+"'"+","+"'"+suoshuyuan+"'"+","+"'"+suoshuxi+"'"+","+"'"+ xingbie+"'"+","+"'"+Age+"'"+","+"'"+youxiang+"'"+","+"'"+phone+"'"+","+"'"+power+"'"+")");
				System.out.println("ccc");
				Toast.makeText(Yresetuser_1.this, "修改成功", 1).show();
				Intent intent=new Intent(Yresetuser_1.this,Ymanageruser.class);
				Yresetuser_1.this.startActivity(intent);
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(Yresetuser_1.this,Yresetuser.class);
					Yresetuser_1.this.startActivity(intent);
				}
			});
		
		
	}	
}
		

