package com.yadhuwanshirahul.blog.application.PayLoad;

import java.util.ArrayList;
import java.util.List;

public class PostResponse {
    List<PostDTO> post = new ArrayList<>();
    private int pageNo;
    private int pageSize;
    private long totalElement;
    private int totalPage;
    private boolean isLast;

    public List<PostDTO> getPost() {
        return post;
    }

    public void setPost(List<PostDTO> post) {
        this.post = post;
    }

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

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
