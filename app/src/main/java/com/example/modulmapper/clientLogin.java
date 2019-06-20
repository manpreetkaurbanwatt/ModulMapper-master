package com.example.modulmapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

import javax.xml.namespace.NamespaceContext;

public class clientLogin extends AppCompatActivity {

    EditText clientPassword, client_username;
    Button clientLogin_btn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        clientPassword = (EditText)findViewById(R.id.clientPassword);
        client_username = (EditText)findViewById(R.id.client_username);
        clientLogin_btn = (Button)findViewById(R.id.clientLogin_btn);

        clientLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(client_username.getText().toString(), clientPassword.getText().toString());
            }
        });

    }
    public void validate(String username, String password){
        if((username.equals("WintecClient")) && (password.equals("wintec@123"))){
            boolean admin = true;
            Intent i = new Intent(clientLogin.this, ClientDashboard.class);
            i.putExtra("admin", admin);
            startActivity(i);
        }
        else{
            Toast.makeText(getApplicationContext(), "Details did not match", Toast.LENGTH_SHORT).show();
        }
    }
}
