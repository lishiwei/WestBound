package com.lishiwei.model;

import android.databinding.DataBindingUtil;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lishiwei on 16/5/18.
 */
public class Exhibition implements Parcelable {
    String weekDay;
    /**
     * id : 201609051511541
     * expoName : 展览名称
     * showName : 展览标题
     * dateStart : 2016-09-05
     * dateEnd : 2016-09-07
     * timeStart : 12:12:12
     * timeEnd : 14:14:14
     * curator : 策展人
     * location : 地址
     * longitude : 111111.1111
     * latitude : 2222.2222
     * traffic : 交通交通
     * content : 内容内容
     * exhibitionImgUrl : upload/201609051511541.png
     * exhibitionActivitySet : null
     * exhibitionBrandImageSet : null
     * timeStr : 12:12-14:14
     * idStr : 201609051511541
     * state : 休息中
     */

    private long id;
    private String expoName;

    private String dateStart;
    private String dateEnd;
    private String timeStart;
    private String timeEnd;
    private String longitude;
    private String latitude;
    private String traffic;
    private String exhibitionImgUrl;
    private Object exhibitionActivitySet;
    private Object exhibitionBrandImageSet;
    private String timeStr;
    private String idStr;
    private String state;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Exhibition(String expoName, String weekDay, String status, String showName, String imageURL, String date, String time, String curator, String location, String content) {
        this.expoName = expoName;
        this.weekDay = weekDay;
        this.status = status;
        this.showName = showName;
        this.date = date;
        this.curator = curator;
        this.location = location;
        this.content = content;
    }

    String status;
    String showName;
    String date;
    String curator;
    String location;
    String content;


    public Exhibition(String expoName, String status, String showName, String imageURL, String date, String time, String curator, String location,String content) {
        this.expoName = expoName;
        this.status = status;
        this.showName = showName;
        this.date = date;

        this.curator = curator;
        this.location = location;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.expoName);
        dest.writeString(this.status);
        dest.writeString(this.showName);
        dest.writeString(this.weekDay);
        dest.writeString(this.date);

        dest.writeString(this.curator);
        dest.writeString(this.location);
        dest.writeString(this.content);
    }

    protected Exhibition(Parcel in) {
        this.expoName = in.readString();
        this.status = in.readString();
        this.showName = in.readString();
        this.weekDay = in.readString();
        this.date = in.readString();
        this.curator = in.readString();
        this.location = in.readString();
        this.content = in.readString();
    }

    public static final Creator<Exhibition> CREATOR = new Creator<Exhibition>() {
        @Override
        public Exhibition createFromParcel(Parcel source) {
            return new Exhibition(source);
        }

        @Override
        public Exhibition[] newArray(int size) {
            return new Exhibition[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpoName() {
        return expoName;
    }

    public void setExpoName(String expoName) {
        this.expoName = expoName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExhibitionImgUrl() {
        return exhibitionImgUrl;
    }

    public void setExhibitionImgUrl(String exhibitionImgUrl) {
        this.exhibitionImgUrl = exhibitionImgUrl;
    }

    public Object getExhibitionActivitySet() {
        return exhibitionActivitySet;
    }

    public void setExhibitionActivitySet(Object exhibitionActivitySet) {
        this.exhibitionActivitySet = exhibitionActivitySet;
    }

    public Object getExhibitionBrandImageSet() {
        return exhibitionBrandImageSet;
    }

    public void setExhibitionBrandImageSet(Object exhibitionBrandImageSet) {
        this.exhibitionBrandImageSet = exhibitionBrandImageSet;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Exhibition{" +
                "weekDay='" + weekDay + '\'' +
                ", id=" + id +
                ", expoName='" + expoName + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", traffic='" + traffic + '\'' +
                ", exhibitionImgUrl='" + exhibitionImgUrl + '\'' +
                ", exhibitionActivitySet=" + exhibitionActivitySet +
                ", exhibitionBrandImageSet=" + exhibitionBrandImageSet +
                ", timeStr='" + timeStr + '\'' +
                ", idStr='" + idStr + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                ", showName='" + showName + '\'' +
                ", date='" + date + '\'' +
                ", curator='" + curator + '\'' +
                ", location='" + location + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
