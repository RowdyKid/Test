package com.cms.contractmanagementsystem.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.utils.*;

@WebServlet("/CountersignContract")
public class CountersignContract extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public CountersignContract(){
        super();
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //TODO
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        Integer pageRecordNum = StatusCode.PAGE_RECORDNUM;
        Integer pageNo = 1;

    }

}
