package com.example.appfoododer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfoododer.databinding.ActivityFoodOrderBinding;

import java.util.ArrayList;

public class FoodOrder extends AppCompatActivity {
    ActivityFoodOrderBinding binding;
//    ImageView imgGioHang;
//    TextView txtSoLuong , txtMoney,txtThanks;
//      ListView lvSanPham;
//    Button btnOder;
    int dem = 0;
    int tien = 0;
    int vitri = -1;
    final int REQUEST_CODE = 123;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<Fooder> arrayList;
    ArrayList<Fooder> arrayListGioHang;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_food_order);
//        anhxa();
        arrayList = new ArrayList<>();
        arrayListGioHang = new ArrayList<>();
        arrayList.add(new Fooder("Pizza Panda",0));
        arrayList.add(new Fooder("KFC Super",0));
        arrayList.add(new Fooder("Bread Eggs",0));
        arrayList.add(new Fooder("Coca Cola",0));
        arrayList.add(new Fooder("Chicken super",0));
        arrayList.add(new Fooder("Cup Cake",0));
        adapter = new FoodAdapter(this,R.layout.layout_food,arrayList);

        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null) {
            arrayListGioHang = bundle1.getParcelableArrayList("data");
        }
        binding.lvSanPham.setAdapter(adapter);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();
        tien = sharedPreferences.getInt("saveMoney",0);
        dem = sharedPreferences.getInt("saveNumber",0);
        binding.txtSoLuong.setText(dem+"");

        binding.txtMoney.setText(tien+"$");
       
        binding.btnOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtThanks.setText("Thanks you! Your order is sent to restaurant !");
//                txtSoLuong.setText(0+"");
//                LuuSoLuong();
//                txtMoney.setText(0+"$");
//                LuuTien();
                editor = sharedPreferences.edit();
                editor.remove("saveMoney");
                editor.remove("saveNumber");
                editor.commit();

            }
        });
        binding.imgGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getBaseContext(), YourOder.class);
                    intent.putExtra("money",tien);
                    Bundle bundle = new Bundle();
                    if (bundle == null){
                        Toast.makeText(FoodOrder.this, "Đồ ăn chưa được oder ! ", Toast.LENGTH_SHORT).show();
                    }else {
                        bundle.putParcelableArrayList("data",arrayListGioHang);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        });

        binding.lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dem += 1;
                tien += 10;
                LuuSoLuong();
                binding.txtSoLuong.setText(dem+"");
                LuuTien();
                binding.txtMoney.setText(tien+"$");
                vitri = position;

                themvaogiohang(arrayList.get(position),arrayListGioHang);
            }
        });

    }

    private static void themvaogiohang(Fooder fooder , ArrayList<Fooder> arrayList1){



        for(int i=0;i<arrayList1.size();i++){
            if (arrayList1.get(i).getNameFood() ==fooder.getNameFood()){
                arrayList1.get(i).setSoluong(arrayList1.get(i).getSoluong()+1);
                return;
            }
        }
        arrayList1.add(fooder);
        arrayList1.get(arrayList1.size()-1).setSoluong(1);
    }
    private void LuuTien(){
        editor.putInt("saveMoney",tien);
        editor.commit();
    }
    private void LuuSoLuong(){
        editor.putInt("saveNumber",dem);
        editor.commit();
    }
//    private void anhxa() {
//        imgGioHang = (ImageView) findViewById(R.id.imgGioHang);
//        txtSoLuong = (TextView) findViewById(R.id.txtSoLuong);
//        txtMoney = (TextView) findViewById(R.id.txtMoney);
//        lvSanPham = (ListView) findViewById(R.id.lvSanPham);
//        btnOder = (Button) findViewById(R.id.btnOder);
//        txtThanks = (TextView) findViewById(R.id.txtThanks);
//    }
}