package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class reservation_ticket extends AppCompatActivity {

    ImageView back;
    TextView tv_title, tv_period, tv_gallery;
    ArrayList<GetterJson> getterJsonArrayList = new ArrayList<GetterJson>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_ticket);


        tv_title = findViewById(R.id.tv_title);
        tv_period = findViewById(R.id.tv_period);
        tv_gallery = findViewById(R.id.tv_gallery);

        back = findViewById(R.id.img_back11);
        back.setOnClickListener(v -> onBackPressed());

        Intent i = getIntent();
        String s = i.getStringExtra("json");

        //list에 파싱한 거 담기
        getterJsonArrayList = jsonParsing(s);

        tv_title.setText(getterJsonArrayList.get(0).getTitle());
        tv_period.setText(getterJsonArrayList.get(0).getPeriod());
        tv_gallery.setText(getterJsonArrayList.get(0).getGallery());



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