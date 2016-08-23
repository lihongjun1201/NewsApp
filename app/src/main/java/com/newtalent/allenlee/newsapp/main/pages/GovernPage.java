package com.newtalent.allenlee.newsapp.main.pages;

import android.app.Activity;
import android.widget.TextView;

import com.newtalent.allenlee.newsapp.R;

/**
 * Created by AllenLee on 2016/8/23.
 */
public class GovernPage extends BasePage {

    public GovernPage(Activity activity) {
        super(activity);
    }

    @Override
    public void createPageViewWithData() {

        setPageTitle(mActivity.getResources().getString(R.string.government));

        TextView contentView = new TextView(mActivity);
        contentView.setText("政要");
        contentView.setTextSize(30);
        pageContetLayout.addView(contentView);

    }
}
