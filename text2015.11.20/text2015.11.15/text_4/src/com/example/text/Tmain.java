package com.example.text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.Tmain;
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

public class Tmain extends Activity {

	private Button xuanke;
	private Button gerenxinxi;
	/*
	 * BT6，BT1的功能最终在抽屉布局中显示
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tmain_view);
		xuanke=(Button) findViewById(R.id.button1);
		xuanke.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tmain.this,Tmyclass.class);
                Tmain.this.startActivity(intent);
			}
		});
		gerenxinxi=(Button) findViewById(R.id.button6);
		gerenxinxi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tmain.this,Tidentity.class);
                Tmain.this.startActivity(intent);
			}
		});
	}

	
}
