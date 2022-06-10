package com.cms.contractmanagementsystem.dao;

import com.cms.contractmanagementsystem.pojo.User;
import com.cms.contractmanagementsystem.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`del` from system_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`del` from system_user where username = ? and password = ?";
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


}
