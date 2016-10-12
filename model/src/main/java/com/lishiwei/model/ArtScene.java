package com.lishiwei.model;

/**
 * Created by lishiwei on 16/8/24.
 */
public class ArtScene {

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
    private long createTimeStr;
    private String idStr;

    public long getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(long createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

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

    @Override
    public String toString() {
        return "ArtScene{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createTime=" + createTime +
                ", createTimeStr=" + createTimeStr +
                ", idStr='" + idStr + '\'' +
                '}';
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
}
