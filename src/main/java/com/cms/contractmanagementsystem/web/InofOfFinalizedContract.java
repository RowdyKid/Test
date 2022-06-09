package com.cms.contractmanagementsystem.web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.utils.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Servlet implementation class ContractManageFinalize
 */
@WebServlet("/HaveFinalizedContractList")
public class InofOfFinalizedContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InofOfFinalizedContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    protected void showdetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //显示合同详细信息
        //获取合同ID
        Integer id=Integer.parseInt(request.getParameter("id"));


    }






    }
