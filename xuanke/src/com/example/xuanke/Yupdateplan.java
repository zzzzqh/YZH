package com.example.xuanke;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;








import jxl.Sheet;
import jxl.Workbook;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;








import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

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
	private Spinner kechengming;
	
	private List<String> list=new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	String excelname;
	Sheet sheet;
	int rows,cols;
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
		xn=xuenian.getText().toString();//获取学期
		xq=xueqi.getText().toString();//获取学年
		xkjz=xuankejiezhi.getText().toString();//获取选课截止日期
		shjz=shenhejiezhi.getText().toString();//获取审核截止日期
		kechengming=(Spinner) findViewById(R.id.y_kechengming);//课程列表
		//添加
		if (Environment.getExternalStorageState().equals(  
                Environment.MEDIA_MOUNTED)) {  
            File path = Environment.getExternalStorageDirectory();// 获得SD卡路径  
            
            File files = new File(path.getPath(),"/2015学年下学期开课计划书");
            if(files.isDirectory()){
            	getFileName(files.listFiles());  
            }
             
        }  
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        kechengming.setAdapter(adapter);
        excelname=list.get(0).toString();
   
		kechengming.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(Yupdateplan.this, list.get(arg2), Toast.LENGTH_SHORT).show();
				excelname=list.get(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				readFromFile(excelname);
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
	private void getFileName(File[] files) {  
	       
        for (File file : files) {  
            if (file.isDirectory()) {  
               

                getFileName(file.listFiles());  
               
            } else {  
                String fileName = file.getName();  
                if (fileName.endsWith(".xls")) {  
                    list.add(fileName);
                    
                }  
            }  
        }  
    } 
	private void readFromFile(String ename){
		   
	    
	    if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
	         
	        String foldername = Environment.getExternalStorageDirectory().getPath();
	        File folder = new File(foldername);
	         
	        if (folder == null || !folder.exists()) {
	            folder.mkdir();
	        }
	         
	        File targetFile=new File("/sdcard/2015学年下学期开课计划书/"+ename);
	        String readedStr=null;
	         
	         try{
	            if(!targetFile.exists()){
	                targetFile.createNewFile();
	                Toast.makeText(Yupdateplan.this,"文件不存在",Toast.LENGTH_LONG).show();
	            }else{
	            	
	            	  InputStream in = new BufferedInputStream(new FileInputStream(targetFile));
	                  Workbook workbook=Workbook.getWorkbook(in);
	                  sheet= workbook.getSheet(0);
	      				rows = sheet.getRows();
	      				cols = sheet.getColumns();
	      				
	 					
	 	     					new AsyncTask<String, Void, Void>(){

	 	     	 					@Override
	 	     						protected Void doInBackground(String... params) {

	 	     	 						for(int i=3;i<rows;i++){
	 	     	 							 nianji = sheet.getCell(0, i).getContents();
	 	     	 							 zhuangye=sheet.getCell(1, i).getContents();
	 	     	 	     					 renshu = sheet.getCell(2, i).getContents();
	 	     	 	     					 classname = sheet.getCell(3, i).getContents();
	 	     	 	     					 classtype = sheet.getCell(4, i).getContents();
	 	     	 	     					 xuefen = sheet.getCell(5, i).getContents();
	 	     	 	     					 xueshi = sheet.getCell(6, i).getContents();
	 	     	 	     					 shiyanxueshi = sheet.getCell(7, i).getContents();
	 	     	 	     					 shangjixueshi = sheet.getCell(8, i).getContents();
	 	     	 				String url="http://115.28.69.231/android/addclass.php";
	 	    	 				HttpPost httprequest=new HttpPost(url);
	 	     					List<NameValuePair>param=new ArrayList<NameValuePair>();
	 	     					param.add(new BasicNameValuePair("xueqi",xq));
	 	     					param.add(new BasicNameValuePair("xuenian",xn));
	 	 						param.add(new BasicNameValuePair("nianji",nianji));
	 	 						param.add(new BasicNameValuePair("zhuangye", zhuangye));
	 	 						param.add(new BasicNameValuePair("renshu",renshu));
	 	 						param.add(new BasicNameValuePair("kechen", classname));
	 	 						param.add(new BasicNameValuePair("xuanxiu", classtype));
	 	 						param.add(new BasicNameValuePair("xuefen", xuefen));
	 	 						param.add(new BasicNameValuePair("xueshi", xueshi));
	 	 						param.add(new BasicNameValuePair("shiyanxueshi", shiyanxueshi));
	 	 						param.add(new BasicNameValuePair("shangjixueshi", shangjixueshi));
	 	 						param.add(new BasicNameValuePair("deadline",xkjz));
	 	     					param.add(new BasicNameValuePair("deadday",shjz));
	 	 					
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
	 	     	 						}
	 						return null;
	 	     	 					
	 						
	 					}
	 					
	 				}.execute("http://115.28.69.231/index.php");
	 						
	 						
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
