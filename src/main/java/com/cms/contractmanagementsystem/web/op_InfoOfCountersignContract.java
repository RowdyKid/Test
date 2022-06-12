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


@WebServlet("/op_InfoOfCountersignContract")
public class op_InfoOfCountersignContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public  op_InfoOfCountersignContract() {
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
        //查看经过审核的合同（不代表审核通过）
        OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
        OperateFlow operateFlow = new OperateFlow();
        operateFlow.setContractNo(contractNo);
        operateFlow.setOperateType(StatusCode.OPERATETYPE_COUNTERSIGN);


        ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
        if (arr != null) {
            for (int i = 0; i < arr.size(); i++) {
                Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));

                request.setAttribute("contractName",contract.GetName());
                request.setAttribute("countersignOpinion", ((OperateFlow) arr.get(i)).getContent());
                String result ;

                if(((OperateFlow) arr.get(i)).getOperateStatus()==StatusCode.OPERATESTATUS_HAVE_REJECT){
                    result="NO";
                    request.setAttribute("isPass",result);}
                else{
                    result="YES";
                    request.setAttribute("isPass",result);
                }

            }
        }
        request.getRequestDispatcher("op_InfoOfCountersignContract.jsp").forward(request, response);

    }
}