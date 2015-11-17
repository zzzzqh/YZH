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
public class Yupdateplan extends Activity {

	private Button ybt6;
	private Button ybt7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yupdateplan_view);
		ybt6=(Button) findViewById(R.id.ybutton6);
		ybt7=(Button) findViewById(R.id.ybutton7);
		ybt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yupdateplan.this, "开课计划书导入成功", 1).show();
				Intent intent=new Intent(Yupdateplan.this,Ymain.class);
				Yupdateplan.this.startActivity(intent);
			}
		});
		ybt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yupdateplan.this,Ymain.class);
				Yupdateplan.this.startActivity(intent);
			}
		});
		
	}

	
}
