package com.newtalent.allenlee.newsapp.main.pages;

import android.app.Activity;
import android.widget.TextView;

import com.newtalent.allenlee.newsapp.R;

/**
 * Created by AllenLee on 2016/8/23.
 */
public class HomePage extends BasePage {

    public HomePage(Activity activity) {
        super(activity);
    }

    @Override
    public void createPageViewWithData() {
        setPageTitle(mActivity.getResources().getString(R.string.home_page));

        TextView contentView = new TextView(mActivity);
        contentView.setText("主页");
        contentView.setTextSize(30);
        pageContetLayout.addView(contentView);

    }
}
