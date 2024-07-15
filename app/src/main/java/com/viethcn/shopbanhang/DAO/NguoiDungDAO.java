package com.viethcn.shopbanhang.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.viethcn.shopbanhang.database.DbHelper;

public class NguoiDungDAO {
    private DbHelper dbHelper;
    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    // Login
    public boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT*FROM NGUOIDUNG WHERE tendangnhap = ? AND matkhau= ?",new String[]{username,password});
        return cursor.getCount() > 0;
    }
    // Register
    public boolean Register (String usernane, String password, String hoten){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tendangnhap",usernane);
        contentValues.put("matkhau", password);
        contentValues.put("hoten",hoten);

        long check = sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);
        return check != -1;
    }
}
