package com.example.android_practice6_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetail extends AppCompatActivity {

    TextView tvTitle, tvPublisher;
    ImageView imgBook;
    EditText etDescription;
    Button btnBack, btnBorrow, btnShowCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvPublisher = findViewById(R.id.tvPublisher);
        imgBook = findViewById(R.id.imgBook);
        etDescription = findViewById(R.id.etDescription);
        btnBack = findViewById(R.id.btnBack);
        btnBorrow = findViewById(R.id.btnBorrow);
        btnShowCart = findViewById(R.id.btnShowCart);

        tvTitle.setText(MainActivity.selectedBook.getTitle());
        tvPublisher.setText(MainActivity.selectedBook.getPublisher());
        etDescription.setText(MainActivity.selectedBook.getDescription());

        int imgBookID = getResources().getIdentifier(MainActivity.selectedBook.getImage(),"mipmap",getPackageName());
        imgBook.setImageResource(imgBookID);

        btnBack.setOnClickListener(new ButtonEvents());
        btnBorrow.setOnClickListener(new ButtonEvents());
        btnShowCart.setOnClickListener(new ButtonEvents());
    }

    private class ButtonEvents implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnBack){
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            } else if(v.getId() == R.id.btnBorrow){
                if(MainActivity.borrowList.size() < 5){
                    boolean flag = false;
                    for(String name:MainActivity.borrowList){
                        if(name.equalsIgnoreCase(MainActivity.selectedBook.getTitle())){
                            flag = true;
                        }
                    }
                    if(!flag){
                        MainActivity.borrowList.add(MainActivity.selectedBook.getTitle());
                    } else{
                        Toast.makeText(getBaseContext(),"This book is already added!",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(),"You can not added more than 5 books",Toast.LENGTH_SHORT).show();
                }
            } else {
                Intent intent = new Intent(getBaseContext(),ShowCart.class);
                startActivity(intent);
            }
        }
    }

}