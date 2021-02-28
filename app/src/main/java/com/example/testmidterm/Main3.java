package com.example.testmidterm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Main3 extends AppCompatActivity {
    private ViewGroup mainLayout;
    private ImageView image;

    private int xDelta;
    private int yDelta;
    Button homeBtn,buttonMap ,buttonYoutube, buttonDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        buttonMap = findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Map point based on address
                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                // Or map point based on latitude/longitude
                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14");
                // z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });

        buttonYoutube = findViewById(R.id.buttonYoutube);
        buttonYoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String packageName = "com.google.android.youtube";
                startApp(packageName);
            }
        });

        buttonDate = findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String packageName = "com.google.android.calendar";
                startApp(packageName);
            }
        });

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                    Intent intent = new Intent(Main3.this,MainActivity.class);
                    startActivity(intent);
            }
        });
        mainLayout = (RelativeLayout) findViewById(R.id.main3);
        image = (ImageView) findViewById(R.id.image);
        image.setOnTouchListener(onTouchListener());

        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int x = (int) motionEvent.getRawX();
                int y = (int) motionEvent.getRawY();
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(Main3.this, "Move cat here"
                                , Toast.LENGTH_SHORT).show();
                        break;

                }
                int[] location = new int[2];
                image.getLocationOnScreen(location);
                image.setX(x/2);
                image.setY(y/2);
                return true;
            }
        });

    }
    public void startApp(String packageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(intent);
        } catch (NullPointerException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(intent);
        }
    }
    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int x = (int) motionEvent.getRawX();
                final int y = (int) motionEvent.getRawY();

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(Main3.this, "Cat Moving", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;

            }
        };
    }
}