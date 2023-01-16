package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class find_pw extends AppCompatActivity {
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_pw);
        img_back = findViewById(R.id.img_back13);

        img_back.setOnClickListener(v -> onBackPressed() );
    }

    public void mOnClick(View v){
        if(v.getId() == R.id.ck_btn4){
            Intent it = new Intent(find_pw.this, find_pw2.class);
            startActivity(it);
        }

    }
}