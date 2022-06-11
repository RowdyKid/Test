package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.pojo.User;
import com.cms.contractmanagementsystem.service.UserService;
import com.cms.contractmanagementsystem.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);
            //   跳回登录页面
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            // 登录 成功
            // 保存用户信息到 Session 域中
            req.getSession().setAttribute("nowUserName", username);
            req.getSession().setAttribute("nowUserId", loginUser.getId());
            System.out.println(loginUser.getId());
            System.out.println(username);

            if (Objects.equals(username, "newUser")) {
                req.getRequestDispatcher("NewUserPage.jsp").forward(req, resp);
            } else if (Objects.equals(username, "admin")) {
                req.getRequestDispatcher("ad_AdminMainPage.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("op_OperatorMainPage.jsp").forward(req, resp);
            }
        }
    }
}
