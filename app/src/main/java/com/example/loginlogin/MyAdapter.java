package com.example.loginlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;
    private ArrayList<item> mList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_title;
        private ImageView imageView_img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_title= itemView.findViewById(R.id.title);
            imageView_img = itemView.findViewById(R.id.imageView_img);
        }
    }

    public MyAdapter(ArrayList<item> list){
        this.mList= list;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.textView_title.setText(String.valueOf(mList.get(position).getTitle()));
            GlideApp.with(holder.itemView).load(mList.get(position).getImg_url())
                    .override(300,400)
                    .into(holder.imageView_img);
        }



    @Override
    public int getItemCount() {
        return mList.size();
    }
}
