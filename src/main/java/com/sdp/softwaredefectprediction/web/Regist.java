package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.User;
import com.sdp.softwaredefectprediction.service.UserService;
import com.sdp.softwaredefectprediction.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "Regist", value = "/Regist")
public class Regist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //设置字体
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //  1、获取请求的参数
        System.out.println("hello");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println(username);
        System.out.println(password);
        System.out.println(email);


//
//        3、检查 用户名是否可用
        if (userService.existsUsername(username)) {
            System.out.println("用户名[" + username + "]已存在!");

            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "用户名已存在！！");
            req.setAttribute("username", username);


//        跳回注册页面
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        } else {
            //      可用
//                调用Sservice保存到数据库
            userService.registUser(new User(null, username, password, email,"0"));
//
//        跳到注册成功页面 regist_success.jsp
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }

    }
}
