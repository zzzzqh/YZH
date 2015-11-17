package com.example.text;

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
import android.widget.Spinner;
import android.widget.Toast;

public class Yadduser extends Activity {

	private Button ybt15;
	private Button ybt16;
	
	
	private EditText yadduser_zhigonghao,yadduser_name,yadduser_password,yadduser_phone;
	private Spinner yadduser_power;
	private ArrayAdapter<String> adapter;
    private List<String> list=new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yadduser_view);
		ybt15=(Button) findViewById(R.id.ybutton15);
		ybt16=(Button) findViewById(R.id.ybutton16);
		
		yadduser_zhigonghao=(EditText) findViewById(R.id.yadduser_zhigonghao);
		yadduser_name=(EditText) findViewById(R.id.yadduser_name);
		yadduser_password=(EditText) findViewById(R.id.yadduser_password);
		yadduser_phone=(EditText) findViewById(R.id.yadduser_phone);
		yadduser_power=(Spinner) findViewById(R.id.yadduser_power);
		 list.add("教师");
	     list.add("系负责人");
	     list.add("教学办");
	     
	     
	     adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	     yadduser_power.setAdapter(adapter);
		
		
		ybt15.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Bundle b=new Bundle();
				b.putString("yadduser_zhigonghao", yadduser_zhigonghao.getText().toString());
				b.putString("yadduser_name", yadduser_name.getText().toString());
				b.putString("yadduser_password", yadduser_password.getText().toString());
				b.putString("yadduser_phone", yadduser_phone.getText().toString());
				b.putString("yadduser_power", yadduser_power.getSelectedItem().toString());
				
				
				
				
				// TODO Auto-generated method stub

				Intent intent=new Intent(Yadduser.this,Yadduser_1.class);
				intent.putExtra("data", b);
				Yadduser.this.startActivity(intent);
			}
		});
		ybt16.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Yadduser.this,Ymanageruser.class);
				Yadduser.this.startActivity(intent);
			}
		});
	}
	
}
