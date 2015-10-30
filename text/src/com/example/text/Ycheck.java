package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ycheck extends Activity {

	private Button ybt24;
	private Button ybt25;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ycheck_view);
		
		ybt24=(Button) findViewById(R.id.ybutton24);
		ybt25=(Button) findViewById(R.id.ybutton25);
		ybt24.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ycheck.this,Youtput.class);
				Ycheck.this.startActivity(intent);
			}
		});
		ybt25.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Ycheck.this,Ymanagerclass.class);
				Ycheck.this.startActivity(intent);
			}
		});
		
	}

	
}
