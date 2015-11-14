package com.example.text;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Taddclass extends Activity {
    private Button bt4;
    private Button bt5;
    
    private EditText addclass_course_name,addclass_first_week,addclass_last_week,addclass_isbn_number;
    private EditText addclass_book_name,addclass_ps;
    private RadioButton addclass_xuanyong,addclass_zibian;
    
    private Spinner addclass_professical_aspect1;
    private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taddclass_view);
		bt4=(Button) findViewById(R.id.addclass_button4);
		bt5=(Button) findViewById(R.id.addclass_button5);
		
		
		addclass_course_name=(EditText) findViewById(R.id.addclass_course_name);
		addclass_first_week=(EditText) findViewById(R.id.addclass_first_week);
		addclass_last_week=(EditText) findViewById(R.id.addclass_last_week);
		addclass_isbn_number=(EditText) findViewById(R.id.addclass_isbn_number);
		addclass_book_name=(EditText) findViewById(R.id.addclass_book_name);
		addclass_ps=(EditText) findViewById(R.id.addclass_ps);
		addclass_xuanyong=(RadioButton) findViewById(R.id.addclass_xuanyong);
		addclass_zibian=(RadioButton) findViewById(R.id.addclass_zibian);

		addclass_professical_aspect1=(Spinner) findViewById(R.id.addclass_professical_aspect1);
		
		
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
	        addclass_professical_aspect1.setAdapter(adapter);
		
		
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

		    Bundle b= new Bundle();
		    b.putString("addclass_course_name", "课程名称:"+addclass_course_name.getText().toString());
		    b.putString("addclass_first_week", "开始周:"+addclass_first_week.getText().toString());
		    b.putString("addclass_last_week","结束周："+addclass_last_week.getText().toString());
		    b.putString("addclass_isbn_number", "ISBN号码:"+addclass_isbn_number.getText().toString());
		    b.putString("addclass_book_name", "教材名称:"+addclass_book_name.getText().toString());
		    
		    if(addclass_xuanyong.isChecked()){
				b.putString("leixing", "教材类型：选用");
			}else{
				b.putString("leixing", "教材类型：自编");
			}
		    b.putString("addclass_professical_aspect1", "专业方向:"+addclass_professical_aspect1.getSelectedItem().toString());
		    b.putString("addclass_ps", "备注:"+addclass_ps.getText().toString());
		   
		     Intent intent = new Intent(Taddclass.this,Taddclass_1.class);
			 intent.putExtra("data", b);
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
