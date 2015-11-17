package com.example.text;

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

	private Button ybt23;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunteacher_view);
		ybt23=(Button) findViewById(R.id.ybutton23);
		ybt23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user u=new user();
				String quanxian=u.getQuanxian();
				if(quanxian.equals("系负责人")){
					Intent intent=new Intent(Yunteacher.this,Mmanager.class);
					Yunteacher.this.startActivity(intent);
				}
				if(quanxian.equals("教学办")){
					Intent intent=new Intent(Yunteacher.this,Ymanagerclass.class);
					Yunteacher.this.startActivity(intent);
				}
				
			}
		});
	}

	
}
