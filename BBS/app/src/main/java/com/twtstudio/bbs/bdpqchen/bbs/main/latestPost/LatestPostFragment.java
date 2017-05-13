package com.twtstudio.bbs.bdpqchen.bbs.main.latestPost;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twtstudio.bbs.bdpqchen.bbs.R;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseAdapter;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseFragment;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by bdpqchen on 17-5-11.
 */

public class LatestPostFragment extends BaseFragment<LatestPostPresenter> implements LatestPostContract.View {
    private static final String ARG_LATESTPOST_TYPE = "ARG_LATESPOST_TYPE";
    @BindView(R.id.id_recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.layout_swipe_refresh)
    SwipeRefreshLayout layoutSwipeRefresh;
    Unbinder unbinder;
    LatestPostAdapter latestPostAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_latest_post;
    }

    @Override
    protected void injectFragment() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initFragment() {
        latestPostAdapter=new LatestPostAdapter(getActivity());
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        mPresenter.refreshLatestPostList();
        recyclerview.setAdapter(latestPostAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void addLatestPostList(List<LatestPostModel.AnnounceBean> announceBeen) {
        latestPostAdapter.addList(announceBeen);
    }

    @Override
    public void refreshLatestPostList(List<LatestPostModel.AnnounceBean> announceBeen) {
        latestPostAdapter.refreshList(announceBeen);
    }

    @Override
    public void failedToGetLatestPost(String msg) {

    }
    void initData() {
        List<LatestPostModel> latestPostModels=new ArrayList<>();
    }
}
