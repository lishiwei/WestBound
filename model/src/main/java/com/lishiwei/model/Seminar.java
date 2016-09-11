package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
/**
 * Created by lishiwei on 16/8/17.
 */
public class Seminar  implements Parcelable {
    String id;

    String date;
    String weekday;
    String status;

    String guest;
    String time;
    /**
     * name : 论坛名称
     * stratTime : 2016-09-05
     * time : 1:30am-3:00pm
     * location : 地址地址地址
     * seminarImgUrl : upload/201609051513261.png
     * createTime : 1473059606000
     * statusStr : 西岸论坛
     * idStr : 201609051513261
     * createTimeStr : 3小时 前
     */

    @SerializedName("name")
    private String title;
    @SerializedName("stratTime")
    private String startTime;
    private String location;
    private String seminarImgUrl;
    private long createTime;
    private String statusStr;
    private String idStr;
    private String createTimeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.date);
        dest.writeString(this.weekday);
        dest.writeString(this.status);
        dest.writeString(this.title);
        dest.writeString(this.guest);
        dest.writeString(this.time);
    }

    public Seminar(String id, String date, String weekday, String status, String url, String title, String guest, String time) {
        this.id = id;
        this.date = date;
        this.weekday = weekday;
        this.status = status;
        this.title = title;
        this.guest = guest;
        time = time;
    }

    public Seminar() {
    }

    protected Seminar(Parcel in) {
        this.id = in.readString();
        this.date = in.readString();
        this.weekday = in.readString();
        this.status = in.readString();
        this.title = in.readString();
        this.guest = in.readString();
        this.time = in.readString();
    }

    public static final Creator<Seminar> CREATOR = new Creator<Seminar>() {
        @Override
        public Seminar createFromParcel(Parcel source) {
            return new Seminar(source);
        }

        @Override
        public Seminar[] newArray(int size) {
            return new Seminar[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeminarImgUrl() {
        return seminarImgUrl;
    }

    public void setSeminarImgUrl(String seminarImgUrl) {
        this.seminarImgUrl = seminarImgUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", weekday='" + weekday + '\'' +
                ", status='" + status + '\'' +
                ", guest='" + guest + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                ", location='" + location + '\'' +
                ", seminarImgUrl='" + seminarImgUrl + '\'' +
                ", createTime=" + createTime +
                ", statusStr='" + statusStr + '\'' +
                ", idStr='" + idStr + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                '}';
    }
}
