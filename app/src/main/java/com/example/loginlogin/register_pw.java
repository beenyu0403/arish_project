package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register_pw extends AppCompatActivity {
    ImageView img_next, img_back, pw_ck, pw_ck2, img_ed, img_ed_ck;
    EditText ed_pass, ed_pass_ck;
    TextView pw_notion, pw_notion2;
    public String userPassword, Password_Ck;
    boolean eye_img = true;
    boolean eye_img2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_pw);

        img_back = findViewById(R.id.img_back14);
        ed_pass = findViewById(R.id.sign_pw);
        ed_pass_ck = findViewById(R.id.sign_pw2);
        pw_notion = findViewById(R.id.pw_notion);
        pw_notion2 = findViewById(R.id.pw_notion2);
        img_next = findViewById(R.id.img_next3);
        pw_ck = findViewById(R.id.pw_eye);
        pw_ck2 = findViewById(R.id.pw_eye2);
        img_ed = findViewById(R.id.pw_Edit);
        img_ed_ck = findViewById(R.id.pw_edit_ck);


        //뒤로가기
        img_back.setOnClickListener(v -> onBackPressed() );

        //입력된 비밀번호 값 가져오기
        userPassword = ed_pass.getText().toString();
        Password_Ck = ed_pass_ck.getText().toString();


        //비밀번호 빈칸 여부

        ed_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void afterTextChanged(Editable editable) {
                userPassword = ed_pass.getText().toString();
                if(editable.length() >0 && userPassword.length()>0){
                                                //영어+숫자 포함 5-15자
                    if(!Pattern.matches("^([a-z].*[0-9])|([0-9].*[a-z]).{5,15}.$", userPassword) || userPassword.length() < 5){
                        pw_notion.setText("비밀번호 형식에 맞게 입력해주세요!!");
                        pw_notion.setTextColor(Color.parseColor("#FF0000"));
                        img_ed.setImageResource(R.drawable.edittext_red);
                        ed_pass_ck.setEnabled(false);
                        img_next.setEnabled(false);
                    }else if(Pattern.matches("^([a-z].*[0-9])|([0-9].*[a-z]).{5,15}.$", userPassword) && userPassword.length() >= 5){
                        img_ed.setImageResource(R.drawable.edittext_img);
                        pw_notion.setText("안전한 비밀번호입니다:)");
                        pw_notion.setTextColor(Color.parseColor("#8b00ff"));
                        img_next.setEnabled(false);
                        ed_pass_ck.setEnabled(true);

                    }
                }

            }
        });



        //비밀번호 일치 여부
        ed_pass_ck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userPassword = ed_pass.getText().toString();
                Password_Ck = ed_pass_ck.getText().toString();
                if (editable.length() > 0 && Password_Ck.length() > 0) {
                    if (!Password_Ck.equals(userPassword)) {
                        pw_notion2.setText("비밀번호가 일치하지 않습니다 !!");
                        img_ed_ck.setImageResource(R.drawable.edittext_red);
                        pw_notion2.setTextColor(Color.parseColor("#FF0000"));
                        img_next.setEnabled(false);     //"다음" 버튼 비활성화
                    } else if (Password_Ck.equals(userPassword)) {
                        pw_notion2.setText("비밀번호가 일치합니다:)");
                        img_ed_ck.setImageResource(R.drawable.edittext_img);
                        pw_notion2.setTextColor(Color.parseColor("#8b00ff"));
                        img_next.setEnabled(true);      //"다음" 버튼 활성화

                        //다음 버튼 눌렀을 때 실행될 것들들
                        img_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it = getIntent();
                                String userID = it.getStringExtra("userID");
                                String userEmail = it.getStringExtra("userEmail");
                                String userPassword = ed_pass.getText().toString();

                                //입력된 것들 받아오기
                                Response.Listener<String> responseListener = new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            boolean success = jsonObject.getBoolean("success");
                                            //php 구문에 response를 success 형태로 선언했음.
                                            //success가 true or False인지
                                            //회원가입 성공인지 실패인지를 알려주는 내용

                                            if (success) {    //회원가입에 성공한 경우
                                                Intent intent = new Intent(register_pw.this, register_end.class);
                                                Toast.makeText(getApplicationContext(), "회원가입에 성공하였습니다", Toast.LENGTH_SHORT).show();
                                                startActivity(intent);

                                            } else {         //회원가입에 실패한 경우
                                                Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다ㅠㅠ", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                RegisterRequest registerRequest = new RegisterRequest(userID, userEmail, userPassword, responseListener);
                                RequestQueue queue = Volley.newRequestQueue(register_pw.this);
                                queue.add(registerRequest);
                            }
                        });
                    }
                }
            }
        });


    }


    public void mOnClick(View v){
        if(v.getId() == R.id.pw_eye){
            ShowPassword(ed_pass);
            if (eye_img == true) {
                pw_ck.setImageResource(R.drawable.signuppwicon1);
                eye_img = false;
            }else if(eye_img == false){
                pw_ck.setImageResource(R.drawable.signuppwicon2);
                eye_img = true;
            }
        }else if(v.getId() == R.id.pw_eye2){
            ShowPassword(ed_pass_ck);
            if (eye_img2 == true) {
                pw_ck2.setImageResource(R.drawable.signuppwicon1);
                eye_img2 = false;
            }else if(eye_img2 == false){
                pw_ck2.setImageResource(R.drawable.signuppwicon2);
                eye_img2 = true;
            }
        }
    }





    void ShowPassword(EditText password){
        if(password.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()){
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        }else if(password.getTransformationMethod() != HideReturnsTransformationMethod.getInstance()){
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }

}
