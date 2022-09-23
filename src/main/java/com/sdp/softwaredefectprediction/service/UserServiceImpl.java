package com.sdp.softwaredefectprediction.service;

import com.sdp.softwaredefectprediction.dao.UserDao;
import com.sdp.softwaredefectprediction.dao.UserDaoImpl;
import com.sdp.softwaredefectprediction.pojo.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }

        return true;

    }

    @Override
    public String queryusernamebyID(int id) {
        return userDao.queryUserById(id);
    }
}
