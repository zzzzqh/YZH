package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Mmain extends Activity {

	private Button kechengguanli;
	private Button gerenxinxi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mmain_view);
		gerenxinxi=(Button) findViewById(R.id.mmbutton1);
		kechengguanli=(Button) findViewById(R.id.mmbutton2);
		kechengguanli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmain.this,Mmanager.class);
                Mmain.this.startActivity(intent);
			}
		});
		gerenxinxi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmain.this,Midentity.class);
                Mmain.this.startActivity(intent);
			}
		});
	}

	
}
