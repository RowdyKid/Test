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
@WebServlet("/InfoOfFinalizedContract")
public class InfoFinalizedContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoFinalizedContract() {
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
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void showInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);
        int clientNo=(Integer)session.getAttribute("id");

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
        request.setAttribute("contractList", contracts);
        request.getRequestDispatcher("InfoOfFinalizedContract.jsp").forward(request, response);



    }


}
