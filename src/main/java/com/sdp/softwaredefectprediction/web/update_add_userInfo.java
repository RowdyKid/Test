package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.dao.UserDaoImpl;
import com.sdp.softwaredefectprediction.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/update_add_userInfo")

public class update_add_userInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public update_add_userInfo() {
        super();
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new UserDaoImpl().queryUserInfoById(Integer.parseInt(id));
        //数据库修改数据
        user.setPassword(password);
        user.setEmail(email);
        //session修改数据
        User LoginUser = (User) request.getSession().getAttribute("nowUser");
        LoginUser.setPassword(password);
        LoginUser.setEmail(email);
//        request.getSession().setAttribute("nowUserPassword",password);
//        request.getSession().setAttribute("nowUserEmail",email);
        //结果布尔型变量赋值
        new UserDaoImpl().updateUserPasswordInfo(user);
        new UserDaoImpl().updateUserEmailInfo(user);

        response.sendRedirect("ModifyUserInfo.jsp");
    }
}

