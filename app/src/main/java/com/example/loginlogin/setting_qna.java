package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class setting_qna extends AppCompatActivity {
    ImageView img_back;
    int i=0;
    ImageView setting_qna_text;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_qna);

        img_back = findViewById(R.id.img_back8);
        back = findViewById(R.id.back);

        img_back.setOnClickListener(v -> onBackPressed() );
        back.setOnClickListener(v -> onBackPressed());
    }
    public void mOnClick(View v){
        if(v.getId() == R.id.setting_qna1){
            i=1-i;
            if(i==0){
                setting_qna_text = findViewById(R.id.setting_qna_text);
                setting_qna_text.setVisibility(View.GONE);
            }else{
                setting_qna_text = findViewById(R.id.setting_qna_text);
                setting_qna_text.setVisibility(View.VISIBLE);
            }

        }
    }
}