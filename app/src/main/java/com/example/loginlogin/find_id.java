package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class find_id extends AppCompatActivity {
    Button ck;
    EditText mail;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_id);

        ck = findViewById(R.id.ck_btn2);
        mail = findViewById(R.id.ed_mail);
        img_back = findViewById(R.id.img_back15);

        img_back.setOnClickListener(v -> onBackPressed() );

        ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(find_id.this, find_id2.class);
                startActivity(i);
            }
        });

    }
}