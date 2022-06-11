package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.dao.ContractDAO;
import com.cms.contractmanagementsystem.dao.OperateFlowDAO;
import com.cms.contractmanagementsystem.utils.Contract;
import com.cms.contractmanagementsystem.utils.IEntity;
import com.cms.contractmanagementsystem.utils.OperateFlow;
import com.cms.contractmanagementsystem.utils.StatusCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/WaitingCountersignContract")
public class WaitingCountersignContract extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitingCountersignContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // this.doPost(request, response);

        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession(true);
        int clientNo = (Integer) session.getAttribute("userid");
        String type=request.getParameter("type");


        if(type==null){
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperatorNo(clientNo);
            operateFlow.setOperateType(StatusCode.OPERATETYPE_COUNTERSIGN);
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);

            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
            ArrayList<Contract> contracts = new ArrayList<Contract>();

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    contracts.add(contract);
                }
            }
            request.setAttribute("contracts", contracts);
            request.getRequestDispatcher("op_WaittingForCountersignContractList.jsp").forward(request, response);


        }
        else if(type.equals("search")){
            //获取合同ID
            Integer id=Integer.parseInt(request.getParameter("id"));
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperatorNo(clientNo);
            operateFlow.setOperateType(StatusCode.OPERATETYPE_COUNTERSIGN);
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);

            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    if(id.equals(contract.GetId()))
                    {
                        request.setAttribute("contracts", contract);
                        request.getRequestDispatcher("op_WaittingForCountersignContractList.jsp").forward(request, response);
                    }
                }
            }
            return;
        }
    }
}
