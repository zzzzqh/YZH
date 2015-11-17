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

	private Button ybt12;
	private Button ybt13;
	private Button ybt14;
	private Button ybt15;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ymanageuser_view);
		ybt12=(Button) findViewById(R.id.ybutton12);
		ybt13=(Button) findViewById(R.id.ybutton13);
		ybt14=(Button) findViewById(R.id.ybutton14);
		ybt15=(Button) findViewById(R.id.ymanageruser_back);
		ybt12.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Yadduser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		ybt13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Yresetuser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		ybt14.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Ydeluser.class);
				Ymanageruser.this.startActivity(intent);
			}
		});
		ybt15.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanageruser.this,Ymain.class);
				Ymanageruser.this.startActivity(intent);
				
			}
		});
	}

	
}
