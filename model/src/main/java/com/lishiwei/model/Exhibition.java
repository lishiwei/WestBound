package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lishiwei on 16/5/18.
 */
public class Exhibition implements Parcelable {
    String ExpoName;
    String weekDay;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Exhibition(String expoName, String weekDay, String status, String showName, String imageURL, String date, String time, String curator, String location, String content) {
        ExpoName = expoName;
        this.weekDay = weekDay;
        Status = status;
        ShowName = showName;
        ImageURL = imageURL;
        Date = date;
        Time = time;
        Curator = curator;
        Location = location;
        Content = content;
    }

    String Status;
    String ShowName;
    String ImageURL;
    String Date;
    String Time;
    String Curator;
    String Location;
    String Content;


    public Exhibition(String expoName, String status, String showName, String imageURL, String date, String time, String curator, String location,String content) {
        ExpoName = expoName;
        Status = status;
        ShowName = showName;
        ImageURL = imageURL;
        Date = date;
        Time = time;
        Curator = curator;
        Location = location;
        Content = content;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "ExpoName='" + ExpoName + '\'' +
                ", Status='" + Status + '\'' +
                ", ShowName='" + ShowName + '\'' +
                ", ImageURL='" + ImageURL + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Curator='" + Curator + '\'' +
                ", Location='" + Location + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getExpoName() {
        return ExpoName;
    }

    public void setExpoName(String expoName) {
        ExpoName = expoName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String showName) {
        ShowName = showName;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCurator() {
        return Curator;
    }

    public void setCurator(String curator) {
        Curator = curator;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ExpoName);
        dest.writeString(this.Status);
        dest.writeString(this.ShowName);
        dest.writeString(this.weekDay);
        dest.writeString(this.ImageURL);
        dest.writeString(this.Date);
        dest.writeString(this.Time);
        dest.writeString(this.Curator);
        dest.writeString(this.Location);
        dest.writeString(this.Content);
    }

    protected Exhibition(Parcel in) {
        this.ExpoName = in.readString();
        this.Status = in.readString();
        this.ShowName = in.readString();
        this.weekDay = in.readString();
        this.ImageURL = in.readString();
        this.Date = in.readString();
        this.Curator = in.readString();
        this.Location = in.readString();
        this.Content = in.readString();
    }

    public static final Parcelable.Creator<Exhibition> CREATOR = new Parcelable.Creator<Exhibition>() {
        @Override
        public Exhibition createFromParcel(Parcel source) {
            return new Exhibition(source);
        }

        @Override
        public Exhibition[] newArray(int size) {
            return new Exhibition[size];
        }
    };
}
