package com.cms.contractmanagementsystem.test;

import com.cms.contractmanagementsystem.dao.UserDao;
import com.cms.contractmanagementsystem.dao.UserDaoImpl;
import com.cms.contractmanagementsystem.pojo.User;
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
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456",null)));
    }


    @Test
    public void queryUserByid(){
        System.out.println(userDao.queryUserById(33));
    }
}