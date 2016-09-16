package com.app.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.demo.R;
import com.app.demo.holder.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public List<Object> arrListData;
    private Context mContext;

    public ImageListAdapter(List<Object> applications, Context mContext) {
        this.arrListData = applications;
        this.mContext = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image_list, parent, false);
        return new RecyclerViewHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int i) {
        holder.updateView(arrListData.get(i));
    }

    @Override
    public int getItemCount() {
        return arrListData == null ? 0 : arrListData.size();
    }

    public void setData(ArrayList<Object> data) {
        this.arrListData = data;
    }
}
