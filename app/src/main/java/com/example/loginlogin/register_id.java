package com.example.loginlogin;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class register_id extends AppCompatActivity {

    ImageView img_back, img_next, img_ck, id_edit;
    EditText id;
    TextView id_notion;
    String userID;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_id);


        //뒤로 가기 버튼
        img_back = findViewById(R.id.img_back2);
        img_next = findViewById(R.id.img_next);
        img_ck = findViewById(R.id.img_ck);
        id = findViewById(R.id.sign_ID);
        id_notion = findViewById(R.id.id_notion);
        id_edit = findViewById(R.id.id_edit);

        img_back.setOnClickListener(v -> onBackPressed());

        //setImage.setImageResource(R.drawable.nope);

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userID = id.getText().toString();
                if (validate)
                    return;
                if (editable.length() > 0 && userID.length() > 0) {
                    if (!Pattern.matches("^([a-z].*[0-9])|([0-9].*[a-z])*$", userID) || userID.length() < 3) {
                        id_notion.setText("아이디 형식에 맞게 입력해주세요\n(영문자+숫자 3자 이상)");
                        id_notion.setTextColor(Color.parseColor("#FF0000"));
                        img_next.setEnabled(false);
                    } else if (Pattern.matches("^([a-z].*[0-9])|([0-9].*[a-z])*$", userID) && userID.length() >= 3) {
                        id_notion.setText("아이디 중복체크를 해주세요!");
                        img_next.setEnabled(false);
                        img_ck.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String userID = id.getText().toString();
                                if(validate){return ;}

                                Response.Listener<String> responseListener = new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            boolean success = jsonObject.getBoolean("success");
                                            //php 구문에 response를 success 형태로 선언했음.
                                            //success가 true or False인지

                                            if (success) {    //사용가능한 아이디일 경우
                                                id_notion.setText("사용할 수 있는 아이디입니다.\n(바꾸려면 뒤로가기 해주세요!)");
                                                id_notion.setTextColor(Color.parseColor("#8b00ff"));
                                                id.setEnabled(false);
                                                img_next.setEnabled(true);
                                                validate=true;
                                                id_edit.setImageResource(R.drawable.edittext_img);
                                                img_ck.setImageResource(R.drawable.icon_awesome_check_circle);

                                            }else {
                                                id_notion.setText("사용할 수 없는 아이디입니다.");
                                                id_notion.setTextColor(Color.parseColor("red"));
                                                id_edit.setImageResource(R.drawable.edittext_red);
                                                img_next.setEnabled(false);
                                                return ;
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                                RequestQueue queue = Volley.newRequestQueue(register_id.this);
                                queue.add(validateRequest);

                            }
                        });

                    }
                }

            }
        });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = id.getText().toString();

                if(!validate){
                    return ;

                }else if(validate){
                    Intent it = new Intent(register_id.this, register_email.class);
                    it.putExtra("userID",userID);
                    startActivity(it);
                    return ;
                }

            }
        });
    }
}