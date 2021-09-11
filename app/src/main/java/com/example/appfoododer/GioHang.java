package com.example.appfoododer;

import android.os.Parcelable;

public class GioHang {
    private String tenMonAn;

    public GioHang(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }
}