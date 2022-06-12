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
 * 文件名：ContractManageFinalize.java
 * 描述：已定稿合同信息展示
 * 创建日期：2022-06-08
 * 创建者：LWJ
 */
/**
 * Servlet implementation class ContractManageFinalize
 */
@WebServlet("/InfoOfFinalizedContractList")
public class InofOfFinalizedContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示合同详细信息
        //获取合同ID


        Integer contractNo = Integer.parseInt(request.getParameter("id"));
        System.out.println("contractNo:" + contractNo);

            ContractDAO contractDAO = new ContractDAO();
            Contract oldContract = (Contract) contractDAO.GetOneEntity(contractNo);

        int clientNo = oldContract.GetClientNo();
        ClientDAO clientdao = new ClientDAO();
        Client client=(Client)clientdao.GetOneEntity(clientNo);

        request.setAttribute("customerName",client.GetName());
           request.setAttribute("contract",oldContract);
            request.getRequestDispatcher("op_InfoOfFinalizedContract.jsp").forward(request, response);


        }






    }
