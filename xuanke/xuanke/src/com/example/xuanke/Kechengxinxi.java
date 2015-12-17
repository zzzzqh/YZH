package com.example.xuanke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Kechengxinxi extends Activity {

	private String zhuanye;
	private String kechengmingcheng;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kechengxinxi_view);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		zhuanye=b.getString("zhuanye");
		kechengmingcheng=b.getString("kechengmingcheng");
		Toast.makeText(Kechengxinxi.this, zhuanye+" "+kechengmingcheng, Toast.LENGTH_SHORT).show();
	}

	
}
