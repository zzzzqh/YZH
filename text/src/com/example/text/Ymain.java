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

	private Button ybt1;
	private Button ybt2;
	private Button ybt3;
	private Button ybt4;
	private Button ybt5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ymain_view);
		ybt1=(Button) findViewById(R.id.ybutton1);
		ybt2=(Button) findViewById(R.id.ybutton2);
		ybt3=(Button) findViewById(R.id.ybutton3);
		ybt4=(Button) findViewById(R.id.ybutton4);
		ybt5=(Button) findViewById(R.id.ybutton5);
		/*其中ybt3，ybt4，ybt5要设置一个抽屉布局*/
		ybt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Yupdateplan.class);
				Ymain.this.startActivity(intent);
			}
		});
		ybt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Ymanagerclass.class);
				Ymain.this.startActivity(intent);
			}
		});
		ybt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Yidentity.class);
				Ymain.this.startActivity(intent);
			}
		});
		ybt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,Ymanageruser.class);
				Ymain.this.startActivity(intent);
			}
		});
		ybt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymain.this,MainActivity.class);
				Ymain.this.startActivity(intent);
			}
		});
	}

	
}
