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

public class Yreset extends Activity {

	private Button ybt10;
	private Button ybt11;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yreset_view);
		ybt10=(Button) findViewById(R.id.ybutton10);
		ybt11=(Button) findViewById(R.id.ybutton11);
		ybt10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yreset.this, "个人信息修改成功", 1).show();
				Intent intent=new Intent(Yreset.this,Yidentity.class);
				Yreset.this.startActivity(intent);
			}
		});
		ybt11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yreset.this,Yidentity.class);
				Yreset.this.startActivity(intent);
			}
		});
	}

	
}
