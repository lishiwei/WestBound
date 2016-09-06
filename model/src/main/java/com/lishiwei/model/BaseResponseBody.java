package com.lishiwei.model;

import java.util.List;

/**
 * Created by lishiwei on 16/5/26.
 */
public class BaseResponseBody<T>{
    List<T> dataList ;
    PageInfo page;
    boolean emptyDataList;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public boolean isEmptyDataList() {
        return emptyDataList;
    }

    public void setEmptyDataList(boolean emptyDataList) {
        this.emptyDataList = emptyDataList;
    }

    @Override
    public String toString() {
        return "BaseResponseBody{" +
                "dataList=" + dataList +
                ", page=" + page +
                ", emptyDataList=" + emptyDataList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseResponseBody)) return false;

        BaseResponseBody<?> that = (BaseResponseBody<?>) o;

        if (isEmptyDataList() != that.isEmptyDataList()) return false;
        if (getDataList() != null ? !getDataList().equals(that.getDataList()) : that.getDataList() != null)
            return false;
        return getPage() != null ? getPage().equals(that.getPage()) : that.getPage() == null;

    }

    @Override
    public int hashCode() {
        int result = getDataList() != null ? getDataList().hashCode() : 0;
        result = 31 * result + (getPage() != null ? getPage().hashCode() : 0);
        result = 31 * result + (isEmptyDataList() ? 1 : 0);
        return result;
    }
}
