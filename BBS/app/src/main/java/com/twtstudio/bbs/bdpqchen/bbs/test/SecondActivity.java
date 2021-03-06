package com.twtstudio.bbs.bdpqchen.bbs.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;

import com.oubowu.slideback.SlideBackHelper;
import com.oubowu.slideback.widget.SlideBackLayout;
import com.twtstudio.bbs.bdpqchen.bbs.App;
import com.twtstudio.bbs.bdpqchen.bbs.R;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseActivity;
import com.twtstudio.bbs.bdpqchen.bbs.commons.manager.ActivityManager;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.HandlerUtil;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.PrefUtil;

import butterknife.BindView;

/**
 * Created by bdpqchen on 17-4-19.
 */

public class SecondActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sc_night_mode)
    SwitchCompat scNightMode;

    private SlideBackLayout mSlideBackLayout;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_second;
    }

    @Override
    protected Toolbar getToolbarView() {
        mToolbar.setTitle("第二");
        return mToolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }

    @Override
    protected boolean isSupportNightMode() {
        return true;
    }

    @Override
    protected void inject() {

    }

    @Override
    protected Activity supportSlideBack() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SwitchCompat switchNightMode = (SwitchCompat) findViewById(R.id.sc_night_mode);
        switchNightMode.setChecked(PrefUtil.isNightMode());
        switchNightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PrefUtil.setIsNightMode(isChecked);
                startMySelf();
            }

        });
    }

    public void startMySelf() {
        //方案1
        HandlerUtil.postDelay(new Runnable() {
            @Override
            public void run() {
                ActivityManager.getActivityManager().recreateAllActivity(SecondActivity.class);
//                mSlideBackLayout.lock(true);
            }
        }, 100);

//        mSlideBackLayout.lock(true);
        ActivityManager.getActivityManager().finishActivity(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(getIntent());

        //方案2
//        Activity activity = this;
//        activity.getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
//        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//        activity.recreate();
        //方案3
        /*Intent intent = new Intent(this, SecondActivity.class);
        new BaseViewHelper
                .Builder(this, view)
                .startActivity(intent);
        */
    }

/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
*/

    @Override
    protected void onResume() {
        super.onResume();
        if (mSlideBackLayout != null){
            mSlideBackLayout.lock(PrefUtil.isSlideBackMode());
        }

    }


}

