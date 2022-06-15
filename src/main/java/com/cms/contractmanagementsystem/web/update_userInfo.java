package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.dao.LogDaoImpl;
import com.cms.contractmanagementsystem.dao.UserDaoImpl;
import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.pojo.User;

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

@WebServlet("/updateUser_userInfo")

public class update_userInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public update_userInfo() {
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
        log.setContent("delete_userInfo");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        User user = new UserDaoImpl().queryUserInfoById(Integer.parseInt(id));
        request.setAttribute("userInfo",user);
        request.getRequestDispatcher("ad_ModifyUserInfo.jsp").forward(request,response);

    }
}

