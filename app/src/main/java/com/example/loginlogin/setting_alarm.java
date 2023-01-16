package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class setting_alarm extends AppCompatActivity {
    ImageView img_back;
    ImageView setting_alarm_button;
    TextView back;
    //int i=0;
    //int j=0;
    //int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_alarm);

        img_back = findViewById(R.id.img_back8);
        back = findViewById(R.id.back);

        img_back.setOnClickListener(v -> onBackPressed() );
        back.setOnClickListener(v -> onBackPressed());
    }
    public void mOnClick(View v){

       /* if(v.getId() == R.id.settal_button1){
            i = 1-i;
            setting_alarm_button = findViewById(R.id.settal_button4);
            if(i==0) {
                setting_alarm_button.setVisibility(View.INVISIBLE);
            }else{
                setting_alarm_button.setVisibility(View.VISIBLE);
            }
        } else if(v.getId() == R.id.settal_button2){
            j = 1-j;
            setting_alarm_button = findViewById(R.id.settal_button5);
            if(j==0) {
                setting_alarm_button.setVisibility(View.INVISIBLE);
            }else{
                setting_alarm_button.setVisibility(View.VISIBLE);
            }
        } else if(v.getId() == R.id.settal_button3){
            k = 1-k;
            setting_alarm_button = findViewById(R.id.settal_button6);
            if(k==0) {
                setting_alarm_button.setVisibility(View.INVISIBLE);
            }else{
                setting_alarm_button.setVisibility(View.VISIBLE);
            }
        }*/
        if(v.getId() == R.id.settal_button1){
            setting_alarm_button = findViewById(R.id.settal_button4);
            setting_alarm_button.setVisibility(View.VISIBLE);
        }else if(v.getId() == R.id.settal_button2){
            setting_alarm_button = findViewById(R.id.settal_button5);
            setting_alarm_button.setVisibility(View.VISIBLE);
        }else if(v.getId() == R.id.settal_button3){
            setting_alarm_button = findViewById(R.id.settal_button6);
            setting_alarm_button.setVisibility(View.VISIBLE);
        }else if(v.getId() == R.id.settal_button4){
            setting_alarm_button = findViewById(R.id.settal_button4);
            setting_alarm_button.setVisibility(View.INVISIBLE);
        }else if(v.getId() == R.id.settal_button5){
            setting_alarm_button = findViewById(R.id.settal_button5);
            setting_alarm_button.setVisibility(View.INVISIBLE);
        }else if(v.getId() == R.id.settal_button6){
            setting_alarm_button = findViewById(R.id.settal_button6);
            setting_alarm_button.setVisibility(View.INVISIBLE);
        }

    }
}