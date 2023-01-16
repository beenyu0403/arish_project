package com.example.loginlogin;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    private List<mainData> mImageList;

    public RecyclerViewAdapter(List<mainData> a_list){
    mImageList = a_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.activity_main3, a_viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int a_position) {
        final mainData data = mImageList.get(a_position);

        holder.recycle_img.setImageResource(data.getImage());

    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }
}


