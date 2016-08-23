package com.newtalent.allenlee.newsapp.main.mycostomview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by AllenLee on 2016/8/23.
 */
public class UnScollableViewPager extends ViewPager {

    public UnScollableViewPager(Context context) {
        super(context);
    }

    public UnScollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 使得viewPager不可滑动，只能通过底部tabs按钮切换page
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
