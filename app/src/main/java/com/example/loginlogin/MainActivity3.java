package com.example.loginlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //bindList();
    }

    /*
    private void bindList() {
        ArrayList<Integer> imglist = new ArrayList<>();
        imglist.add(R.drawable.data1);
        imglist.add(R.drawable.data2);
        imglist.add(R.drawable.data3);
        imglist.add(R.drawable.data4);
        imglist.add(R.drawable.data5);
        imglist.add(R.drawable.data6);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imglist);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }
     */

}