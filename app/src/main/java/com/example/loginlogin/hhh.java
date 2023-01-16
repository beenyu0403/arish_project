package com.example.loginlogin;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class hhh extends AppCompatActivity{

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
    setContentView(R.layout.hhh);


    back = findViewById(R.id.img_backnn2);
    back.setOnClickListener(v -> onBackPressed());

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
    final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product(R.drawable.data1));
        adapter.addItem(new Product(R.drawable.data2));
        adapter.addItem(new Product(R.drawable.data3));
        adapter.addItem(new Product(R.drawable.data4));
        adapter.addItem(new Product(R.drawable.data5));
        adapter.addItem(new Product(R.drawable.data6));


        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
        @Override
        public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
            Product item = adapter.getItem(position);
            Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +
                    "\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
        }
    });

}
}
