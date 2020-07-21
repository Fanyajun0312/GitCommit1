package com.example.mvpchow10.bean;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public class doaw {
    int count;
    int contentLength;
    String path;

    public doaw() {
    }

    public doaw(int count, int contentLength, String path) {
        this.count = count;
        this.contentLength = contentLength;
        this.path = path;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
