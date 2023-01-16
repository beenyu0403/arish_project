package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class setting_security extends AppCompatActivity {
    ImageView img_back;
    //TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_security);

        img_back = findViewById(R.id.img_backnn1);
        //back = findViewById(R.id.back11);

        img_back.setOnClickListener(v -> onBackPressed() );
        //back.setOnClickListener(v -> onBackPressed());
    }
    public void mOnClick(View v){
        if(v.getId() == R.id.idpw_change || v.getId() == R.id.idpw_change_ck){
            Intent i = new Intent(setting_security.this, setting_security1.class);
            startActivity(i);
        } else if(v.getId() == R.id.unregist || v.getId() == R.id.unregist_ck){
            Intent i = new Intent(setting_security.this, setting_unregister.class);
            startActivity(i);
        }
    }
}