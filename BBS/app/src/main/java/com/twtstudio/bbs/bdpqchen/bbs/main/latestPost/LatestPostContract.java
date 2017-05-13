package com.twtstudio.bbs.bdpqchen.bbs.main.latestPost;

import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BasePresenter;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseView;

import java.util.List;

/**
 * Created by bdpqchen on 17-5-11.
 */

interface LatestPostContract {
    interface View extends BaseView{
        void addLatestPostList(List<LatestPostModel.AnnounceBean> announceBeens);
        void refreshLatestPostList(List<LatestPostModel.AnnounceBean> announceBeens);
        void failedToGetLatestPost(String msg);
    }
    interface Presenter extends BasePresenter<View>{
        void refreshLatestPostList();
        void addLatestPostList();
    }
}
