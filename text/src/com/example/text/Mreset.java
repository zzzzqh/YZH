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

public class Mreset extends Activity {

	private Button bt1;
	private Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mreset_view);
		
		bt1=(Button) findViewById(R.id.mrbutton1);
		bt2=(Button) findViewById(R.id.mrbutton2);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Mreset.this, "个人信息修改成功", 1).show();
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
		});
         bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
         });
	}
	
	
}
