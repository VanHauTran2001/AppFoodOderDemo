package com.example.appfoododer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appfoododer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    EditText edtUser , edtPassword;
//    Button btnLogin;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        edtUser = (EditText) findViewById(R.id.edtUser);
//        edtPassword = (EditText) findViewById(R.id.edtPassword);
//        btnLogin = (Button) findViewById(R.id.btnLogin);
        binding.edtUser.setText("Username");
        binding.edtPassword.setText("Password");
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),FoodOrder.class));
            }
        });
    }
}