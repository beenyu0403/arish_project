package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class setting_security1 extends AppCompatActivity {
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_security1);
        img_back = findViewById(R.id.img_back7);

        img_back.setOnClickListener(v -> onBackPressed() );
    }

    public void mOnclick(View v) {
        if (v.getId() == R.id.change_user_id) {
            Intent i = new Intent(setting_security1.this, setting_change_id.class);
            startActivity(i);
        } else if (v.getId() == R.id.change_user_pass) {
            Intent i = new Intent(setting_security1.this, setting_change_pw.class);
            startActivity(i);
        }
    }
}