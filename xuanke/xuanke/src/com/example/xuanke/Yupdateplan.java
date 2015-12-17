package com.example.xuanke;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class Yupdateplan extends Activity {

	private EditText xuenian;
	private EditText xueqi;
	private EditText xuankejiezhi;
	private EditText shenhejiezhi;
	private ImageButton queren;
	private ImageButton fanhui;
	private String xn;//获取学期日期
	private String xq;//获取学年日期
	private String xkjz;//获取选课截止日期
	private String shjz;//获取审核截止日期
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yupdateplan_view1);
		xuenian=(EditText) findViewById(R.id.xuenian);
		xueqi=(EditText) findViewById(R.id.xueqi);
		xuankejiezhi=(EditText) findViewById(R.id.xuanke_end_data);
		shenhejiezhi=(EditText) findViewById(R.id.shenhe_end_data);
		queren=(ImageButton) findViewById(R.id.y_update_qd);
		fanhui=(ImageButton) findViewById(R.id.y_update_back);
		xn=xuenian.getText().toString();
		xq=xueqi.getText().toString();
		xkjz=xuankejiezhi.getText().toString();
		shjz=shenhejiezhi.getText().toString();
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Yupdateplan.this.finish();
			}
		});
	}

	
}
