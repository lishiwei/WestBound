package com.lishiwei.core;

/**
 * Created by shiwei on 2016/10/13.
 */
public class JsonObject {
    String pageNo;
    String pageSize;

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
