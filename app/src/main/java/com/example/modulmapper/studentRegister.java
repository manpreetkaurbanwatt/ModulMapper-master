package com.example.modulmapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class studentRegister extends AppCompatActivity {

    DatabaseHelper db;

    EditText student_id, password, confirm_password;
    Button register_btn, login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        db = new DatabaseHelper(this);

        student_id = (EditText)findViewById(R.id.student_ID);
        password = (EditText)findViewById(R.id.password);
        confirm_password = (EditText)findViewById(R.id.confirm_password);
        register_btn = (Button) findViewById(R.id.register_btn);
        login_btn = (Button) findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(studentRegister.this, studentLogin.class);
                startActivity(i);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = student_id.getText().toString();
                String s2 = password.getText().toString();
                String s3 = confirm_password.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)) {
                        Boolean checkStudentID = db.checkStudentID(s1);
                        if (checkStudentID == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Student ID already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
