package com.example.text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.Tidentity;
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

public class Tidentity extends Activity {

	private Button bt7;
	private Button bt8;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tidentity_view);
		bt7=(Button) findViewById(R.id.button7);
		bt8=(Button) findViewById(R.id.button8);
        bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tidentity.this,Treset.class);
	             Tidentity.this.startActivity(intent);	
			}
		});
        bt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tidentity.this,Tmain.class);
	             Tidentity.this.startActivity(intent);	
			}
		});
			
	}
	
}
