package com.example.xuanke;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Yadduser extends Activity {

	private ImageButton quanrentianjia;
	private ImageButton fanhui;
	String quanxian;
	
	private EditText yadduser_zhigonghao,yadduser_name,yadduser_password,yadduser_phone;
	private Spinner yadduser_power;
	private ArrayAdapter<String> adapter;
    private List<String> list=new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yadduser_view);
		quanrentianjia=(ImageButton) findViewById(R.id.y_yhgl_add);
		fanhui=(ImageButton) findViewById(R.id.y_yhgl_add_back);
		
		yadduser_zhigonghao=(EditText) findViewById(R.id.y_yhgl_adduser_yhm);
		yadduser_name=(EditText) findViewById(R.id.y_yhgl_adduser_name);
		yadduser_password=(EditText) findViewById(R.id.yadduser_password);
		yadduser_phone=(EditText) findViewById(R.id.yadduser_phone);
		yadduser_power=(Spinner) findViewById(R.id.yadduser_power);
		 list.add("��ʦ");
	     list.add("ϵ������");
	     list.add("��ѧ��");
	     
	     
	     adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	     yadduser_power.setAdapter(adapter);
		
		
	     quanrentianjia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Bundle b=new Bundle();
				b.putString("yadduser_zhigonghao", yadduser_zhigonghao.getText().toString());
				b.putString("yadduser_name", yadduser_name.getText().toString());
				b.putString("yadduser_password", yadduser_password.getText().toString());
				b.putString("yadduser_phone", yadduser_phone.getText().toString());
				if(yadduser_power.getSelectedItem().toString().equals("��ʦ")){
					quanxian="t";
				}
				else if(yadduser_power.getSelectedItem().toString().equals("ϵ������")){
					quanxian="x";
				}
					
				else{
					quanxian="y";
				}
				b.putString("yadduser_power",quanxian);
				
				
				
				
				// TODO Auto-generated method stub

				Intent intent=new Intent(Yadduser.this,Yadduser_1.class);
				intent.putExtra("data", b);
				Yadduser.this.startActivity(intent);
			}
		});
	     fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				Intent intent=new Intent(Yadduser.this,Ymanageruser.class);
//				Yadduser.this.startActivity(intent);
				Yadduser.this.finish();
			}
		});
	}
	
}
