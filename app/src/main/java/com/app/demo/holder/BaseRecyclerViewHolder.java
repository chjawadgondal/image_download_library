package com.app.demo.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Base Class for Recycler Adapter.
 * This class init and update the view.
 */
class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
    protected Context mContext;

    public BaseRecyclerViewHolder(Context mContext, View itemView) {
        super(itemView);
        this.mContext = mContext;
        initComponents(itemView);
        addListener();
    }

    protected void initComponents(View view) {
        if (view != null && mContext == null) {
            mContext = view.getContext();
        }
    }

    protected void addListener() {
    }

    @Override
    public void onClick(View v) {
        // Child classes that require this function will override it.
    }

}
