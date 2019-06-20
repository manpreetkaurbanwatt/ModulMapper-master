package com.example.modulmapper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class modules extends AppCompatActivity {

    boolean admin;
    String pathway;
    String ifAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Bundle data = getIntent().getExtras();
        if(data==null){
            return;
        }

        admin = data.getBoolean("admin");
        pathway = data.getString("pathway");

        TextView pathwayView = findViewById(R.id.pathwayView);
        pathwayView.setText(pathway);
        TextView adminView = findViewById(R.id.adminView);
        if(admin == true) {
            ifAdmin = "admin";
        } else if(admin == false) {
            ifAdmin = "student";
        }
        adminView.setText(ifAdmin);


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



    }

}
