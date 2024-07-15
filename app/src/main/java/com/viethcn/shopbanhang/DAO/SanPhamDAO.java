package com.viethcn.shopbanhang.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.viethcn.shopbanhang.Model.Product;
import com.viethcn.shopbanhang.database.DbHelper;

import java.util.ArrayList;

public class SanPhamDAO {
    private DbHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    // Lấy danh sách sản phẩm
    public ArrayList<Product> getDS() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ArrayList<Product> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM sanpham", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    list.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            sqLiteDatabase.close();
        }
        return list;
    }

    // Thêm sản phẩm mới
    public boolean themSPMoi(Product product) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        boolean result = false;

        ContentValues contentValues = new ContentValues();
        contentValues.put("tensp", product.getTensp());
        contentValues.put("giaban", product.getGiaban());
        contentValues.put("soluong", product.getSoluong());

        long check = sqLiteDatabase.insert("sanpham", null, contentValues);
        if (check != -1) {
            result = true;
        }

        sqLiteDatabase.close();
        return result;
    }
    // Chinh sua san pham
    public boolean chinhSuaSP(Product product){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tensp", product.getTensp());
        contentValues.put("giaban", product.getGiaban());
        contentValues.put("soluong", product.getSoluong());

        int check  = sqLiteDatabase.update("SANPHAM",contentValues,"masp = ?",new String[]{String.valueOf(product.getMasp())});
        if(check <= 0) return false;
        return true;
    }

    public boolean XoaSP(int masp){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        int check = sqLiteDatabase.delete("SANPHAM","masp = ?",new String[]{String.valueOf(masp)});
        if (check <= 0) return false;
        return true;

    }
}

