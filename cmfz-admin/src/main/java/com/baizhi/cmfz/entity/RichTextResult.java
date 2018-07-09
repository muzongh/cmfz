package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 19:57
 */
public class RichTextResult implements Serializable {
    private Integer errno;
    private ArrayList<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public RichTextResult(Integer errno, ArrayList<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public RichTextResult() {

    }
}
