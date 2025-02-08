package com.example.prm392_my_app;

import java.io.Serializable;

public class TraiCay implements Serializable {
    private String Ten;
    private String Mota;
    private int Hinh;

    // Constructor
    public TraiCay(String ten, String mota, int hinh) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
    }

    // Getter and Setter methods
    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
