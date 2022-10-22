package com.sdp.softwaredefectprediction.pojo;

import java.sql.Timestamp;

public class DownloadFile {
    private Integer id;
    private String filename;
    private String filepath;
    private Timestamp time;

    private Integer buggy;

    private Integer clean;

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getBuggy(){ return buggy; }

    public void setBuggy(){ this.buggy = buggy;}

    public Integer getClean(){return clean;}

    public void setClean(){this.clean = clean;}

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", time='" + time + '\'' +
                ", buggy='" + buggy + '\'' +
                ", clean='" + clean + '\'' +
                '}';
    }

    public DownloadFile() {
    }

    public DownloadFile(Integer id, String filename, String filepath, Timestamp time) {
        this.id = id;
        this.filename = filename;
        this.filepath = filepath;
        this.time = time;
        this.buggy = buggy;
        this.clean = clean;
    }

}
