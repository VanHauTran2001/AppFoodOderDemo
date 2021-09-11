package com.example.appfoododer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fooder implements Parcelable {
    private String nameFood;
    private int soluong;

    public Fooder(String nameFood, int soluong) {
        this.nameFood = nameFood;
        this.soluong = soluong;
    }

    public Fooder() {

    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public static Creator<Fooder> getCREATOR() {
        return CREATOR;
    }

    protected Fooder(Parcel in) {
        nameFood = in.readString();
        soluong = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameFood);
        dest.writeInt(soluong);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fooder> CREATOR = new Creator<Fooder>() {
        @Override
        public Fooder createFromParcel(Parcel in) {
            return new Fooder(in);
        }

        @Override
        public Fooder[] newArray(int size) {
            return new Fooder[size];
        }
    };
}
