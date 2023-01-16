package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class notice extends AppCompatActivity {
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        img_back = findViewById(R.id.img_back8);
        //back = findViewById(R.id.back11);

        img_back.setOnClickListener(v -> onBackPressed() );
        //back.setOnClickListener(v -> onBackPressed());
    }
}