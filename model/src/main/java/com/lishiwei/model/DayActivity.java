package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shiwei on 2016/9/17.
 */
public class DayActivity implements Parcelable {
    /**
     * id : 201609051514401
     * name : 活动名称1
     * gallery : 画廊名称1
     * startTime : 9月5日-11月3日
     * openTime : 2016-09-06
     * time : 1:30am-3:00pm
     * location : 地址
     * mail : 邮件
     * phone : 15205050558
     * createTime : 1473059680000
     * dateStartStr : 9月5日-11月3日
     * idStr : 201609051514401
     * status : 进行中
     */

    private long id;
    private String name;
    private String gallery;
    private String startTime;
    private String openTime;
    private String time;
    private String location;
    private String mail;
    private String phone;
    private long createTime;
    private String dateStartStr;
    private String idStr;
    private String status;

    public String getWeekStr() {
        return weekStr;
    }

    public void setWeekStr(String weekStr) {
        this.weekStr = weekStr;
    }

    private String weekStr;

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

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDateStartStr() {
        return dateStartStr;
    }

    public void setDateStartStr(String dateStartStr) {
        this.dateStartStr = dateStartStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DayActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gallery='" + gallery + '\'' +
                ", startTime='" + startTime + '\'' +
                ", openTime='" + openTime + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", dateStartStr='" + dateStartStr + '\'' +
                ", idStr='" + idStr + '\'' +
                ", status='" + status + '\'' +
                ", weekStr='" + weekStr + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.gallery);
        dest.writeString(this.startTime);
        dest.writeString(this.openTime);
        dest.writeString(this.time);
        dest.writeString(this.location);
        dest.writeString(this.mail);
        dest.writeString(this.phone);
        dest.writeLong(this.createTime);
        dest.writeString(this.dateStartStr);
        dest.writeString(this.idStr);
        dest.writeString(this.status);
        dest.writeString(this.weekStr);
    }

    public DayActivity() {
    }

    protected DayActivity(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.gallery = in.readString();
        this.startTime = in.readString();
        this.openTime = in.readString();
        this.time = in.readString();
        this.location = in.readString();
        this.mail = in.readString();
        this.phone = in.readString();
        this.createTime = in.readLong();
        this.dateStartStr = in.readString();
        this.idStr = in.readString();
        this.status = in.readString();
        this.weekStr = in.readString();
    }

    public static final Parcelable.Creator<DayActivity> CREATOR = new Parcelable.Creator<DayActivity>() {
        @Override
        public DayActivity createFromParcel(Parcel source) {
            return new DayActivity(source);
        }

        @Override
        public DayActivity[] newArray(int size) {
            return new DayActivity[size];
        }
    };
}
