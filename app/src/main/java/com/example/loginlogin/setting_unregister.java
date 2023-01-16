package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.Inet4Address;

public class setting_unregister extends AppCompatActivity {
    ImageView img_back, unregist_ck;
    boolean ckBTn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_unregister);
        img_back = findViewById(R.id.img_back10);

        img_back.setOnClickListener(v -> onBackPressed() );

        unregist_ck = findViewById(R.id.unregist_ckBtn);
    }

    public void mOnClick(View v) {
        if (v.getId() == R.id.unregist_btn) {
            Intent i = new Intent(setting_unregister.this, main2.class);
            startActivity(i);
        } else if (v.getId() == R.id.unregist_ckBtn && ckBTn == true) {
            unregist_ck.setImageResource(R.drawable.icon_awesome_check_circle);
            ckBTn = false;
        } else if (v.getId() == R.id.unregist_ckBtn && ckBTn == false) {
            unregist_ck.setImageResource(R.drawable.icon_awesome_check_circle2);
            ckBTn = true;
        }
    }
}