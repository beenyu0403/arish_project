package com.example.loginlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter2 extends  RecyclerView.Adapter<RecyclerViewHolder2> {

    private List<mainData2> mList;

    public RecyclerViewAdapter2(List<mainData2> a_list){
        mList = a_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder2 onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.activity_main_list, a_viewGroup, false);
        return new RecyclerViewHolder2(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder2 holder, int position) {
        final mainData2 data = mList.get(position);

        holder.recycle_img.setImageResource(data.getImage2());

        holder.recycle_txt.setText(data.getText());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
