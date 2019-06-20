package com.example.modulmapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table students(student_id text primary key, password text)");
        db.execSQL("Create table client(password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists students");
    }
    //inserting in database
    public boolean insert(String student_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("student_id", student_id);
        contentValues.put("password", password);
        long ins = db.insert("students", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }
    //check if student already exixts
    public  boolean checkStudentID(String student_ID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from students where student_id = ?", new String[]{student_ID});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking the email and password from the database
    public Boolean checkLoginDetails(String student_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from students where student_id=? and password = ?", new String[]{student_id, password});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

}
