package com.example.text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.R.id;
import com.example.text.Taddclass;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Taddclass extends Activity {
    private Button bt4;
    private Button bt5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taddclass_view);
		bt4=(Button) findViewById(R.id.addclass_button4);
		bt5=(Button) findViewById(R.id.addclass_button5);
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Taddclass.this, "Ìí¼Ó³É¹¦", 1).show();
				Intent intent=new Intent(Taddclass.this,Tmyclass.class);
				Taddclass.this.startActivity(intent);
			}
		});
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Taddclass.this,Tmyclass.class);
				Taddclass.this.startActivity(intent);
			}
		});
	}

	
}
