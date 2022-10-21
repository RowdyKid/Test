package com.sdp.softwaredefectprediction.pojo;

import java.sql.Timestamp;

public class Attachment {
    private Integer id;
    private String filename;
    private String filepath;
    private String filetype;
    private Timestamp time;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {this.filepath = filepath; }

    public String getFiletype() { return filetype; }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getDel() { return del; }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filetype='" + filetype + '\'' +
                ", time='" + time + '\'' +
                ", del='" + del + '\'' +
                '}';
    }

    public Attachment() {
    }

    public Attachment(Integer id, String filename, String filepath, String filetype, Timestamp time, Integer del) {
        this.id = id;
        this.filename = filename;
        this.filepath = filepath;
        this.filetype = filetype;
        this.time = time;
        this.del = Integer.valueOf(del);
    }

    public Attachment(Integer id, String filename, String filepath, String filetype, Timestamp time) {
        this.id = id;
        this.filename = filename;
        this.filepath = filepath;
        this.filetype = filetype;
        this.time = time;
    }
}
