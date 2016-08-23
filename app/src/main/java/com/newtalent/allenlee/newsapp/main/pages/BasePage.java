package com.newtalent.allenlee.newsapp.main.pages;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newtalent.allenlee.newsapp.R;

/**
 * Created by AllenLee on 2016/8/23.
 *
 * 抽取出基类 BasePage
 * 分层： MainActivity 负责管理侧滑餐单SlideMenuFragment 和页面内容ContentFragment
 * ContentFragment 负责管理底部tabs radioButtons 和 中间内容ViewPager
 * ViewPager 负责管理 每一页
 * BasePage 包好各xxxPage 都有的顶部红色标题栏
 * 不同的Page通过override creatView函数，实现多态性，负责构建自身的布局视图，和业务逻辑。
 *
 */
public abstract class BasePage {

    /**
     * 整个page的全部布局视图
     */
    public View mPageView;

    /**
     * activity作为context
     */
    public Activity mActivity;

    /**
     * 标题栏的左右按钮 & 中间标题
     */
    protected ImageButton btnMenuToggle;
    protected ImageButton btnRight     ;
    protected TextView    pageTitleView;

    /**
     * 该page的内容布局
     */
    protected LinearLayout pageContetLayout;


    public BasePage(Activity activity ) {
        mActivity =activity;
        initView();
        createPageViewWithData(); //去修改当前这个page的tv_pageview_pageTitle等信息。
    }

    /**
     * 不同的page需要重写该方法
     * 创建各自不同的布局视图
     */
    public abstract void createPageViewWithData() ;


    private void initView() {
        mPageView =   View.inflate(mActivity, R.layout.page_content, null);

        btnMenuToggle  = (ImageButton) mPageView.findViewById(R.id.btn_page_content_menutoggle);
        btnRight       = (ImageButton) mPageView.findViewById(R.id.btn_page_content_right);
        pageTitleView  = (TextView) mPageView.findViewById(R.id.tv_page_content_title);

        btnMenuToggle.setVisibility(View.INVISIBLE);
        btnRight.setVisibility(View.INVISIBLE);

        pageContetLayout = (LinearLayout) mPageView.findViewById(R.id.linearlayout_pagecontent);
    }

    /**
     * 设置该Page的标题信息
     * @param title
     */
    public void setPageTitle(String title){
        pageTitleView.setText(title);
    }

}
