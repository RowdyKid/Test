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

@WebServlet("/add_AuthorizeCustomer")

public class add_AuthorizeCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public add_AuthorizeCustomer() {
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
        log.setContent("add_AuthorizeCustomer");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer id = (Integer) request.getSession().getAttribute("userid");

        String ids = request.getParameter("id");


        User user = new UserDaoImpl().queryUserInfoById(Integer.parseInt(ids));

        String roleId = request.getParameter("role");
        user.setRid(Integer.parseInt(roleId));
        user.setId(Integer.parseInt(ids));

        new UserDaoImpl().updateUserInfo(user);

//        request.setAttribute("userInfo", user);
        response.sendRedirect("/search_userInfo");

    }
}

