package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class find_id_pw extends AppCompatActivity {
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_id_pw);

        backBtn = findViewById(R.id.img_back5);
        backBtn.setOnClickListener(v -> onBackPressed());

    }

    public void mOnClick(View v) {
        if (v.getId() == R.id.findID_btn) {
            Intent it = new Intent(find_id_pw.this, find_id.class);
            startActivity(it);
        } else if (v.getId() == R.id.findPW_btn) {
            Intent intent = new Intent(find_id_pw.this, find_pw.class);
            startActivity(intent);
        }
    }
}