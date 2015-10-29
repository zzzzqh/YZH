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

public class Yresetuser extends Activity {

	private Button ybt17;
	private Button ybt18;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_view);
		ybt17=(Button) findViewById(R.id.ybutton17);
		ybt18=(Button) findViewById(R.id.ybutton18);
		ybt17.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yresetuser.this, "用户信息修改成功", 1).show();
				Intent intent=new Intent(Yresetuser.this,Ymanageruser.class);
				Yresetuser.this.startActivity(intent);
			}
		});
		ybt18.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yresetuser.this,Ymanageruser.class);
				Yresetuser.this.startActivity(intent);
			}
		});
		
	}
	
	
}
