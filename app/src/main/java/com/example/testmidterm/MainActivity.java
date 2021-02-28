package com.example.testmidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<Main> extends AppCompatActivity {

    EditText editTextUser , editTextPass ;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPass = findViewById(R.id.editTextPass);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0)
            {
                String uname  = editTextUser.getText().toString();
                String pass = editTextPass.getText().toString();
                if(uname.equals("admin") && pass.equals("1234"))
                {
                    Intent intent = new Intent(MainActivity.this,Main2.class);
                    intent.putExtra("username",editTextUser.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Username password pair.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}