package com.twtstudio.bbs.bdpqchen.bbs;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.oubowu.slideback.ActivityHelper;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.component.AppComponent;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.component.DaggerAppComponent;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.module.AppModule;

/**
 * Created by bdpqchen on 17-4-17.
 */

public class App extends Application {

    private Context mContext;
    private LogLevel mLogLevel = LogLevel.FULL;
    private ActivityHelper mActivityHelper;
    private static App sMyApplication;
    private AppComponent mAppComponent;
    private App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        mInstance = this;

        if (!isApkDebug(mContext)){
            mLogLevel = LogLevel.NONE;
        }

        initApp();

        mActivityHelper = new ActivityHelper();
        registerActivityLifecycleCallbacks(mActivityHelper);
        sMyApplication = this;

    }

    public AppComponent getAppComponent(){
        if (mAppComponent == null){
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return mAppComponent;
    }

    public static ActivityHelper getActivityHelper(){
        return sMyApplication.mActivityHelper;
    }

    private void initApp(){
        Hawk.init(mContext).build();
        Logger.init()
                .logLevel(mLogLevel)
                .methodCount(3);


    }

    public static boolean isApkDebug(Context context) {
        try {
            ApplicationInfo info= context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE)!=0;
        } catch (Exception ignored) {

        }
        return false;
    }



}
