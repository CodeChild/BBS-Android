package com.twtstudio.bbs.bdpqchen.bbs.main.latestPost;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twtstudio.bbs.bdpqchen.bbs.R;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseAdapter;
import com.twtstudio.bbs.bdpqchen.bbs.commons.base.BaseViewHolder;
import com.twtstudio.bbs.bdpqchen.bbs.commons.utils.ImageUtil;
import com.twtstudio.bbs.bdpqchen.bbs.main.TimeUtils;
import com.twtstudio.bbs.bdpqchen.bbs.main.content.ContentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangyulong on 5/12/17.
 */

public class LatestPostAdapter extends BaseAdapter<LatestPostModel.DataBean.LatestBean>{
    public LatestPostAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LatestPostViewHolder holder = new LatestPostViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.activity_latest_post_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        LatestPostViewHolder mholder=(LatestPostViewHolder) holder;
        //Date date=new Date(mholder.announceBean.getT_create());
        mholder.announceBean= mDataSet.get(position);
        mholder.title.setText(mholder.announceBean.getTitle());
        mholder.author.setText(mholder.announceBean.getAuthor_name());
        mholder.create_time.setText(TimeUtils.getStandardDate(mholder.announceBean.getT_create()));
        //mholder.collection.setAlpha(0x000);
//        ImageUtil.loadItemAvatarHome(mContext,mholder.avatar,avatarurl);

    }

    class LatestPostViewHolder extends BaseViewHolder implements View.OnClickListener {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.create_time)
        TextView create_time;
        LatestPostModel.DataBean.LatestBean announceBean;
        public LatestPostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           /* if (mItemClickListener != null) {
                mItemClickListener.OnItemClick((LatestPostContract.View) v,(Integer) itemView.getTag());
            }*/
            Intent intent = new Intent(mContext,ContentActivity.class);
            intent.putExtra("threadid",mDataSet.get(getPosition()).getId());
            mContext.startActivity(intent);
        }
    }

}