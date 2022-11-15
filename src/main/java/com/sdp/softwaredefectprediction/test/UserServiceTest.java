package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.pojo.User;
import com.sdp.softwaredefectprediction.service.UserService;
import com.sdp.softwaredefectprediction.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "55555", "55555", "email","0"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "wzg168", "123456",null, null)) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("123456")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }

    @Test
    public  void queryusernamebyID(){
        System.out.println(userService.queryusernamebyID(22));
    }
}