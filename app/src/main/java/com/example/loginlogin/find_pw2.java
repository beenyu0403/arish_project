package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class find_pw2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw2);


    }

    public void mOnClick(View v){
        if(v.getId() == R.id.login_button3){
            Intent it = new Intent(find_pw2.this, login.class);
            startActivity(it);
            finish();
        }

    }
}