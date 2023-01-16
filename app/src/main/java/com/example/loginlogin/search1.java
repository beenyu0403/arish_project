package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class search1 extends AppCompatActivity {

    ImageView back_btn, seoul;
    TextView json_text;
    String data;
    float latitude, longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search1);

        json_text = findViewById(R.id.json_t);
        seoul = findViewById(R.id.seoul_sc);
        back_btn = findViewById(R.id.img_backnn);
        back_btn.setOnClickListener(v -> onBackPressed());
        ArrayList<GetterJson> getterJsonArrayList = new ArrayList<GetterJson>();

        seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(search1.this, hhh.class);
                startActivity(intent);
            }
        });

//json 파일 넘겨받기
        //Intent i = getIntent();
        //String s = i.getStringExtra("json");

        //list에 파싱한 거 담기
        //getterJsonArrayList = jsonParsing(s);

        //위도+경도 값 가져오기
        //latitude = Float.parseFloat(getterJsonArrayList.get(0).getLatitude());


        //json_text.setText("위도 : "+integer);

        /*
            ArrayList<Float> latitudeList = new ArrayList<Float>();x
            ArrayList<Float> longitudeList = new ArrayList<Float>();

            for(int j=0; j<getterJsonArrayList.toArray().length; j++){

                latitudeList.add(latitude);
                longitudeList.add(longitude);
            }


         */


        //int latitude[] = Integer.parseInt(getterJsonArrayList.get(0).getLatitude());


    }


    public void mmOnClick(View v){
        Intent i ;

        if(v.getId() == R.id.seoul_sc){
            i = new Intent(search1.this, hhh.class);
            startActivity(i);

        }else if(v.getId() == R.id.incheon){
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.gwangju) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.daejeon) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.daegu) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.busan) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.jeju) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.gangwon) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.allc) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.wholek) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw1) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw2) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw3) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw4) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw5) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw6) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw7) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw8) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw9) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }else if(v.getId() == R.id.keyw10) {
            i = new Intent(search1.this, hhh.class);
            startActivity(i);
        }
    }


    private ArrayList<GetterJson> jsonParsing(String data){

        ArrayList<GetterJson> getjsondata = new ArrayList<GetterJson>();

        String jsonData = data ;

        try {

            JSONArray jsonArray = new JSONArray(jsonData);

            for(int i=0; i<jsonData.length(); i++) {
                GetterJson getterJson = new GetterJson();
                JSONObject jo = jsonArray.getJSONObject(i);

                getterJson.setTitle(jo.getString("titles"));
                getterJson.setGallery(jo.getString("gallery"));
                getterJson.setDialogue(jo.getString("dialogue"));
                getterJson.setPeriod(jo.getString("period"));
                getterJson.setTime(jo.getString("time"));
                getterJson.setHoliday(jo.getString("holiday"));
                getterJson.setPay(jo.getString("pay"));
                getterJson.setJsonPosition(jo.getString("position"));
                getterJson.setLatitude(jo.getString("Latitude"));
                getterJson.setLongitude(jo.getString("longitude"));
                getterJson.setUrl(jo.getString("url"));


                getjsondata.add(getterJson);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getjsondata;
    }


}