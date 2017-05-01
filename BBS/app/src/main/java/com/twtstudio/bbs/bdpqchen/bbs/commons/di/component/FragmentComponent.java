package com.twtstudio.bbs.bdpqchen.bbs.commons.di.component;

import android.app.Activity;

import com.twtstudio.bbs.bdpqchen.bbs.commons.di.module.FragmentModule;
import com.twtstudio.bbs.bdpqchen.bbs.commons.di.scope.PerFragment;

import dagger.Component;

/**
 * Created by bdpqchen on 17-5-2.
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

//    void inject();

}
