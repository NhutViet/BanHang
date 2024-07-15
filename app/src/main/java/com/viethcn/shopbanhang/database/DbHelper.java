package com.viethcn.shopbanhang.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AND102";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng người dùng
        String createNguoiDungTable = "CREATE TABLE nguoidung (" +
                "tendangnhap TEXT PRIMARY KEY, " +
                "matkhau TEXT, " +
                "hoten TEXT" +
                ")";
        db.execSQL(createNguoiDungTable);

        // Tạo bảng sản phẩm
        String createSanPhamTable = "CREATE TABLE sanpham (" +
                "masp INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tensp TEXT, " +
                "giaban INTEGER, " +
                "soluong INTEGER" +
                ")";
        db.execSQL(createSanPhamTable);

        // Chèn dữ liệu mẫu vào bảng người dùng
        String insertNguoiDung = "INSERT INTO nguoidung (tendangnhap, matkhau, hoten) VALUES ('Baogt', '123', 'TranGia')";
        db.execSQL(insertNguoiDung);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Xóa bảng cũ nếu tồn tại
            db.execSQL("DROP TABLE IF EXISTS nguoidung");
            db.execSQL("DROP TABLE IF EXISTS sanpham");
            // Tạo lại bảng
            onCreate(db);
        }
    }
}
