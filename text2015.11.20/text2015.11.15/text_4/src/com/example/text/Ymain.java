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

public class Ymain extends Activity {

	private Button gengxinjiahuashu;
	private Button xuankeguanli;
	private Button gerenxinxi;
	private Button yonghuguanli;
	private Button zhuxiao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ymain_view);
		gengxinjiahuashu=(Button) findViewById(R.id.ybutton1);
		xuankeguanli=(Button) findViewById(R.id.ybutton2);
		gerenxinxi=(Button) findViewById(R.id.ybutton3);
		yonghuguanli=(Button) findViewById(R.id.ybutton4);
		zhuxiao=(Button) findViewById(R.id.ybutton5);
		/*其中ybt3，ybt4，ybt5要设置一个抽屉布局*/
		gengxinjiahuashu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Yupdateplan.class);
				Ymain.this.startActivity(intent);
			}
		});
		xuankeguanli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Ymanagerclass.class);
				Ymain.this.startActivity(intent);
			}
		});
		gerenxinxi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Yidentity.class);
				Ymain.this.startActivity(intent);
			}
		});
		yonghuguanli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Ymanageruser.class);
				Ymain.this.startActivity(intent);
			}
		});
		zhuxiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Ymain.this,MainActivity.class);
//				Ymain.this.startActivity(intent);
				Ymain.this.finish();
			}
		});
	}

	
}
