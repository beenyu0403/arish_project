package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        moveMain(2);

    }
    private void moveMain(int sec){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent it = new Intent(logo.this, main2.class);
                startActivity(it);
            }
        }, 1000*sec);
    }

}