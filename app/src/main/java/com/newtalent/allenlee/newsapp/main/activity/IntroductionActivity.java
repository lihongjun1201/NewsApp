package com.newtalent.allenlee.newsapp.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.newtalent.allenlee.newsapp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 向导简介页面
 * <p/>
 * 利用Viewpager实现
 * 指示点自己实现
 */
public class IntroductionActivity extends AppCompatActivity {
    private static final String TAG = "IntroductionActivity";

    private List<ImageView> guideImagesList;

    private ViewPager introViewPager;

    private LinearLayout greyPiontsView;
    private FrameLayout.LayoutParams framelayoutParams;
    private View redPoint;

    private Button enterHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        initIntroImagesData();

        initViews();
    }

    private void initViews() {
        initViewPager();

        initIndicatoionPoints();

        //最后一页显示的button
        enterHomeButton = (Button) findViewById(R.id.btn_intro_aty_enter_home);
    }

    /**
     * 初始化 ViewPager 指示点
     */
    private void initIndicatoionPoints() {
        greyPiontsView = (LinearLayout) findViewById(R.id.ll_intro_aty_gray_points);

        framelayoutParams = new FrameLayout.LayoutParams(20, 20);
        redPoint = findViewById(R.id.red_point_intro_aty);

        for (int i = 0; i < guideImagesList.size(); i++) {
            View greypoint = new View(this);
            greypoint.setBackgroundResource(R.drawable.indicator_gray_point);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            layoutParams.rightMargin = 20;
            greypoint.setLayoutParams(layoutParams);

            greyPiontsView.addView(greypoint);
        }

    }

    /**
     * 初始化ViewPager
     * 设置数据适配器
     * 添加页面滑动变化监听器
     */
    private void initViewPager() {
        Log.d(TAG, "initViewPager: ");

        introViewPager = (ViewPager) findViewById(R.id.viewpager_intro_aty);
        introViewPager.setAdapter(new MyViewPagerAdapter());
        introViewPager.addOnPageChangeListener(new MyPageChangeListener());
    }

    /**
     * 加载图片资源文件，初始化 3个介绍页面
     */
    private void initIntroImagesData() {
        guideImagesList = new ArrayList<>();
        int[] imagesIdArray = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
        for (int i = 0; i < imagesIdArray.length; i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(imagesIdArray[i]);
            guideImagesList.add(image);
        }
    }


    /**
     * ViewPager 页面变化监听器
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.d(TAG, "onPageScrolled: " + position + ",offset: " + positionOffset);
            framelayoutParams.leftMargin = position * 40 + (int) (40 * positionOffset);
            redPoint.setLayoutParams(framelayoutParams);

        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected: " + position);

            framelayoutParams.leftMargin = position * 40;
            redPoint.setLayoutParams(framelayoutParams);

            if(position == 2) {
                enterHomeButton.setVisibility(View.VISIBLE);
            } else {
                enterHomeButton.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.d(TAG, "onPageScrollStateChanged: " + state);
        }
    }

    /**
     * ViewPager 适配器
     */
    private class MyViewPagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return guideImagesList.size();
        }

        /**
         * 必须要重写，让系统可以判断
         *
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 关键重写函数，实例化每一页View
         *
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
         /*   for (int i = 0; i < guideImagesList.size(); i++) {
                container.addView(guideImagesList.get(i));
            }*/

            ImageView imageView = guideImagesList.get(position);
            container.addView(imageView);

            return imageView;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("viewpager", "destroyItem: ");
            container.removeView((ImageView) object);
        }
    }

    public void enterHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
