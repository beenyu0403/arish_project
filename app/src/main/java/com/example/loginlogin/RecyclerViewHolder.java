package com.example.loginlogin;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView recycle_img;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        recycle_img = itemView.findViewById(R.id.recycle_img);
        recycle_img.setClipToOutline(true);
    }

}
