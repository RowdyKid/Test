package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.dao.UserDao;
import com.sdp.softwaredefectprediction.dao.UserDaoImpl;
import com.sdp.softwaredefectprediction.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin1234") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin1","admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", null,null)));
    }


    @Test
    public void queryUserByid(){
        System.out.println(userDao.queryUserById(33));
    }
}