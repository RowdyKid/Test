package com.cms.contractmanagementsystem.web;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * 文件名：ContractManageFinalize.java
 * 描述：合同定稿
 * 创建日期：2022-06-08
 * 创建者：LWJ
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.utils.*;

/**
 * Servlet implementation class ContractManageFinalize
 */
@WebServlet("/WaittingForFinalizedContractList")
public class FinalizedContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizedContract() {
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

    protected  void waitingFinalize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);
        // int clientNo=(Integer)session.getAttribute("id");
        int clientNo=1;
        OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
        OperateFlow operateFlow = new OperateFlow();
        operateFlow.setOperatorNo(clientNo);
        operateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
        operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);

        ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
        ArrayList<Contract> contracts = new ArrayList<Contract>();

        if (arr != null) {
            for (int i = 0; i < arr.size(); i++) {
                Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                contracts.add(contract);
            }
        }
        request.getRequestDispatcher("WaittingForFinalizedContractList.jsp").forward(request, response);



    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);
        // int clientNo=(Integer)session.getAttribute("id");

        int clientNo=1;

        //获取合同ID
        Integer id=Integer.parseInt(request.getParameter("id"));
        OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
        OperateFlow operateFlow = new OperateFlow();
        operateFlow.setOperatorNo(clientNo);
        operateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
        operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);

        ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);

        if (arr != null) {
            for (int i = 0; i < arr.size(); i++) {
                Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                if(id.equals(contract.GetId()))
                {
                    request.setAttribute("contracts", contract);
                    request.getRequestDispatcher("WaittingForFinalizedContractList.jsp").forward(request, response);
                }
            }
        }
        return;

    }}

