package com.example.modulmapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class studentLogin extends AppCompatActivity {

    EditText loginStudentID, loginPassword;
    Button login_btn, studentsignupBtn;
    DatabaseHelper db;
    Boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        db = new DatabaseHelper(this);
        loginStudentID = (EditText)findViewById(R.id.loginStudentID);
        loginPassword = (EditText)findViewById(R.id.loginPassword);
        login_btn = (Button) findViewById(R.id.login_btn);
        studentsignupBtn = (Button)findViewById(R.id.studentsignupBtn);

        studentsignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentLogin.this, studentRegister.class);
                startActivity(i);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_student_ID = loginStudentID.getText().toString();
                String login_password = loginPassword.getText().toString();
                Boolean checkLogin = db.checkLoginDetails(login_student_ID, login_password);
                if(checkLogin == true){
                    admin = false;
                    Intent i = new Intent(studentLogin.this, dashboard.class);
                    i.putExtra("Admin", admin);
                    startActivity(i);
                }
                else if((login_student_ID.equals("WintecClient")) && (login_password.equals("wintec@123"))){
                    admin = true;
                    Intent i = new Intent(studentLogin.this, dashboard.class);
                    i.putExtra("Admin", admin);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
