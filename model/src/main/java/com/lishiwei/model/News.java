package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lishiwei on 16/5/17.
 */
public class News implements Parcelable {


    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", mainTitle='" + mainTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", newsImgUrl='" + newsImgUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", IdStr='" + IdStr + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNewsImgUrl() {
        return newsImgUrl;
    }

    public void setNewsImgUrl(String newsImgUrl) {
        this.newsImgUrl = newsImgUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIdStr() {
        return IdStr;
    }

    public void setIdStr(String idStr) {
        IdStr = idStr;
    }

    public News(String id, String mainTitle, String subTitle, String source, String content, String newsImgUrl, String createTime, String idStr, String createTimeStr) {
        this.id = id;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.source = source;
        this.content = content;
        this.newsImgUrl = newsImgUrl;
        this.createTime = createTime;
        IdStr = idStr;
        this.createTimeStr = createTimeStr;
    }

    public News() {

    }

    String id;
    String mainTitle;
    String subTitle;
    String source;
    String content;
    String newsImgUrl;
    String createTime;
    String IdStr;
String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.mainTitle);
        dest.writeString(this.subTitle);
        dest.writeString(this.source);
        dest.writeString(this.content);
        dest.writeString(this.newsImgUrl);
        dest.writeString(this.createTime);
        dest.writeString(this.IdStr);
        dest.writeString(this.createTimeStr);
    }

    protected News(Parcel in) {
        this.id = in.readString();
        this.mainTitle = in.readString();
        this.subTitle = in.readString();
        this.source = in.readString();
        this.content = in.readString();
        this.newsImgUrl = in.readString();
        this.createTime = in.readString();
        this.IdStr = in.readString();
        this.createTimeStr = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
