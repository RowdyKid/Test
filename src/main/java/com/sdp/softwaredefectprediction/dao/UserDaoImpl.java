package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`del` from system_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public List<User> queryAllUserInfo() {
        String sql = "select * from system_user order by del asc";
        return queryForList(User.class, sql);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`del`,`rid` from system_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into system_user(`username`,`password`,`del`) values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getDel());
    }

    @Override
    public String queryUserById(int id) {
        String sql="select * from system_user where id = ?";
        return queryUserById(sql,id);
    }

    @Override
    public User queryUserInfoById(int id) {
        String sql="select * from system_user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public void updateUserInfo(User user) {
        String sql="update system_user set rid = ?  where id = ?";
        update(sql,user.getRid(),user.getId());
    }

    @Override
    public void updateUserPasswordInfo(User user) {
        String sql="update system_user set password = ?  where id = ?";
        update(sql,user.getPassword(),user.getId());
    }

    @Override
    public void deleteUserInfoById(User user) {
        String sql="update system_user set del = ?  where id = ?";
        update(sql,user.getDel(),user.getId());
    }



}
