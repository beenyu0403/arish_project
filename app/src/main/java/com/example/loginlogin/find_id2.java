package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class find_id2 extends AppCompatActivity {
    Button ck;
    TextView id;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_id2);


        //id = findViewById(R.id.find_userID);
        ck = findViewById(R.id.ck_btn3);
        back = findViewById(R.id.img_back6);
        back.setOnClickListener(v -> onBackPressed() );

        Intent it = getIntent();
        String userEmail = it.getStringExtra("userEmail");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    //php 구문에 response를 success 형태로 선언했음.
                    //success가 true or False인지

                    if (success) {    //사용가능한 아이디일 경우
                        id.setText("사용할 수 있는 아이디입니다.\n(바꾸려면 뒤로가기 해주세요!)");
                        id.setEnabled(false);
                        ck.setEnabled(true);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        ValidateRequest validateRequest = new ValidateRequest(userEmail, responseListener);
        RequestQueue queue = Volley.newRequestQueue(find_id2.this);
        queue.add(validateRequest);

    }
    public void mOnClick(View v){
        if(v.getId() == R.id.ck_btn3){
            Intent it = new Intent(find_id2.this, login.class);
            startActivity(it);
        }

    }

}