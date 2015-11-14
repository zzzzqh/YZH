package com.example.text;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.example.sql.user;
import com.example.text.Tidentity;

import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class Tidentity extends Activity {

	private Button bt7;
	private Button bt8;
	private TextView tv1;
	private TextView tv2;
	private EditText tiendtity_password,tidentity_age,t_email,tphone_number;
	private RadioButton tidentity_boy;
	private Spinner t_professical_aspect1;
	private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
		

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tidentity_view);
		bt7=(Button) findViewById(R.id.button7);
		bt8=(Button) findViewById(R.id.button8);
		tv1=(TextView) findViewById(R.id.tidentity_zhanghao);
		tv2=(TextView) findViewById(R.id.tidentity_mima);
		tiendtity_password=(EditText) findViewById(R.id.tiendtity_password);
		tidentity_age=(EditText) findViewById(R.id.tidentity_age);
		t_email=(EditText) findViewById(R.id.t_email);
		tphone_number=(EditText) findViewById(R.id.tphone_number);
		tidentity_boy=(RadioButton) findViewById(R.id.tidentity_boy);
		t_professical_aspect1=(Spinner) findViewById(R.id.t_professical_aspect1);
		
		user u=new user();
		String xingming=u.getXingming();
		String mima=u.getMima();
		tv1.setText("姓名:"+ xingming);
		tv2.setText("原始密码:"+ mima);
		
	    list.add("计算机(实验班)");
        list.add("计算机(卓越班)");
        list.add("计算机专业");
        list.add("软件工程专业");
        list.add("数学类(实验班)");
        list.add("数学类");
        list.add("网络工程专业");
        list.add("信息安全专业");
     
        /*为列表定义一个适配器，这里用前面的List*/		
        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        /*为适配器设置下拉列表样式*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        //未spinner加載適配器
        t_professical_aspect1.setAdapter(adapter);
	
		
        bt7.setOnClickListener(new OnClickListener() {
        	
        	@Override
			public void onClick(View v) {
        	Bundle c=new Bundle();
            	c.putString("tiendtity_password",tiendtity_password.getText().toString());	
            	c.putString("tidentity_age",tidentity_age.getText().toString());
            	c.putString("t_email",t_email.getText().toString());
            	c.putString("tphone_number",tphone_number.getText().toString());
            	c.putString("t_professical_aspect1", "专业方向:"+t_professical_aspect1.getSelectedItem().toString());
            	if(tidentity_boy.isChecked()){
    				c.putString("sex", "男");
    			}else{
    				c.putString("sex", "女");
    			}
            	
            	
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tidentity.this,Treset.class);
				intent.putExtra("data", c);
	             Tidentity.this.startActivity(intent);	
			}
		});
        bt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Tidentity.this,Tmain.class);
	             Tidentity.this.startActivity(intent);	
			}
		});
			
	}
	
}
