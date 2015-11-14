package com.example.text;

import java.util.ArrayList;
import java.util.List;

import com.example.text.R.id;

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
import android.widget.RadioButton;

public class Midentity extends Activity {
	
	
	
	
	private EditText name,user_name,password,age;
	private EditText email,phone;
	private RadioButton boy;
    private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
	
	
	

	private Button mbt1;
	private Button mbt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_midentity);
		mbt1=(Button) findViewById(R.id.mmabutton1);
		mbt2=(Button) findViewById(R.id.mmabutton2);
		
		name=(EditText) findViewById(R.id.midentity_name);
		user_name=(EditText) findViewById(R.id.midentity_user_name);
		password=(EditText) findViewById(R.id.miendtity_password);
		age=(EditText) findViewById(R.id.total_age);
		boy=(RadioButton) findViewById(R.id.midentity_boy);
		phone=(EditText) findViewById(R.id.mphone_number);
		
		
		 adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);

         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 

	       
		
		
		mbt1.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				
				Bundle b=new Bundle();
				b.putString("name","姓名："+name.getText().toString());
				b.putString("user_name","姓名："+user_name.getText().toString());
				b.putString("password","密码:"+password.getText().toString());
				b.putString("age","年龄："+age.getText().toString());
				if(boy.isChecked()){
					b.putString("sex", "性别：男");
				}else{
					b.putString("sex", "性别：女");
				}
				b.putString("email","邮箱："+email.getText().toString());
				b.putString("phone","手机号码："+phone.getText().toString());
				
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mreset.class);
				intent.putExtra("data", b);
				Midentity.this.startActivity(intent);
			}
		});
		mbt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mmain.class);
				Midentity.this.startActivity(intent);
			}
		});
	}

	
}
