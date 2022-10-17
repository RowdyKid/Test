package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.dao.LogDaoImpl;
import com.sdp.softwaredefectprediction.dao.UserDaoImpl;
import com.sdp.softwaredefectprediction.pojo.Log;
import com.sdp.softwaredefectprediction.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        Log log = new Log();
        log.setOperator((Integer) request.getSession().getAttribute("userid"));
        log.setContent("update_add_userInfo");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        User user = new UserDaoImpl().queryUserInfoById(Integer.parseInt(id));
        user.setPassword(password);
        new UserDaoImpl().updateUserPasswordInfo(user);
        response.sendRedirect("search_userInfo");
    }
}

