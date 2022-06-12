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

@WebServlet("/ad_ViewContractDetail")
public class ad_ViewContractDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ad_ViewContractDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer contractNo = Integer.parseInt(request.getParameter("id"));
        String type= request.getParameter("type");
        ContractDAO contractDAO = new ContractDAO();
        Contract oldContract = (Contract) contractDAO.GetOneEntity(contractNo);

        int clientNo = oldContract.GetClientNo();
        ClientDAO clientdao = new ClientDAO();
        String clientName = ((Client) clientdao.GetOneEntity(clientNo)).GetName();

        request.setAttribute("contractName", oldContract.GetName());
        request.setAttribute("customerName", clientName);
        request.setAttribute("contractStartTime", oldContract.GetStartTime());
        request.setAttribute("contractEndTime", oldContract.GetFinishTime());
        request.setAttribute("contractContent", oldContract.GetContent());
        request.setAttribute("id", contractNo);
        if(type.equals("view")){
            request.getRequestDispatcher("ad_ViewContractDetail.jsp").forward(request, response);
        }else if(type.equals("revise")){
            request.getRequestDispatcher("ad_ReviseContract.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }

    }
}