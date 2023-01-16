package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class register_email extends AppCompatActivity {

    ImageView img_next, img_back, img_ck, img_ed;
    EditText email;
    TextView em_notion;
    private String userID, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_email);


        img_back = findViewById(R.id.img_back3);
        img_next = findViewById(R.id.img_next2);
        email = findViewById(R.id.sign_email);
        em_notion = findViewById(R.id.em_notion);
        img_ck = findViewById(R.id.img_ck2);
        img_ed = findViewById(R.id.em_Edit);

        img_back.setOnClickListener(v -> onBackPressed() );

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userEmail = email.getText().toString();

                if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    em_notion.setText("이메일 형식에 맞게 작성해주세요!!");
                    em_notion.setTextColor(Color.parseColor("#FF0000"));
                    img_ck.setImageResource(R.drawable.ck_red);
                    img_ed.setImageResource(R.drawable.edittext_red);
                    img_next.setEnabled(false);
                } else if (Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    em_notion.setTextColor(Color.parseColor("#FFFFFF"));
                    img_ck.setImageResource(R.drawable.icon_awesome_check_circle);
                    img_next.setEnabled(true);
                    email.setBackgroundResource(R.drawable.solid_button_st);
                    img_ed.setImageResource(R.drawable.edittext_img);
                    img_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //아이디 액티비티에서 입력된 userID 값을 인텐트로 받아오고
                            Intent intent = getIntent();
                            userID = intent.getStringExtra("userID");

                            //받아온 id 값을 현재 email 값과 함께 비번 액티비티에 같이 넘겨줘야됨
                            Intent it = new Intent(register_email.this, register_pw.class);
                            it.putExtra("userEmail", userEmail);
                            it.putExtra("userID", userID);
                            startActivity(it);
                            }
                        });
                    }
                }
            });
        };
    }
