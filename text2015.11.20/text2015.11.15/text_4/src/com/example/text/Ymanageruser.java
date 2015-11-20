package com.example.text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Ymanageruser extends Activity {

	private Button tianjiayonghu;
	private Button xiugaiyonghu;
	private Button shanchuyonghu;
	private Button fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ymanageruser_view);
		tianjiayonghu=(Button) findViewById(R.id.ybutton12);
		xiugaiyonghu=(Button) findViewById(R.id.ybutton13);
		shanchuyonghu=(Button) findViewById(R.id.ybutton14);
		fanhui=(Button) findViewById(R.id.ymanageruser_back);
		tianjiayonghu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Yadduser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		xiugaiyonghu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Yresetuser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		shanchuyonghu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Ydeluser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Ymanageruser.this,Ymain.class);
//				Ymanageruser.this.startActivity(intent);
				Ymanageruser.this.finish();
				
			}
		});
	}

	
}
