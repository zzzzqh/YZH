package com.example.text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.Treset;
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

public class Treset extends Activity {

	private Button bt9;
	private Button bt10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treset_view);
		bt9=(Button) findViewById(R.id.button9);
		bt10=(Button) findViewById(R.id.button10);
		bt9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Treset.this, "个人信息修改成功", 1).show();
				Intent intent=new Intent(Treset.this,Tidentity.class);
	            Treset.this.startActivity(intent);
			}
		});
         bt10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Treset.this,Tidentity.class);
	            Treset.this.startActivity(intent);
			}
		});
	}

	
}
