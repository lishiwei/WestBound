package com.lishiwei.model;

/**
 * Created by lishiwei on 16/5/26.
 */
public class PageInfo {

    /**
     * pageNo : 1
     * pageSize : 5
     * totalQuantity : 2
     * firstResultNum : 0
     * lastResultNum : 2
     * totalPage : 1
     * firstPage : true
     * lastPage : true
     */

    private int pageNo;
    private int pageSize;
    private int totalQuantity;
    private int firstResultNum;
    private int lastResultNum;
    private int totalPage;
    private boolean firstPage;
    private boolean lastPage;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getFirstResultNum() {
        return firstResultNum;
    }

    public void setFirstResultNum(int firstResultNum) {
        this.firstResultNum = firstResultNum;
    }

    public int getLastResultNum() {
        return lastResultNum;
    }

    public void setLastResultNum(int lastResultNum) {
        this.lastResultNum = lastResultNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalQuantity=" + totalQuantity +
                ", firstResultNum=" + firstResultNum +
                ", lastResultNum=" + lastResultNum +
                ", totalPage=" + totalPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                '}';
    }
}
