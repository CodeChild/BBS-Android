package com.twtstudio.bbs.bdpqchen.bbs.commons.support;

import android.content.Context;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.twtstudio.bbs.bdpqchen.bbs.commons.rx.RxDoHttpClient;

import java.io.InputStream;


public class OkHttpUrlLoader implements StreamModelLoader<GlideUrl> {
    private final okhttp3.Call.Factory client;

    public OkHttpUrlLoader(okhttp3.Call.Factory client) {
        this.client = client;
    }

    public DataFetcher<InputStream> getResourceFetcher(GlideUrl model, int width, int height) {
        return new OkHttpStreamFetcher(this.client, model);
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile okhttp3.Call.Factory internalClient;
        private okhttp3.Call.Factory client;

        public Factory() {
            this(getInternalClient());
        }

        public Factory(okhttp3.Call.Factory client) {
            this.client = client;
        }

        private static okhttp3.Call.Factory getInternalClient() {
            if(internalClient == null) {
                Class var0 = Factory.class;
                synchronized(Factory.class) {
                    if(internalClient == null) {
                        internalClient = RxDoHttpClient.getUnsafeOkHttpClient().build();
//                        internalClient = new OkHttpClient();
                    }
                }
            }

            return internalClient;
        }

        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new OkHttpUrlLoader(this.client);
        }

        public void teardown() {
        }
    }
}