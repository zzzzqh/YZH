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
		list.add("����");
		list.add("����");
		list.add("���壺");
		list.add("����");
		list.add("�¶�");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		yunteacher_xinxi.setAdapter(adapter);
		yunteacher_xinxi.setOnItemClickListener(new OnItemClickListener(){

 

            @Override

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,

                    long arg3) {

                // TODO Auto-generated method stub

                if(list.get(arg2).equals("����"))

                {
                	System.out.println("aa");
                	Toast.makeText(Yunteacher.this, "����", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "����");
					System.out.println("bb");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("����"))

                {

                	Toast.makeText(Yunteacher.this, "����", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "����");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("����"))

                {

                	Toast.makeText(Yunteacher.this, "����", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming","����");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);
                }

                if(list.get(arg2).equals("����"))

                {

                	Toast.makeText(Yunteacher.this, "����", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "����");
                	Intent intent=new Intent(Yunteacher.this,Teacherxinxi.class);
                	intent.putExtra("data", b);
                	Yunteacher.this.startActivity(intent);

                }

                if(list.get(arg2).equals("�¶�"))

                {

                	Toast.makeText(Yunteacher.this, "�¶�", 1).show();
                	Bundle b=new Bundle();
					b.putString("yonghuming", "�¶�");
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
