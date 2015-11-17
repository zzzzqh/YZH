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

public class Youtput extends Activity {

	private Button ybt26;
	private Button ybt27;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.youtput_view);
		ybt26=(Button) findViewById(R.id.ybutton26);
		ybt27=(Button) findViewById(R.id.ybutton27);
		ybt26.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Youtput.this, "导出EXCEL成功", 1).show();
				Intent intent=new Intent(Youtput.this,Youtput.class);
				Youtput.this.startActivity(intent);
			}
		});
		
		ybt27.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Youtput.this,Ycheck.class);
				Youtput.this.startActivity(intent);
			}
		});
		
	}

	
}
