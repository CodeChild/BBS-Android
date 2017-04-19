package com.twtstudio.bbs.bdpqchen.bbs.commons.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;

import com.jaeger.library.StatusBarUtil;
import com.oubowu.slideback.SlideConfig;
import com.twtstudio.bbs.bdpqchen.bbs.R;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.AppActivityManager;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.PrefUtils;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.ResourceUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by bdpqchen on 17-4-18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Unbinder mUnbinder;
    public SlideConfig mSlideConfig;

    protected abstract int getLayoutResourceId();

    protected abstract Toolbar getToolbarView();

    protected abstract boolean isShowBackArrow();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(PrefUtils.isNightMode() ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(getLayoutResourceId());

        mUnbinder = ButterKnife.bind(this);
        AppActivityManager.getActivityManager().addActivity(this);
        StatusBarUtil.setColor(this, ResourceUtils.getColor(this, R.color.colorPrimary), 25);

        mSlideConfig = new SlideConfig.Builder().rotateScreen(true).edgeOnly(true).lock(false)
                .edgePercent(0.2f).slideOutPercent(0.5f).create();

        mToolbar = getToolbarView();
        if (null != mToolbar){
            setSupportActionBar(mToolbar);
            if (isShowBackArrow()){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

        }




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
