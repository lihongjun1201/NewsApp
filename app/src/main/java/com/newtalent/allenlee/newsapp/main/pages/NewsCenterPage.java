package com.newtalent.allenlee.newsapp.main.pages;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.newtalent.allenlee.newsapp.R;
import com.newtalent.allenlee.newsapp.main.activity.MainActivity;

/**
 * Created by AllenLee on 2016/8/23.
 */
public class NewsCenterPage extends BasePage {

    public NewsCenterPage(Activity activity) {
        super(activity);

        btnMenuToggle.setVisibility(View.VISIBLE);
        btnRight.setVisibility(View.VISIBLE);

        btnMenuToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)mActivity).toggleSlideMenu();
            }
        });

    }

    @Override
    public void createPageViewWithData() {
        setPageTitle(mActivity.getResources().getString(R.string.news_center));

        TextView contentView = new TextView(mActivity);
        contentView.setText("新闻中心");
        contentView.setTextSize(30);
        pageContetLayout.addView(contentView);
    }
}
