package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class setting extends AppCompatActivity {
    ImageView img_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        //img_btn = findViewById(R.id.img_backnn3);
        //img_btn.setOnClickListener(v -> onBackPressed() );
    }

    public void mOnClick(View v){
        if(v.getId() == R.id.private_text || v.getId() == R.id.private_ck){
            Intent i = new Intent(setting.this, setting_security.class);
            startActivity(i);
        } else if(v.getId() == R.id.notice_text || v.getId() == R.id.notice_ck){
            Intent i = new Intent(setting.this, notice.class);
            startActivity(i);
        } else if(v.getId() == R.id.notification_text || v.getId() == R.id.notification_ck){
            Intent i = new Intent(setting.this, setting_alarm.class);
            startActivity(i);
        }else if (v.getId() == R.id.QnA_text || v.getId() == R.id.QnA_ck){
            Intent i = new Intent(setting.this, setting_qna.class);
            startActivity(i);
        }else if(v.getId() == R.id.img_backnn3 ){
            onBackPressed();
        }

    }
}