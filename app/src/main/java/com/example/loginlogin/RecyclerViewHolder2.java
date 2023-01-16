package com.example.loginlogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder2 extends RecyclerView.ViewHolder {
    ImageView recycle_img;
    TextView recycle_txt;

    public RecyclerViewHolder2(@NonNull View itemView) {
        super(itemView);

        recycle_img = itemView.findViewById(R.id.img_list);
        recycle_txt = itemView.findViewById(R.id.img_title);

    }

}

