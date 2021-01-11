package com.example.examregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "registration.db";
    public static final int VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE admin(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,password TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,password TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE registration(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT,units TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS student");
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS admin");
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", password);
        long res = db.insert("student", null, values);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password) {

        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username" + "=?" + "and " + "password" + "=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("student", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public long addAdmin(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", password);
        long res = db.insert("admin", null, values);
        db.close();
        return res;
    }

    public boolean checkAdmin(String username, String password) {

        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username" + "=?" + "and " + "password" + "=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("admin", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public long addnewRegistration(String regno, String units) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", regno);
        values.put("units", units);
        long res = db.insert("registration", null, values);
        db.close();
        return res;
    }

    public boolean checkforstudentregistration(String username) {

        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username" + "=?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query("registration", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getStudentsUnits() {
        ArrayList<String> list = new ArrayList<>();

        String sql = "select * from registration";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
//            int id = cursor.getInt(cursor.getColumnIndex("id"));
//            String us = cursor.getString(cursor.getColumnIndex("username"));
                String un = cursor.getString(cursor.getColumnIndex("units"));

//            list.add(String.valueOf(id));
//            list.add(us);
                list.add(un);
            }while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        db.close();
        return list;
    }
}
