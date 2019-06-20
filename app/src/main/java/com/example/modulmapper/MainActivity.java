package com.example.modulmapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button student_btn, client_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_btn = (Button)findViewById(R.id.student_btn);
        client_btn = (Button)findViewById(R.id.client_btn);

        student_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, studentLogin.class);
                startActivity(i);
            }
        });
        client_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, clientLogin.class);
                startActivity(i);
            }
        });
    }
}
