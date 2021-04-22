package com.example.android_practice6_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShowCart extends AppCompatActivity {

    ListView lvCart;
    Button btnBack1,btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        lvCart = findViewById(R.id.lvCart);
        btnBack1 = findViewById(R.id.btnBack1);
        btnConfirm = findViewById(R.id.btnConfirm);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.borrowList);
        lvCart.setAdapter(aa);
        lvCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.borrowList.remove(position);
                lvCart.setAdapter(aa);
            }
        });

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.borrowList.clear();
                lvCart.setAdapter(aa);
            }
        });

    }
}