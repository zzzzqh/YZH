package com.example.xuanke;

import com.example.sql.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Yunteacher extends Activity {

	private Button fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunteacher_view);
		fanhui=(Button) findViewById(R.id.ybutton23);
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
