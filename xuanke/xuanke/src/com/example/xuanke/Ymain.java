package com.example.xuanke;

import java.util.ArrayList;
import java.util.List;

//import com.example.text.Ymain;
//import com.example.text.Yupdateplan;



//import com.example.mdone.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Ymain extends Activity implements OnClickListener{

	private ViewPager Yviewpager;
	private PagerAdapter yadapter;
	private List<View> yViews = new ArrayList<View>();
	private LinearLayout yTabkaikexinxi;
	private LinearLayout yTabxuankeguanli;
	private LinearLayout yTabgerenshezhi;
	private LinearLayout yTabyonghuguanli;
	private ImageButton ykaikexinxiImg;
	private ImageButton yxuankeguanliImg;
	private ImageButton ygerenshezhiImg;
	private ImageButton yyonghuguanliImg;
	//����tab�ϵ�imagebutton�¼�������
	private ImageButton gengxinjiahuashu;//���¼ƻ��鰴ť
	private ImageButton daochukebiao;//�����ƻ���
	private ImageButton tianjiyonghu;//����û�
	private ImageButton shanchuyonghu;//ɾ���û�
	private ImageButton xiugaiyonghu;//�޸��û�
	private ImageButton weixuakejiaoshi;//δѡ�ν�ʦ��ť
	private ImageButton xiugaixinxi;//�޸ĸ�����Ϣ
	private Spinner xuenian;
	private Spinner xueqi;
	private List<String> list=new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	private List<String> list1=new ArrayList<String>();
	private ArrayAdapter<String> adapter1;
	private Spinner zhuanye;
	private List<String> list2=new ArrayList<String>();
	private ArrayAdapter<String> adapter2;
	private Button go;
	private String xq;
	private String xn;
	private String zy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.ymain_view);

		initView();
		initEvents();
	}
	private void initEvents() {
		// TODO Auto-generated method stub
		 yTabkaikexinxi.setOnClickListener(this);
		 yTabxuankeguanli.setOnClickListener(this);
		 yTabgerenshezhi.setOnClickListener(this);
		 yTabyonghuguanli.setOnClickListener(this);
		 //����imagebutton�ļ����¼�
		 gengxinjiahuashu.setOnClickListener(this);
		 weixuakejiaoshi.setOnClickListener(this);
		 xiugaixinxi.setOnClickListener(this);
		 xiugaiyonghu.setOnClickListener(this);
		 shanchuyonghu.setOnClickListener(this);
		 tianjiyonghu.setOnClickListener(this);
		 daochukebiao.setOnClickListener(this);
		 go.setOnClickListener(this);
		
	}
	@SuppressWarnings("deprecation")
	private void initView() {
		// TODO Auto-generated method stub
		Yviewpager=(ViewPager) findViewById(R.id.id_viewpager);
		
		
		yTabkaikexinxi=(LinearLayout) findViewById(R.id.id_y_tab_kaikejihuashu);
		yTabxuankeguanli=(LinearLayout) findViewById(R.id.id_y_tab_xuankeguanli);
		yTabgerenshezhi=(LinearLayout) findViewById(R.id.id_y_tab_gerenshezhi);
		yTabyonghuguanli=(LinearLayout) findViewById(R.id.id_y_tab_yonghuguanli);
		ykaikexinxiImg=(ImageButton) findViewById(R.id.id_y_tab_kaikejihuashu_img);
		yxuankeguanliImg=(ImageButton) findViewById(R.id.id_y_tab_xuankeguanli_img);
		ygerenshezhiImg=(ImageButton) findViewById(R.id.id_y_tab_gerenshezhi_img);
	    yyonghuguanliImg=(ImageButton) findViewById(R.id.id_y_tab_yonghuguanli_img);
	    
	    LayoutInflater yInflater = LayoutInflater.from(this);
		View tab01 = yInflater.inflate(R.layout.ytab01, null);
		View tab02 = yInflater.inflate(R.layout.ytab02, null);
		View tab03 = yInflater.inflate(R.layout.ytab03, null);
		View tab04 = yInflater.inflate(R.layout.ytab04, null);
		
		/**
		 * Ҫ��ȡ��tab01�����imagebutton,����ͨ��yInflater����
		 * ��ȡ����tab01����findviewbyid������ȡ��
		 * Ȼ���ٸ�imagebuttonע������¼��Ϳ����ˡ�
		 * 
		 */
		go=(Button)tab01.findViewById(R.id.y_chaxun);
		gengxinjiahuashu = (ImageButton) tab01.findViewById(R.id.id_y_tab_gengxin_img);
		xuenian=(Spinner) tab01.findViewById(R.id.y_xuenian);
		list.add("2014"); 
		list.add("2015");
		list.add("2016"); 
		list.add("2017"); 
		list.add("2018"); 
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    xuenian.setAdapter(adapter);
		xueqi=(Spinner) tab01.findViewById(R.id.y_xueqi);
		list1.add("��һѧ��");
		list1.add("�ڶ�ѧ��");
		list1.add("����ѧ��");
		adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    xueqi.setAdapter(adapter1);
	    zhuanye=(Spinner) tab01.findViewById(R.id.y_zhuanye);
		list2.add("�������ʵ��ࣩ");
		list2.add("�������׿Խ�ࣩ");
		list2.add("�����");
		list2.add("�������");
		list2.add("��ѧ�ࣨʵ��ࣩ");
		list2.add("���繤��");
		list2.add("��Ϣ��ȫ");
		adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    zhuanye.setAdapter(adapter2);
		weixuakejiaoshi=(ImageButton) tab02.findViewById(R.id.id_y_tab_weixuankejiaoshi_img);
		daochukebiao=(ImageButton) tab02.findViewById(R.id.id_tab_daochukebiao_img);
		xiugaixinxi=(ImageButton) tab03.findViewById(R.id.id_y_change_img);
		tianjiyonghu=(ImageButton) tab04.findViewById(R.id.id_y_tab_tianjiayonghu_img);
		shanchuyonghu=(ImageButton) tab04.findViewById(R.id.id_y_tab_shanchuyonghu_img);
		xiugaiyonghu=(ImageButton) tab04.findViewById(R.id.id_y_tab_xiugaiyonghu_img);
		
		yViews.add(tab01);
		yViews.add(tab02);
		yViews.add(tab03);
		yViews.add(tab04);
		yadapter = new PagerAdapter()
		{

			@Override
			public void destroyItem(ViewGroup container, int position,Object object)//ɾ����view
			{
				container.removeView(yViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position)//���view
			{
				View view = yViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public int getCount()//��ȡ��ǰview���±�
			{
				return yViews.size();
			}
			
		};
		
		Yviewpager.setAdapter(yadapter);

	}
	
	@Override
	public void onClick(View v)//����ÿһ��imagebutton�ļ����¼�
	{
		
		switch (v.getId())
		{
		case R.id.id_y_tab_kaikejihuashu://������Ӧ���棬��Ӧͼ�����
			Yviewpager.setCurrentItem(0);
			
			break;
		case R.id.id_y_tab_xuankeguanli:
			Yviewpager.setCurrentItem(1);
			
			break;
		case R.id.id_y_tab_gerenshezhi:
			Yviewpager.setCurrentItem(2);
			
			break;
		case R.id.id_y_tab_yonghuguanli:
			Yviewpager.setCurrentItem(3);
			break;
		case R.id.id_y_tab_gengxin_img://������μƻ��鰴ť��ת��Yupdateplan���¼ƻ���
					Intent intent=new Intent(Ymain.this,Yupdateplan.class);
					Ymain.this.startActivity(intent);
			
			break;
		case R.id.id_y_tab_weixuankejiaoshi_img://������μƻ��鰴ť��ת��Yunteacher��ѯδѡ�ν�ʦ
			 intent=new Intent(Ymain.this,Yunteacher.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_tab_daochukebiao_img://������μƻ��鰴ť��ת�������α����
			intent=new Intent(Ymain.this,Youtput.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_y_tab_tianjiayonghu_img://������μƻ��鰴ť��ת������û�����
			 intent=new Intent(Ymain.this,Yadduser.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_y_tab_shanchuyonghu_img://������μƻ��鰴ť��ת��ɾ���û�����
			intent=new Intent(Ymain.this,Ydeluser.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_y_tab_xiugaiyonghu_img://������μƻ��鰴ť��ת���޸��û�����
			System.out.println("aaa");
			 intent=new Intent(Ymain.this,Yresetuser.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_y_change_img://������μƻ��鰴ť��ת���޸ĸ�����Ϣ����
			 intent=new Intent(Ymain.this,Yidentity.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.y_chaxun://������μƻ��鰴ť��ת���޸ĸ�����Ϣ����
			xq=xueqi.getSelectedItem().toString();
			xn=xuenian.getSelectedItem().toString();
			zy=zhuanye.getSelectedItem().toString();
			Toast.makeText(Ymain.this, xq+" "+xn+""+zy, 1).show();
			break;
		default:
			break;
		}

}
	

	
}
