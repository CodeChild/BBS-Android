package com.twtstudio.bbs.bdpqchen.bbs.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.twtstudio.bbs.bdpqchen.bbs.R;
import com.twtstudio.bbs.bdpqchen.bbs.commons.rx.RxDoHttpClient;
import com.twtstudio.bbs.bdpqchen.bbs.individual.IndividualFragment;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bdpqchen on 17-5-4.
 */

public final class ImageUtil {

    private static final String sMyAvatarUrl = RxDoHttpClient.BASE_URL + "/user/" + PrefUtil.getAuthUid() + "avatar";

    public static void load(Context context, int resourceId, ImageView view) {
        Glide.with(context).load(resourceId).asBitmap().centerCrop().dontAnimate().into(view);
    }

    public static void loadWithHeight(Context context, int resourceId, ImageView view) {
        Glide.with(context).load(resourceId).centerCrop().dontAnimate().into(view);
    }

    public static void loadFromUrl(Context context, String url, ImageView view) {
        Glide.with(context).load(url).centerCrop().into(view);
    }

    public static void loadAvatar(Context context, String avatarUrl, ImageView view) {
        Glide.with(context).load(avatarUrl).centerCrop()
//                .placeholder(R.drawable.avatar2)
                .into(view);
    }


    public static void loadMyAvatar(Context context, ImageView civAvatar) {
//        String url = RxDoHttpClient.BASE_URL + "user/19667/avatar";
        String url = "https://www.instantssl.com/images/http-vs-https.png";
//        loadAvatar(context, sMyAvatarUrl, civAvatar);
        loadAvatar(context, url, civAvatar);
    }
}
