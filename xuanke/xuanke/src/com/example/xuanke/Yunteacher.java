package com.example.xuanke;

import java.util.ArrayList;
import java.util.List;

import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.Toast;

public class Yunteacher extends Activity {

	private ImageButton fanhui;
	private ListView yunteacher_xinxi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunteacher_view);
		fanhui=(ImageButton) findViewById(R.id.y_unchooset_back);
		yunteacher_xinxi=(ListView) findViewById(R.id.yunteacher_xinxi);
		final List<String> list=new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五：");
		list.add("赵六");
		list.add("陈二");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		yunteacher_xinxi.setAdapter(adapter);
		yunteacher_xinxi.setOnItemClickListener(new OnItemClickListener(){

 

            @Override

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,

                    long arg3) {

                // TODO Auto-generated method stub

                if(list.get(arg2).equals("张三"))

                {
                	System.out.println("aa");
                	Toast.makeText(Yunteacher.this, "张三", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "张三");
					System.out.println("bb");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("李四"))

                {

                	Toast.makeText(Yunteacher.this, "李四", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "李四");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("王五"))

                {

                	Toast.makeText(Yunteacher.this, "王五", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming","王五");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);
                }

                if(list.get(arg2).equals("赵六"))

                {

                	Toast.makeText(Yunteacher.this, "赵六", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "赵六");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("陈二"))

                {

                	Toast.makeText(Yunteacher.this, "陈二", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "陈二");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

            }

             

        });
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Yunteacher.this.finish();
//				user u=new user();
//				String quanxian=u.getQuanxian();
//				if(quanxian.equals("系负责人")){
//					Intent intent=new Intent(Yunteacher.this,Mmanager.class);
//					Yunteacher.this.startActivity(intent);
//				}
//				if(quanxian.equals("教学办")){
//					Intent intent=new Intent(Yunteacher.this,Ymanagerclass.class);
//					Yunteacher.this.startActivity(intent);
//				}
				
			}
		});
	}

	
}
