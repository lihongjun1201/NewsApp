package com.newtalent.allenlee.newsapp.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.newtalent.allenlee.newsapp.R;


/**
 * splash界面
 * 1. 旋转 +  渐变 进入屏幕 （完成）
 * 2. 检查网络连接，是否开启，是否wifi等工作
 * 3. app初始化工作
 * 4. 其他
 */
public class SplashActivity extends AppCompatActivity {


    private RelativeLayout splashBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashBackground = (RelativeLayout) findViewById(R.id.rl_splash_bg);

        startAnim();

        enterIntroActivity();

    }

    /**
     * 等待 1s 后进入介绍界面
     */
    private void enterIntroActivity() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(SplashActivity.this, IntroductionActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 开启spalsh界面动画
     */
    private void startAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        splashBackground.setAnimation(animation);
        animation.start();
    }
}
