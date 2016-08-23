package com.newtalent.allenlee.newsapp.main.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.newtalent.allenlee.newsapp.R;
import com.newtalent.allenlee.newsapp.main.fragment.ContentFragment;
import com.newtalent.allenlee.newsapp.main.fragment.SideMenuFragment;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configure the SlidingMenu
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.side_menu_content);


        //动态加载 fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_content,new ContentFragment());
        fragmentTransaction.replace(R.id.fl_main_leftmenu,new SideMenuFragment());
        fragmentTransaction.commit();

    }

    /**
     * 拉开 / 关闭 侧滑菜单
     */
    public void toggleSlideMenu() {
        slidingMenu.toggle();
    }



}
