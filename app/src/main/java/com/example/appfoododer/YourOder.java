package com.example.appfoododer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class YourOder extends AppCompatActivity {
    TextView txtTongTien;
    ImageView imgReturn;
    ArrayList<Fooder> gioHangArrayList;
    ListView lvGiohang;
    GioHangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_oder);
        imgReturn = (ImageView) findViewById(R.id.imgReturn);
        txtTongTien = (TextView) findViewById(R.id.txtTongTien);
        lvGiohang = (ListView) findViewById(R.id.lvGioHang);
        gioHangArrayList = new ArrayList<>();
        Intent intent = getIntent();
        int money = intent.getIntExtra("money",0);
        txtTongTien.setText(money+"$");
        Bundle bundle = getIntent().getExtras();
        gioHangArrayList = bundle.getParcelableArrayList("data");
        adapter = new GioHangAdapter(this,R.layout.activity_gio_hang,gioHangArrayList);
        lvGiohang.setAdapter(adapter);

        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getBaseContext(),FoodOrder.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("data",gioHangArrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}