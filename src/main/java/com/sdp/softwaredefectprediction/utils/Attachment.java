package com.sdp.softwaredefectprediction.utils;


import java.sql.Timestamp;

public class Attachment implements IEntity {

    private int id; //记录id
    private String filename; //文件名称
    private String filepath; //文件路径
    private String filetype; //文件类型
    private String time; //提交时间


    public Attachment(int id, String filename, String filepath, String filetype, Timestamp time){
        this.id=0;
        this.filename=null;
        this.filepath=null;
        this.time=null;
    }

    public Attachment(int id, String filename,
                      String filepath, String filetype, String time){
        this.id=id;
        this.filename=filename;
        this.filepath=filepath;
        this.filetype=filetype;
        this.time=time;
    }

    @Override
    public int GetId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public void SetId(int id) {
        // TODO Auto-generated method stub
        this.id=id;
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

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String submitTime) {
        this.time = submitTime;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

}
