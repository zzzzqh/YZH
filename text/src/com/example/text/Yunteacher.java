package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Yunteacher extends Activity {

	private Button ybt23;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunteacher_view);
		ybt23=(Button) findViewById(R.id.ybutton23);
		ybt23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*由于这个页面由系负责人教学办公用，选择合适的跳转条件,两个不能共存*/
				Intent intent=new Intent(Yunteacher.this,Ymanagerclass.class);
				//Intent intent=new Intent(Yunteacher.this,Ymanagerclass.class);
				Yunteacher.this.startActivity(intent);
			}
		});
	}

	
}
