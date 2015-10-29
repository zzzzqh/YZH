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

public class Yidentity extends Activity {

	private Button ybt8;
	private Button ybt9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yidentity_view);
		ybt8=(Button) findViewById(R.id.ybutton8);
		ybt9=(Button) findViewById(R.id.ybutton9);
		ybt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yidentity.this,Yreset.class);
				Yidentity.this.startActivity(intent);
			}
		});
		ybt9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yidentity.this,Ymain.class);
				Yidentity.this.startActivity(intent);
			}
		});
	}
	
	
}
