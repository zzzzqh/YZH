package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ymanagerclass extends Activity {

	private Button weixuankejiaoshi;
	private Button fanhui;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ymanageclass);
		weixuankejiaoshi=(Button) findViewById(R.id.ybutton21);
		fanhui=(Button) findViewById(R.id.ybutton22);
		weixuankejiaoshi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ymanagerclass.this,Yunteacher.class);
				Ymanagerclass.this.startActivity(intent);
			}
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Ymanagerclass.this,Ymain.class);
//				Ymanagerclass.this.startActivity(intent);
				Ymanagerclass.this.finish();
			}
		});
	}

	
}
