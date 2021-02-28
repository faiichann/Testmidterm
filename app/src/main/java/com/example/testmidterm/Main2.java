package com.example.testmidterm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {
    TextView textName;
    Button bgColor, nextBtn ;
    ConstraintLayout layout;
    private ImageButton imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textName = findViewById(R.id.textName);
        textName.setText("Welcome :"+getIntent().getExtras().getString("username"));

        layout= findViewById(R.id.layout);
        bgColor = findViewById(R.id.bgColor);
        bgColor.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(bgColor.getText() == "Dark theme"){
                    layout.setBackgroundResource(R.color.Darkred);
                    bgColor.setText("Basic theme");
                }else {
                    layout.setBackgroundResource(R.color.white);
                    bgColor.setText("Dark theme");
                }
            }
        });
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                    Intent intent = new Intent(Main2.this,Main3.class);
                    startActivity(intent);
                }
        });

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPic_1();
            }
        });
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_2();
            }
        });
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_3();
            }
        });
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_4();
            }
        });
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_5();
            }
        });
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_6();
            }
        });
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_7();
            }
        });
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_8();
            }
        });
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                openPic_9();
            }
        });
    }
    public void openPic_1(){
        Intent intent = new Intent(this, Pic_1.class);
        startActivity(intent);
    }
    public void openPic_2(){
        Intent intent = new Intent (this, Pic_2.class);
        startActivity(intent);
    }
    public void openPic_3(){
        Intent intent = new Intent (this, Pic_3.class);
        startActivity(intent);
    }
    public void openPic_4(){
        Intent intent = new Intent (this, Pic_4.class);
        startActivity(intent);
    }
    public void openPic_5(){
        Intent intent = new Intent (this, Pic_5.class);
        startActivity(intent);
    }
    public void openPic_6(){
        Intent intent = new Intent (this, Pic_6.class);
        startActivity(intent);
    }
    public void openPic_7(){
        Intent intent = new Intent (this, Pic_7.class);
        startActivity(intent);
    }
    public void openPic_8(){
        Intent intent = new Intent (this, Pic_8.class);
        startActivity(intent);
    }
    public void openPic_9(){
        Intent intent = new Intent (this, Pic_9.class);
        startActivity(intent);
    }
}