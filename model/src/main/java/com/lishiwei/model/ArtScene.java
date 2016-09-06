package com.lishiwei.model;

/**
 * Created by lishiwei on 16/8/24.
 */
public class ArtScene {
    String title;
    String  time;
    String imgUrl;
    String content;

    public ArtScene(String title, String time, String imgUrl, String content) {
        this.title = title;
        this.time = time;
        this.imgUrl = imgUrl;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArtScene{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
