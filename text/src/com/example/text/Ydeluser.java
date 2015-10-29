package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Ydeluser extends Activity {

	private Button ybt19;
	private Button ybt20;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ydeluser_view);
		ybt19=(Button) findViewById(R.id.ybutton19);
		ybt20=(Button) findViewById(R.id.ybutton20);
		ybt19.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Ydeluser.this, "删除用户成功", 1).show();
				Intent intent=new Intent(Ydeluser.this,Ymanageruser.class);
				Ydeluser.this.startActivity(intent);
			}
		});
		ybt20.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Ydeluser.this,Ymanageruser.class);
				Ydeluser.this.startActivity(intent);
			}
		});
	}

	
}
