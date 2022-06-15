package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.pojo.User;
import com.cms.contractmanagementsystem.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/ad_AuthorizeCustomer")

public class ad_AuthorizeCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ad_AuthorizeCustomer() {
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
        log.setContent("ad_AuthorizeCustomer");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer id = (Integer) request.getSession().getAttribute("userid");

        String idx = request.getParameter("id");

        User user = new UserDaoImpl().queryUserInfoById(Integer.parseInt(idx));

        request.setAttribute("userInfo", user);
        request.getRequestDispatcher("ad_AuthorizeCustomer.jsp").forward(request, response);
    }
}

