package com.cms.contractmanagementsystem.pojo;

public class Log {

    private Integer id;
    private Integer operator;
    private String content;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", operator=" + operator +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Log() {
    }

    public Log(Integer id, Integer operator, String content, String time) {
        this.id = id;
        this.operator = operator;
        this.content = content;
        this.time = time;
    }
}
