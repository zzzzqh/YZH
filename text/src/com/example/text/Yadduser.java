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

public class Yadduser extends Activity {

	private Button ybt15;
	private Button ybt16;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yadduser_view);
		ybt15=(Button) findViewById(R.id.ybutton15);
		ybt16=(Button) findViewById(R.id.ybutton16);
		ybt15.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yadduser.this, "用户添加成功", 1).show();
				Intent intent=new Intent(Yadduser.this,Ymanageruser.class);
				Yadduser.this.startActivity(intent);
			}
		});
		ybt16.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Yadduser.this,Ymanageruser.class);
				Yadduser.this.startActivity(intent);
			}
		});
	}
	
}
