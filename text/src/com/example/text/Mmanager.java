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

public class Mmanager extends Activity {

	private Button bt1;
	private Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mmanager_view);
		bt1=(Button) findViewById(R.id.mmabutton1);
		bt2=(Button) findViewById(R.id.mmabutton2);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mmanager.this,Yunteacher.class);
				Mmanager.this.startActivity(intent); 
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Mmanager.this, "提交申请成功", 1).show();
				Intent intent =new Intent(Mmanager.this,Mmain.class);
			}
		});
		}
			
		
	

	
}
