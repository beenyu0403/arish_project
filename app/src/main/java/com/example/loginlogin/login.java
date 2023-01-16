package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
    private ImageView img_back, save_id, auto_login;
    private EditText id, pass;
    private Button btnLogin, btn_auto;
    private TextView login_btn;
    String userID, userPass, login_id, login_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img_back = findViewById(R.id.img_back4);
        id = findViewById(R.id.ed_id);
        pass = findViewById(R.id.ed_pass);
        login_btn = findViewById(R.id.log_btn);
        btn_auto = findViewById(R.id.login_button3);

        userID = id.getText().toString();
        userPass = pass.getText().toString();


        img_back.setOnClickListener(v -> onBackPressed() );
/*
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);

        login_id = sharedPreferences.getString("input_id",null);
        login_pw = sharedPreferences.getString("input_pw", null);

        btn_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //한번이라도 로그인을 했던 사람
                if (login_id != null && login_pw != null) {
                    if (login_id.equals(userID) && login_pw.equals(userPass)) {
                        Toast.makeText(login.this, login_id + "님 자동 로그인 입니다!", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(login.this, MainActivity.class);
                        startActivity(it);
                    }

                    //한번도 로그인 안 한 사람
                } else if (login_id == null && login_pw == null) {

                    if (id.equals(userID) && pass.equals(userPass)) {
                        SharedPreferences.Editor autoLogin = sharedPreferences.edit();

                        autoLogin.putString("input_id", userID);
                        autoLogin.putString("input_pw", userPass);

                        autoLogin.commit();
                        Toast.makeText(login.this, userID + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(login.this, MainActivity.class);
                        startActivity(it);

                    }
                }
            }
        });
*/


        //로그인 버튼 클릭 시 수행
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userID = id.getText().toString();
                userPass = pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            //php 구문에 response를 success 형태로 선언했음.
                            //success가 true or False인지
                            //로그인인 성공인지 실패인지를 알려주는 내용

                           if(success){    //로그인에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");
                                if(!userID.equals("www00")){
                                    Toast.makeText(getApplicationContext(),userID+"님 반갑습니다!! ",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),"관리자 님 반갑습니다:) ",Toast.LENGTH_SHORT).show();
                                }
                                Intent intent = new Intent(login.this, MainActivity.class);
                                intent.putExtra("userID",userID);
                                //intent.putExtra("userPass",userPass);
                                startActivity(intent);
                            }else {         //로그인에 실패한 경우
                                //notion.setText("존재하지 않은 아이디 혹은 비밀번호가 일치하지 않습니다.");
                                //notion.setTextColor(Color.parseColor("#FF0000"));
                                Toast.makeText(getApplicationContext(),"존재하지 않은 아이디 혹은 비밀번호가 맞지 않습니다",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(login.this);
                queue.add(loginRequest);
            }
        });
    }



}