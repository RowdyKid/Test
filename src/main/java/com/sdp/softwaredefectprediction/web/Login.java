package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.dao.LogDaoImpl;
import com.sdp.softwaredefectprediction.pojo.Log;
import com.sdp.softwaredefectprediction.pojo.User;
import com.sdp.softwaredefectprediction.service.UserService;
import com.sdp.softwaredefectprediction.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置字体
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        UserService userService = new UserServiceImpl();
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null, null));
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
            req.getSession().setAttribute("nowUserEmail",loginUser.getEmail());

            System.out.println(loginUser.getId());
            System.out.println(username);

            Log log = new Log();
            log.setOperator((Integer) req.getSession().getAttribute("userid"));
            log.setContent("LoginServlet");
            log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            new LogDaoImpl().saveLogInfo(log);

            req.getRequestDispatcher("user_MainPage.jsp").forward(req, resp);
//            if (Objects.equals(loginUser.getRid(), 1)) {    //1新注册
//                req.getRequestDispatcher("NewUserPage.jsp").forward(req, resp);
//            } else if (Objects.equals(loginUser.getRid(), 2)) { //2系统管理员
//                req.getRequestDispatcher("user_MainPage.jsp").forward(req, resp);
//            } else {        //3合同操作员
//                req.getRequestDispatcher("op_OperatorMainPage.jsp").forward(req, resp);
//            }
        }
    }
}
