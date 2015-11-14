package com.example.text;

import java.util.ArrayList;
import java.util.List;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Taddclass_1 extends Activity {
	private ListView xinxi;
	private Button quxiao,queding;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taddclass_1);
		
		xinxi =(ListView) findViewById(R.id.xinxi);
		queding=(Button) findViewById(R.id.addclass_1_button1);
		quxiao=(Button) findViewById(R.id.addclass_1_button2);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();
		list.add(b.getString("addclass_professical_aspect1"));
		list.add(b.getString("addclass_course_name"));
		list.add(b.getString("addclass_first_week"));
		list.add(b.getString("addclass_last_week"));
		list.add(b.getString("addclass_isbn_number"));
		list.add(b.getString("addclass_book_name"));
		list.add(b.getString("leixing"));
		list.add(b.getString("addclass_ps"));
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		xinxi.setAdapter(adapter);
		
		
		
		
		
		queding.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Taddclass_1.this, "Ìí¼Ó³É¹¦", 1).show();
				Intent intent=new Intent(Taddclass_1.this,Tmyclass.class);
				Taddclass_1.this.startActivity(intent);
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(Taddclass_1.this,Taddclass.class);
					Taddclass_1.this.startActivity(intent);
				}
			});
		
		
	}		
		
}
