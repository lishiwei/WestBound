package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/5/21.
 */
public class Gallery implements Parcelable {
    String id;
    String chineseName;
    String englishName;
    String location;

    public Gallery(String location, String id, String chineseName, String englishName) {
        this.location = location;
        this.id = id;
        this.chineseName = chineseName;
        this.englishName = englishName;
    }

    /**
     * director : 总监
     * detail : 详情详情详情
     * history : 历史
     * artistSet : [{"id":201609051515011,"artistChineseName":"作家名称","artistEnglishName":"aaa"},{"id":201609051515141,"artistChineseName":"作家2","artistEnglishName":"bbbb"}]
     * idStr : 201609051516071
     */

    private String director;
    private String detail;
    private String history;
    private String idStr;
    private String artists;
    private String galleryImgUrl;
    /**
     * id : 201609051515011
     * artistChineseName : 作家名称
     * artistEnglishName : aaa
     */

    private List<String> artistsArr;
    private List<String> historyArr;


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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }


    public Gallery() {
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id='" + id + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", location='" + location + '\'' +
                ", director='" + director + '\'' +
                ", detail='" + detail + '\'' +
                ", history='" + history + '\'' +
                ", idStr='" + idStr + '\'' +
//                ", artists='" + artists + '\'' +
                ", galleryImgUrl='" + galleryImgUrl + '\'' +
//                ", artistsArr=" + artistsArr +
                ", historyArr=" + historyArr +
                '}';
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getGalleryImgUrl() {
        return galleryImgUrl;
    }

    public void setGalleryImgUrl(String galleryImgUrl) {
        this.galleryImgUrl = galleryImgUrl;
    }

    public List<String> getArtistsArr() {
        return artistsArr;
    }

    public void setArtistsArr(List<String> artistsArr) {
        this.artistsArr = artistsArr;
    }

    public List<String> getHistoryArr() {
        return historyArr;
    }

    public void setHistoryArr(List<String> historyArr) {
        this.historyArr = historyArr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.chineseName);
        dest.writeString(this.englishName);
        dest.writeString(this.location);
        dest.writeString(this.director);
        dest.writeString(this.detail);
        dest.writeString(this.history);
        dest.writeString(this.idStr);
        dest.writeString(this.artists);
        dest.writeString(this.galleryImgUrl);
        dest.writeStringList(this.artistsArr);
        dest.writeStringList(this.historyArr);
    }

    protected Gallery(Parcel in) {
        this.id = in.readString();
        this.chineseName = in.readString();
        this.englishName = in.readString();
        this.location = in.readString();
        this.director = in.readString();
        this.detail = in.readString();
        this.history = in.readString();
        this.idStr = in.readString();
        this.artists = in.readString();
        this.galleryImgUrl = in.readString();
        this.artistsArr = in.createStringArrayList();
        this.historyArr = in.createStringArrayList();
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
