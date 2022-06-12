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
 * 描述：已签订合同信息展示
 * 创建日期：2022-06-11
 * 创建者：LWJ
 */
@WebServlet("/op_InfoOfSignContract")
public class op_InfoOfSignContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public op_InfoOfSignContract() {
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
        Integer contractNo = Integer.parseInt(request.getParameter("id"));
        System.out.println("contractNo:" + contractNo);

        ContractDAO contractDAO = new ContractDAO();
        Contract oldContract = (Contract) contractDAO.GetOneEntity(contractNo);
        int clientNo = oldContract.GetClientNo();
        ClientDAO clientdao = new ClientDAO();
        Client client = (Client) clientdao.GetOneEntity(clientNo);

        request.setAttribute("customerName", client.GetName());
        request.setAttribute("contractName", oldContract.GetName());
        OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
        OperateFlow operateFlow = new OperateFlow();
        operateFlow.setContractNo(contractNo);
        operateFlow.setOperateType(StatusCode.OPERATETYPE_SIGN);
        operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
        ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
        if (arr != null) {
            for (int i = 0; i < arr.size(); i++) {
                Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                request.setAttribute("contractText", ((OperateFlow) arr.get(i)).getContent());
                request.getRequestDispatcher("op_InfoOfSignContract.jsp").forward(request, response);
            }
        }
    }
}