package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shiwei on 2016/9/11.
 */
public  class ArtistSetBean implements Parcelable {
    private long id;
    private String artistChineseName;
    private String artistEnglishName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtistChineseName() {
        return artistChineseName;
    }

    public void setArtistChineseName(String artistChineseName) {
        this.artistChineseName = artistChineseName;
    }

    public String getArtistEnglishName() {
        return artistEnglishName;
    }

    public void setArtistEnglishName(String artistEnglishName) {
        this.artistEnglishName = artistEnglishName;
    }

    public ArtistSetBean(String artistEnglishName, String artistChineseName, long id) {
        this.artistEnglishName = artistEnglishName;
        this.artistChineseName = artistChineseName;
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.artistChineseName);
        dest.writeString(this.artistEnglishName);
    }

    protected ArtistSetBean(Parcel in) {
        this.id = in.readLong();
        this.artistChineseName = in.readString();
        this.artistEnglishName = in.readString();
    }

    public static final Parcelable.Creator<ArtistSetBean> CREATOR = new Parcelable.Creator<ArtistSetBean>() {
        @Override
        public ArtistSetBean createFromParcel(Parcel source) {
            return new ArtistSetBean(source);
        }

        @Override
        public ArtistSetBean[] newArray(int size) {
            return new ArtistSetBean[size];
        }
    };
}