package com.example.xuanke;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

//import jxl.Sheet;
//import jxl.Workbook; 

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sql.user;
import com.example.xuanke.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Yupdateplan extends Activity {

	private Button quedingdaoru;
	private Button fanhui;
	int rows,cols;
	//Sheet sheet=null;
	String zhuangye;
	String nianji ;
	String renshu ;
	String classname ;
	String classtype ;
	String xuefen ;
	String xueshi ;
	String shiyanxueshi ;
	String shangjixueshi ;
	String xuankedeadline;
	String shenhedeadline;
	EditText ed1;
	EditText ed2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yupdateplan_view);
		quedingdaoru=(Button) findViewById(R.id.ybutton6);
		fanhui=(Button) findViewById(R.id.ybutton7);
		ed1=(EditText) findViewById(R.id.xuanke_end_data);
		ed2=(EditText) findViewById(R.id.shenhe_end_data);
		quedingdaoru.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				xuankedeadline=ed1.getText().toString().trim();
				shenhedeadline=ed2.getText().toString().trim();
				readFromFile();
				Toast.makeText(Yupdateplan.this, "开课计划书导入成功", 1).show();
				Intent intent=new Intent(Yupdateplan.this,Ymain.class);
				Yupdateplan.this.startActivity(intent);
			}
		});
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(Yupdateplan.this,Ymain.class);
//				Yupdateplan.this.startActivity(intent);
				Yupdateplan.this.finish();
			}
		});
		
	         
	    }
		
	
private void readFromFile(){
   
    
    if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
         
        String foldername = Environment.getExternalStorageDirectory().getPath();
        File folder = new File(foldername);
         
        if (folder == null || !folder.exists()) {
            folder.mkdir();
        }
         
        File targetFile=new File("/sdcard/rg.xls");
        String readedStr=null;
         
         try{
            if(!targetFile.exists()){
                targetFile.createNewFile();
                Toast.makeText(Yupdateplan.this,"文件不存在",Toast.LENGTH_LONG).show();
            }else{
            	
            	  InputStream in = new BufferedInputStream(new FileInputStream(targetFile));
//                  Workbook workbook=Workbook.getWorkbook(in);
//                  sheet= workbook.getSheet(0);
//      				rows = sheet.getRows();
//      				cols = sheet.getColumns();
      				zhuangye="计算机实验班";
            
 					
 						for(int i=3;i<rows;i++){
// 							 nianji = sheet.getCell(0, i).getContents();
// 	     					 renshu = sheet.getCell(2, i).getContents();
// 	     					 classname = sheet.getCell(3, i).getContents();
// 	     					 classtype = sheet.getCell(4, i).getContents();
// 	     					 xuefen = sheet.getCell(5, i).getContents();
// 	     					 xueshi = sheet.getCell(6, i).getContents();
// 	     					 shiyanxueshi = sheet.getCell(7, i).getContents();
// 	     					 shangjixueshi = sheet.getCell(8, i).getContents();
 	     					
 	 						
 	     					new AsyncTask<String, Void, Void>(){

 	     	 					@Override
 	     	 					protected Void doInBackground(String... params) {
 	     					List<NameValuePair>param=new ArrayList<NameValuePair>();
 	 						param.add(new BasicNameValuePair("nianji",nianji));
 	 						param.add(new BasicNameValuePair("zhuangye", zhuangye));
 	 						param.add(new BasicNameValuePair("renshu",renshu));
 	 						param.add(new BasicNameValuePair("kechen", classname));
 	 						param.add(new BasicNameValuePair("xuanxiu", classtype));
 	 						param.add(new BasicNameValuePair("xuefen", xuefen));
 	 						param.add(new BasicNameValuePair("xueshi", xueshi));
 	 						param.add(new BasicNameValuePair("shiyanxueshi", shiyanxueshi));
 	 						param.add(new BasicNameValuePair("shangjixueshi", shangjixueshi));
 	 						String url="http://115.28.69.231/android/addclass.php";
 	 						HttpPost httprequest=new HttpPost(url);
 	 						try {
 	 							HttpEntity httpEntity=new UrlEncodedFormEntity(param,"utf-8");
 	 							httprequest.setEntity(httpEntity);
 	 							HttpClient httpClient=new DefaultHttpClient();
 	 							HttpResponse httpResponse=httpClient.execute(httprequest);
 	 						
 						} catch (UnsupportedEncodingException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						} catch (ClientProtocolException e) {
 						// TODO Auto-generated catch block
 							e.printStackTrace();
 						} catch (IOException e) {
 							// TODO Auto-generated catch block
 						e.printStackTrace();
 						} 
 						
 						return null;
 	     	 					
 						
 					}
 					
 				}.execute("http://115.28.69.231/index.php");
 						}
 						
            	}
               
     				
 					
            }
          catch (Exception e) {
                Toast.makeText(Yupdateplan.this,e.toString(),Toast.LENGTH_LONG).show();
            
         }
    }else{
        Toast.makeText(Yupdateplan.this,"未发现SD卡！",Toast.LENGTH_LONG).show();
        
    }

	
}
}
