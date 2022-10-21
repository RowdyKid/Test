package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.pojo.User;
import com.sdp.softwaredefectprediction.service.UserService;
import com.sdp.softwaredefectprediction.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
//        userService.registUser(new User(null, "bbj168", "666666",null));
//        userService.registUser(new User(null, "abc168", "666666", null));
    }
//你说吧  我听者的
    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "wzg168", "123456",null, null)) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }

    @Test
    public  void queryusernamebyID(){
        System.out.println(userService.queryusernamebyID(33));
    }
}