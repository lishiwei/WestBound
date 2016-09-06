package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by lishiwei on 16/8/17.
 */
public class Seminar  implements Parcelable {
    String id;

    String date;
    String weekday;
    String status;
    String Url;
    String title;
    String guest;
    String Time;

    @Override
    public String toString() {
        return "Seminar{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", weekday='" + weekday + '\'' +
                ", status='" + status + '\'' +
                ", Url='" + Url + '\'' +
                ", title='" + title + '\'' +
                ", guest='" + guest + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
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
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {

        this.Url = url;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;

    }


    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
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
        dest.writeString(this.Url);
        dest.writeString(this.title);
        dest.writeString(this.guest);
        dest.writeString(this.Time);
    }

    public Seminar(String id, String date, String weekday, String status, String url, String title, String guest, String time) {
        this.id = id;
        this.date = date;
        this.weekday = weekday;
        this.status = status;
        Url = url;
        this.title = title;
        this.guest = guest;
        Time = time;
    }

    public Seminar() {
    }

    protected Seminar(Parcel in) {
        this.id = in.readString();
        this.date = in.readString();
        this.weekday = in.readString();
        this.status = in.readString();
        this.Url = in.readString();
        this.title = in.readString();
        this.guest = in.readString();
        this.Time = in.readString();
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
}
