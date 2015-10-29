package com.example.text;

import com.example.text.MainActivity;
import com.example.text.Tmyclass;
import com.example.text.R.id;

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


public class MainActivity extends Activity {

	private Button bt0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bt0=(Button) findViewById(R.id.button0);
        /*bt2=(Button) findViewById(R.id.button2);*/
        bt0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * 需要一个身份判断跳转到Tmain/Mmain/Ymain
				 * 当前默认跳转到Tmain
				 */
				 //Intent intent=new Intent(MainActivity.this,Tmain.class);
				 Intent intent=new Intent(MainActivity.this,Ymain.class);
	             MainActivity.this.startActivity(intent);
				
			}
		});
        /*bt2.setOnClickListener(new Myclick(){
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				super.onClick(v);
				Toast.makeText(MainActivity.this, "只有负责人才有这个权限！", 1).show();
				
			}
        });*/
        
    }

    
}


/*class Myclick implements OnClickListener{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i("tag","父类的监听事件");
		
	}
	
	

}
*/