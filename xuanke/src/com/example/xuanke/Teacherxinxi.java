package com.example.xuanke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Teacherxinxi extends Activity {

	private String yonghuming;
	private TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacherxinxi_view);
		System.out.println("cc");
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		System.out.println("dd");
		yonghuming=b.getString("yonghuming");
		//System.out.println(yonghuming);
		//tv1=(TextView) findViewById(R.id.test);
		//tv1.setText(yonghuming);
	}

	
}
