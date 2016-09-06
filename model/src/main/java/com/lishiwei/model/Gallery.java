package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lishiwei on 16/5/21.
 */
public class Gallery implements Parcelable {
    String id;

    public Gallery(String id, String chineseName, String englishName, String location) {
        this.id = id;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.location = location;
    }

    String chineseName;
    String englishName;
    String location;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getChineseName() {

        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.chineseName);
        dest.writeString(this.englishName);
        dest.writeString(this.location);
    }

    protected Gallery(Parcel in) {
        this.chineseName = in.readString();
        this.englishName = in.readString();
        this.location = in.readString();
    }

    public static final Creator<Gallery> CREATOR = new Creator<Gallery>() {
        @Override
        public Gallery createFromParcel(Parcel source) {
            return new Gallery(source);
        }

        @Override
        public Gallery[] newArray(int size) {
            return new Gallery[size];
        }
    };
}
