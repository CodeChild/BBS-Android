package com.twtstudio.bbs.bdpqchen.bbs.commons.support;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;


public class SimpleGlideModule implements GlideModule {
    public SimpleGlideModule() {
    }

    public void applyOptions(Context context, GlideBuilder builder) {
    }

    public void registerComponents(Context context, Glide glide) {
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory());
    }

}