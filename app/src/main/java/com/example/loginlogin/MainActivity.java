package com.example.loginlogin;

import static android.media.CamcorderProfile.get;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class MainActivity extends AppCompatActivity {
    private String userID;
    ImageView jang, reservation_img ;
    FrameLayout reservation, recommend;
    /*
        private MyData[] mData = {
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박"),
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박"),
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박"),
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박"),
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박"),
                new MyData(R.drawable.homeicon,"사과"),
                new MyData(R.drawable.ticketicon2,"바나나"),
                new MyData(R.drawable.ticketicon,"포도"),
                new MyData(R.drawable.icon_action_favorite,"파인애플"),
                new MyData(R.drawable.icon_bookmark,"수박")
        };
        private ListView mList;
        private ListAdapter mAdapter;

     */
    private TextView tv, tv2, tv3;
    private String data;
    String dataJson = "";
    ArrayList<GetterJson> getterJsonArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recommend = findViewById(R.id.recommend);
        reservation = findViewById(R.id.reservation);

        reservation_img = findViewById(R.id.reservation_img);
        //jang = findViewById(R.id.jang);
        //tv = findViewById(R.id.tv_json);
        Intent it = getIntent();
        userID = it.getStringExtra("userID");

        //mList = (ListView) findViewById(R.id.list);
        //mAdapter = new ListAdapter(this, mData);
        //mList.setAdapter(mAdapter);



        /*
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
            public void onItemClick (AdapterView < ? > parent, View view, int position, long id){
                Toast.makeText(example.this, mData[position].name + " 선택!", Toast.LENGTH_SHORT).show();
            }
        });
         */




        /*
        Intent intent2 = new Intent(example.this, MapsActivity.class);

        intent2.putExtra("json",dataJson);
        startActivity(intent2);

         */

        //jang.setClipToOutline(true);      //이미지 테두리 둥굴게


        //reservation.setVisibility(View.GONE);
        reservation_img.setClipToOutline(true);
        dataJson = getJson();
        jsonData(dataJson);
        getterJsonArrayList = jsonParsing();
        //tv.setText(data);

        bind_main();
        bindList();
        bind2();
        bind3();
        bind4();
        bind5();

    }
    private void bind_main(){
        List<mainData2> rv_list = new ArrayList<>();
        rv_list.add(new mainData2(R.drawable.data3, getterJsonArrayList.get(2).getTitle()));
        rv_list.add(new mainData2(R.drawable.data4, getterJsonArrayList.get(3).getTitle()));
        rv_list.add(new mainData2(R.drawable.data5, getterJsonArrayList.get(4).getTitle()));

        RecyclerView rvmain = findViewById(R.id.rv_main);
        RecyclerViewAdapter2 adapter = new RecyclerViewAdapter2(rv_list);
        rvmain.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvmain.setLayoutManager(layoutManager);

    }

    private void bindList() {
        List<mainData> img_list= new ArrayList<>();
        img_list.add(new mainData(R.drawable.data1));
        img_list.add(new mainData(R.drawable.data2));
        img_list.add(new mainData(R.drawable.data3));




        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(img_list);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        //가로 간격 주기
        RecyclerDecoration_Height decoration_height = new RecyclerDecoration_Height(0);
        recyclerView.addItemDecoration(decoration_height);


    }

    private void bind2(){
        List<mainData> img_list2 = new ArrayList<>();
        img_list2.add(new mainData(R.drawable.data4));
        img_list2.add(new mainData(R.drawable.data5));
        img_list2.add(new mainData(R.drawable.data6));

        RecyclerView rv2 = findViewById(R.id.recycler_view2);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(img_list2);
        rv2.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(layoutManager);

    }
    private void bind3(){
        List<mainData> img_list3 = new ArrayList<>();
        img_list3.add(new mainData(R.drawable.data3));
        img_list3.add(new mainData(R.drawable.data2));
        img_list3.add(new mainData(R.drawable.data1));

        RecyclerView rv3 = findViewById(R.id.recycler_view3);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(img_list3);
        rv3.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv3.setLayoutManager(layoutManager);

    }

    private void bind4(){
        List<mainData> img_list4 = new ArrayList<>();
        img_list4.add(new mainData(R.drawable.data6));
        img_list4.add(new mainData(R.drawable.data5));
        img_list4.add(new mainData(R.drawable.data4));

        RecyclerView rv4 = findViewById(R.id.recycler_view4);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(img_list4);
        rv4.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv4.setLayoutManager(layoutManager);

    }
    private void bind5(){
        List<mainData> img_list5 = new ArrayList<>();
        img_list5.add(new mainData(R.drawable.data2));
        img_list5.add(new mainData(R.drawable.data3));
        img_list5.add(new mainData(R.drawable.data4));

        RecyclerView rv4 = findViewById(R.id.recycler_view5);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(img_list5);
        rv4.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv4.setLayoutManager(layoutManager);

    }



    public String jsonData(String jsondata){
        data = jsondata;

        return data;
    }

    private ArrayList<GetterJson> jsonParsing(){

        ArrayList<GetterJson> getjsondata = new ArrayList<GetterJson>();

        String jsonData = getJson();

        try {
            //JSONObject jsonObject= new JSONObject(jsonData);


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


                /*
                String titles = jo.getString("titles");
                String gallery = jo.getString("gallery");
                String dialogue = jo.getString("dialogue");
                String period = jo.getString("period");
                String time = jo.getString("time");
                String holiday = jo.getString("holiday");
                String pay = jo.getString("pay");
                String position = jo.getString("position");
                int Latitude = jo.getInt("Latitude");
                int longitude = jo.getInt("longitude");
                String url = jo.getString("url");
                */

                //json = titles+"\n"+gallery+"\n"+dialogue+"\n"+period+"\n"+time+"\n"+
                //        holiday+"\n"+pay+"\n"+position+"\n"+Latitude+"\n"+longitude+"\n"+url;
            }


            /*
            for (int i = 0; i < 6; i++) {


                //Exhibi exhibi = new Exhibi();


                exhibi.setTitles(jo.getString("titles"));
                exhibi.setDialogue(jo.getString("dialogue"));
                exhibi.setGallery(jo.getString("gallery"));


                String titles = jo.getString("titles");
                String  dialogue = jo.getString("dialogue");
                String position = jo.getString("position");


                JSONObject flag = jo.getJSONObject("flag");
                int aa = flag.getInt("aa");
                int bb = flag.getInt("bb");



                //s += "전시 제목 : "+titles+ "\n" +"전시내용 : " + dialogue +"\n"+"전시장 위치 : "+position+"\n" ;//데이터 가져오기
            */

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getjsondata;
    }




    public String getJson() {
        String jsonData ="";


        //json 파일 읽어와서 분석하기

        //assets폴더의 파일을 가져오기 위해
        //창고관리자(AssetManager) 얻어오기
        AssetManager assetManager = getAssets();

        //assets/ test.json 파일 읽기 위한 InputStream
        try {
            InputStream is = assetManager.open("Json/JsonData.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }

            jsonData = buffer.toString();

            //읽어온 json문자열 확인
            //tv.setText(jsonData);

            //json 분석
            //json 객체 생성
            //            JSONObject jsonObject= new JSONObject(jsonData);
            //            String name= jsonObject.getString("name");
            //            String msg= jsonObject.getString("msg");
            //
            //            tv.setText("이름 : "+name+"\n"+"메세지 : "+msg);

            //json 데이터가 []로 시작하는 배열일때..


        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public void mOnClick(View v){
        if(v.getId() == R.id.home){
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            i.putExtra("userID",userID);
            i.putExtra("json", jsonData(dataJson));
            startActivity(i);
        } else if(v.getId() == R.id.search){
            Intent intent1 = new Intent(MainActivity.this, search1.class);
            intent1.putExtra("userID",userID);
            intent1.putExtra("json", jsonData(dataJson));
            startActivity(intent1);
        } else if(v.getId() == R.id.ticket || v.getId() == R.id.ticket2){
            Intent in = new Intent(MainActivity.this, reservation_ticket.class);
            in.putExtra("userID",userID);
            in.putExtra("json", jsonData(dataJson));
            startActivity(in);
        }else if (v.getId() == R.id.position){
            Intent ie = new Intent(MainActivity.this, MapsActivity.class);
            ie.putExtra("userID",userID);
            ie.putExtra("json", jsonData(dataJson));
            startActivity(ie);
        } else if(v.getId() == R.id.profile_icon){
            Intent intent = new Intent(MainActivity.this, profile1.class);
            intent.putExtra("userID",userID);
            intent.putExtra("json", jsonData(dataJson));
            startActivity(intent);
        }

    }
}