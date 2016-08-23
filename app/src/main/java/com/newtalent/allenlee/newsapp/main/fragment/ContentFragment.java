package com.newtalent.allenlee.newsapp.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.newtalent.allenlee.newsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AllenLee on 2016/8/22.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {


    /**
     * viewpager页数
     */
    private static final int PAGES_NUM = 5;

    private ViewPager viewpagerContent;
    private List<TextView> pagesViewList;

    /**
     * 底部切换页面按钮们
     */
    private RadioButton rbtnHome;
    private RadioButton rbtnGovern;
    private RadioButton rbtnNewsCenter;
    private RadioButton rbtnSmartService;
    private RadioButton rbtnSetting;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initPageViews();

        RelativeLayout fragementView =
                (RelativeLayout) inflater.inflate(R.layout.fragment_content, null);

        viewpagerContent = (ViewPager) fragementView.findViewById(R.id.viewpager_content_frgt);
        viewpagerContent.setAdapter(new MyContentViewPagerAdapter());


        initTabButtons(fragementView);

        return fragementView;
    }

    /**
     * 初始化底部 radios Buttons
     * 并设置点击监听器
     * @param fragementView
     */
    private void initTabButtons(View fragementView) {
        rbtnHome = (RadioButton) fragementView.findViewById(R.id.rbtn_home);
        rbtnGovern = (RadioButton) fragementView.findViewById(R.id.rbtn_govern);
        rbtnNewsCenter = (RadioButton) fragementView.findViewById(R.id.rbtn_center);
        rbtnSmartService = (RadioButton) fragementView.findViewById(R.id.rbtn_service);
        rbtnSetting = (RadioButton) fragementView.findViewById(R.id.rbtn_setting);

        rbtnHome.setOnClickListener(this);
        rbtnGovern.setOnClickListener(this);
        rbtnNewsCenter.setOnClickListener(this);
        rbtnSmartService.setOnClickListener(this);
        rbtnSetting.setOnClickListener(this);

    }

    /**
     * 初始化每页视图
     */
    private void initPageViews() {
        pagesViewList = new ArrayList<>();
        for (int i = 0; i < PAGES_NUM; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText(i + "");
            textView.setTextSize(30);
            pagesViewList.add(textView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbtn_home:
                Log.d("tabs", "onClick: 切换tab page home");
                Toast.makeText(getActivity(), "home", Toast.LENGTH_SHORT).show();

                //设置false ，可以瞬间移动好，不会有滑动效果
                viewpagerContent.setCurrentItem(0,false);
                break;
            case R.id.rbtn_govern:
                Log.d("tabs", "onClick: 切换tab page govern");
                Toast.makeText(getActivity(), "govern", Toast.LENGTH_SHORT).show();

                viewpagerContent.setCurrentItem(1,false);
                break;
            case R.id.rbtn_center:
                Log.d("tabs", "onClick: 切换tab page center");
                Toast.makeText(getActivity(), "center", Toast.LENGTH_SHORT).show();

                viewpagerContent.setCurrentItem(2,false);
                break;
            case R.id.rbtn_service:
                Log.d("tabs", "onClick: 切换tab page service");
                Toast.makeText(getActivity(), "smart", Toast.LENGTH_SHORT).show();

                viewpagerContent.setCurrentItem(3,false);
                break;
            case R.id.rbtn_setting:
                Log.d("tabs", "onClick: 切换tab page setting");
                Toast.makeText(getActivity(), "setting", Toast.LENGTH_SHORT).show();

                viewpagerContent.setCurrentItem(4,false);
                break;
        }
    }

    private class MyContentViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return PAGES_NUM;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = pagesViewList.get(position);
            container.addView(textView);
            return textView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((TextView) object);
        }
    }



}
