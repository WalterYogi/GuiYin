package com.finance.brid.entity;

import java.io.Serializable;

/**
 * Created by admin on 2016/7/1.
 */
public class UploadFaceReturnObject implements Serializable{

    /**
     * file_id : 1467356808373
     * size : 71200
     * path : http://192.168.0.114:8110/5,17d188f0b2
     * ext :
     * file_name : 5,17d188f0b2
     * original_name : userFace
     * mime :
     * w : 0
     * h : 0
     * srcid : 0
     */

    private long file_id;
    private int size;
    private String path;
    private String ext;
    private String file_name;
    private String original_name;
    private String mime;
    private int w;
    private int h;
    private int srcid;

    public long getFile_id() {
        return file_id;
    }

    public void setFile_id(long file_id) {
        this.file_id = file_id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSrcid() {
        return srcid;
    }

    public void setSrcid(int srcid) {
        this.srcid = srcid;
    }
}
