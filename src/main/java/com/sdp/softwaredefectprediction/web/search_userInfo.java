package com.sdp.softwaredefectprediction.web;

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
import java.util.List;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/search_userInfo")

public class search_userInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public search_userInfo() {
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

        List<User> users = new UserDaoImpl().queryAllUserInfo();
        request.setAttribute("users", users);
        request.getRequestDispatcher("ad_SearchUser.jsp").forward(request, response);
    }
}

