package com.viethcn.shopbanhang.Model;

public class Product {
    private  int masp;
    private  String tensp;
    private int soluong;
    private  int giaban;
    //
    public Product(int masp, String tensp, int soluong, int giaban) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.giaban = giaban;
    }
    public Product( String tensp, int soluong, int giaban) {
        this.tensp = tensp;
        this.soluong = soluong;
        this.giaban = giaban;
    }

    // getter setter
    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
}

