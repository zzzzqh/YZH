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
import android.widget.ImageButton;
import android.widget.LinearLayout;

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
		gengxinjiahuashu = (ImageButton) tab01.findViewById(R.id.id_y_tab_gengxin_img);
		weixuakejiaoshi=(ImageButton) tab02.findViewById(R.id.id_y_tab_weixuankejiaoshi_img);
		daochukebiao=(ImageButton) tab02.findViewById(R.id.id_tab_daochukebiao_img);
		xiugaixinxi=(ImageButton) tab03.findViewById(R.id.id_tab_xiugai_img);
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
			 intent=new Intent(Ymain.this,Yresetuser.class);
			Ymain.this.startActivity(intent);
	
			break;
		case R.id.id_tab_xiugai_img://������μƻ��鰴ť��ת���޸ĸ�����Ϣ����
			 intent=new Intent(Ymain.this,Yidentity.class);
			Ymain.this.startActivity(intent);
	
			break;
		default:
			break;
		}

}
	

	
}
