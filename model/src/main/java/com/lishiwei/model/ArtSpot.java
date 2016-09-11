package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shiwei on 2016/9/11.
 */
public class ArtSpot implements Parcelable {
    /**
     * id : 201609051633131
     * name : 艺术现场名称2
     * detail : 详情详情详情详情详情详情详情详情
     * imageUrl : upload/201609051633131.png
     * createTime : 1473064393000
     * idStr : 201609051633131
     */

    private long id;
    private String name;
    private String detail;
    private String imageUrl;
    private long createTime;
    private String idStr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeString(this.imageUrl);
        dest.writeLong(this.createTime);
        dest.writeString(this.idStr);
    }

    public ArtSpot() {
    }

    protected ArtSpot(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.detail = in.readString();
        this.imageUrl = in.readString();
        this.createTime = in.readLong();
        this.idStr = in.readString();
    }

    public static final Parcelable.Creator<ArtSpot> CREATOR = new Parcelable.Creator<ArtSpot>() {
        @Override
        public ArtSpot createFromParcel(Parcel source) {
            return new ArtSpot(source);
        }

        @Override
        public ArtSpot[] newArray(int size) {
            return new ArtSpot[size];
        }
    };
}
