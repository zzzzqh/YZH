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

	private Button mbt1;
	private Button mbt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mmain_view);
		mbt1=(Button) findViewById(R.id.mmbutton1);
		mbt2=(Button) findViewById(R.id.mmbutton2);
		mbt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmain.this,Mmanager.class);
                Mmain.this.startActivity(intent);
			}
		});
		mbt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmain.this,Midentity.class);
                Mmain.this.startActivity(intent);
			}
		});
	}

	
}
