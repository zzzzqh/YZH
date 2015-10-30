package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Midentity extends Activity {

	private Button mbt1;
	private Button mbt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_midentity);
		mbt1=(Button) findViewById(R.id.mmabutton1);
		mbt2=(Button) findViewById(R.id.mmabutton2);
		mbt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mreset.class);
				Midentity.this.startActivity(intent);
			}
		});
		mbt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mmain.class);
				Midentity.this.startActivity(intent);
			}
		});
	}

	
}
