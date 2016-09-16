package com.app.demo.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.app.demo.utility.ImageUtility;
import com.app.demo.R;
import com.app.demo.restapi.respone.SearchLiveFeedsResponse;


/**
 * Created by Administrator on 4/6/2016.
 */
public class RecyclerViewHolder extends BaseRecyclerViewHolder {

    private SearchLiveFeedsResponse.SearchLiveFeedsData.LiveFeed mResponseObj;
    private View row;
    private RelativeLayout mRlRow;
    private ImageView mIvPropertyImage;
    private ProgressBar mPbLoadingIndicator;


    public RecyclerViewHolder(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    protected void initComponents(View view) {
        row = view;
        mPbLoadingIndicator = (ProgressBar) row.findViewById(R.id.pb_loading_indicator);
        mIvPropertyImage = (ImageView) row.findViewById(R.id.image_view);
    }

    @Override
    protected void addListener() {
        // mRlRow.setOnClickListener(this);
    }

    public void updateView(Object data) {
        mResponseObj = (SearchLiveFeedsResponse.SearchLiveFeedsData.LiveFeed) data;
        if(mResponseObj.getPropertyImageUrl() != null){
            ImageUtility.fetchThumbnail(mIvPropertyImage, mPbLoadingIndicator,
                    mResponseObj.getPropertyImageUrl(), mContext, null);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_view:
                break;
        }
    }

}