package com.app.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.demo.R;
import com.app.demo.adapter.ImageListAdapter;
import com.app.demo.base.ApplicationClass;
import com.app.demo.restapi.network.RestCallback;
import com.app.demo.restapi.network.ServerConnectListener;
import com.app.demo.restapi.network.ServerRequestCode;
import com.app.demo.restapi.respone.SearchLiveFeedsResponse;
import com.app.demo.restapi.respone.ServerResponse;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ImageListFragment extends Fragment implements ServerConnectListener {

    // Layout
    private View view;
    public Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayout mLlHolderLoading;
    private LinearLayout mLlHoldingLoadMore;
    private LinearLayout mLlRecyclerView;
    private LinearLayout mLlNoDataFound;
    private ArrayList<Object> mArrLiveFeeds = new ArrayList<>();

    private ImageListAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    public boolean mIsRefreshing = false;

    public static final int VISIBLE_LIST_ITEMS = 10;
    private final int UPDATE_UI = 1;
    private int previousTotal = 0;
    private int pagination = 1;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    private boolean isRequestIsInProgress = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == UPDATE_UI) {
                if (mArrLiveFeeds != null && mArrLiveFeeds.isEmpty()) {
                    showNoResultFound(true);
                } else {
                    showNoResultFound(false);
                    showUpdatedUI();
                }

            }
        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mIsRefreshing = true;
                mArrLiveFeeds.clear();
                pagination = 1;
                previousTotal = 0;
                fetchPropertyImages();

            }
        });


        if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0) //check for scroll down
                    {
                        visibleItemCount = linearLayoutManager.getChildCount();
                        totalItemCount = linearLayoutManager.getItemCount();
                        pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                        if (!isRequestIsInProgress) {
                            // End has been reached
                            // Do something
                            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                                pagination++;
                                showProgress(false, true);
                                fetchPropertyImages();
                                isRequestIsInProgress = true;
                            }
                        }
                    }
                }
            });
        }

        if (mArrLiveFeeds.isEmpty()) {
            showProgress(true, false);
            fetchPropertyImages();
        } else {
            handler.sendEmptyMessage(UPDATE_UI);
        }
    }

    /**
     * This is a temp api call to
     * may temp server for getting Images list.
     * It just work as a CND for this DEMO
     */
    private void fetchPropertyImages() {
        ApplicationClass
                .getRestClient()
                .getApiService()
                .getSearchLiveFeeds(1, 3, 1, "", "", -33.873691, 151.206864,
                        pagination, VISIBLE_LIST_ITEMS, 0, 0, 0, 0, 0, 0, "", "", "",
                        new RestCallback(ImageListFragment.this, ServerRequestCode.PROPERTY_REQUEST_CODE,
                                mContext));
    }

    private void fetchImages() {
        ApplicationClass
                .getRestClient()
                .getApiService()
                .getSearchLiveFeeds(1, 3, 1, "", "", -33.873691, 151.206864,
                        pagination, VISIBLE_LIST_ITEMS, 0, 0, 0, 0, 0, 0, "", "", "",
                        new RestCallback(ImageListFragment.this, ServerRequestCode.PROPERTY_REQUEST_CODE,
                                mContext));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_list, container, false);
        initComponents();
        return view;
    }

    public void initComponents() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.lv_office_live_feed);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mLlRecyclerView = (LinearLayout) view.findViewById(R.id.ll_main_rv);
        mLlNoDataFound = (LinearLayout) view.findViewById(R.id.ll_nodata);
        mAdapter = new ImageListAdapter(mArrLiveFeeds, mContext);
        mRecyclerView.setAdapter(mAdapter);
        mLlHolderLoading = (LinearLayout) view
                .findViewById(R.id.ui_center_loading);
        mLlHoldingLoadMore = (LinearLayout) view
                .findViewById(R.id.ui_more_loading);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
    }

    private void showNoResultFound(boolean b) {
        mLlNoDataFound.setVisibility(b ? View.VISIBLE : View.GONE);
        mLlRecyclerView.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    private void showUpdatedUI() {
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyDataSetChanged();
        mIsRefreshing = false;

        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    private void showProgress(boolean show, boolean isLoadMore) {
        mLlHolderLoading.setVisibility(show ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLlHoldingLoadMore.setVisibility(isLoadMore ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onSuccess(Object response) {
        if (((ServerResponse) response).getRequestCode() == ServerRequestCode.PROPERTY_REQUEST_CODE) {
            showProgress(false, false);
            isRequestIsInProgress = false;
            SearchLiveFeedsResponse propertyImgResponse = (SearchLiveFeedsResponse) response;
            if (propertyImgResponse != null) {
                if (pagination == 1) {

                    if (mArrLiveFeeds != null && !mArrLiveFeeds.isEmpty()) {
                        mArrLiveFeeds.clear();
                    }
                }
                mArrLiveFeeds.addAll(propertyImgResponse.getData().getLiveFeeds());
                handler.sendEmptyMessage(UPDATE_UI);
            }
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }

}
