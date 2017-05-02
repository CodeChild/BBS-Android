package com.twtstudio.bbs.bdpqchen.bbs.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.PrefUtil;
import com.twtstudio.bbs.bdpqchen.bbs.home.MainActivity;
import com.twtstudio.bbs.bdpqchen.bbs.login.LoginActivity;

/**
 * Created by bdpqchen on 17-5-2.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO: 17-5-2 first open app
//        if (isFirstOpen)


        if (PrefUtil.hadLogin() || PrefUtil.isNoAccountUser()){
            startActivity(new Intent(this, MainActivity.class));
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }

        finish();

    }
}
