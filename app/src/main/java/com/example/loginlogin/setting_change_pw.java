package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class setting_change_pw extends AppCompatActivity {
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_change_pw);


        img_back = findViewById(R.id.img_back9);

        img_back.setOnClickListener(v -> onBackPressed() );




    }

    public void mOnClick(View v) {
        if (v.getId() == R.id.change_pw_end) {
            Intent i = new Intent(setting_change_pw.this, login.class);
            startActivity(i);
        }

    }
}