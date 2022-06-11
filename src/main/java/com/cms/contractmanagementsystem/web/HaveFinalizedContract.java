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
@WebServlet("/HaveFinalizedContract")
public class HaveFinalizedContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaveFinalizedContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // this.doPost(request, response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);

        int clientNo = (Integer) session.getAttribute("userid");
        String type = request.getParameter("type");


        if (type == null) {
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperatorNo(clientNo);
            operateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
            ArrayList<Contract> contracts = new ArrayList<Contract>();
            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    contracts.add(contract);
                }
            }
            request.setAttribute("contracts", contracts);
            request.getRequestDispatcher("op_HaveFinalizedContractList.jsp").forward(request, response);


        } else if (type.equals("search")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperatorNo(clientNo);
            operateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);

            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    if (id.equals(contract.GetId())) {
                        request.setAttribute("contracts", contract);
                        request.getRequestDispatcher("op_HaveFinalizedContractList.jsp").forward(request, response);
                    }
                }
            }
        }
    }
}
