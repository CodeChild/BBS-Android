package com.twtstudio.bbs.bdpqchen.bbs.commons.di.component;

import android.app.Activity;

import com.twtstudio.bbs.bdpqchen.bbs.login.LoginActivity;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.module.ActivityModule;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.scope.PerActivity;
import com.twtstudio.bbs.bdpqchen.bbs.home.MainActivity;
import com.twtstudio.bbs.bdpqchen.bbs.register.RegisterActivity;
import com.twtstudio.bbs.bdpqchen.bbs.replaceUser.ReplaceUserActivity;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-26.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(RegisterActivity registerActivity);

    void inject(LoginActivity loginActivity);

    void inject(ReplaceUserActivity replaceUserActivity);
}
