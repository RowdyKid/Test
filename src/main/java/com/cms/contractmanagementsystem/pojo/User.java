package com.cms.contractmanagementsystem.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + del + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String username, String password, String del) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.del = del;
    }
}
