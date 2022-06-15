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
import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.utils.*;
/**
 * Servlet implementation class ContractInfoQuery
 */
@WebServlet("/ad_SearchContract")
public class ad_SearchContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ad_SearchContract() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log log = new Log();
        log.setOperator((Integer) request.getSession().getAttribute("userid"));
        log.setContent("ad_SearchContract");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");

        if (type == null) {

            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);

            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
            ArrayList<Contract> contracts = new ArrayList<Contract>();

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract01 = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    contracts.add(contract01);
                }
            }
            ArrayList<String> statusCode = new ArrayList<String>();
            for (int i = 0; i < contracts.size(); i++) {
                Status temp = new Status();
                temp.SetcontractNo(contracts.get(i).GetId());
                int temp01=((Status) new StatusDAO().GetOneEntity(temp)).GetcontractStatus();
                switch (temp01){
                    case 11:
                        statusCode.add("起草");
                    case 31:
                        statusCode.add("会签");
                    case 41:
                        statusCode.add("定稿");
                    case 51:
                        statusCode.add("审核");
                    case 61:
                        statusCode.add("签订");

                }

            }

            request.setAttribute("contracts", contracts);
            request.setAttribute("status", statusCode);
            request.getRequestDispatcher("ad_SearchContract.jsp").forward(request, response);

        }


        else if(type.equals("search")) {


            ContractDAO contractdao = new ContractDAO();
            Contract contract = new Contract();
            //查找
            if (request.getParameter("contractName") != null) {
                contract.SetName(request.getParameter("contractName"));
            }



            ArrayList<IEntity> contracts = contractdao.GetEntitySet(contract);
            ArrayList<String> statusCode = new ArrayList<String>();
            for (int i = 0; i < contracts.size(); i++) {
                Status temp = new Status();
                temp.SetcontractNo(contracts.get(i).GetId());
                int temp01=((Status) new StatusDAO().GetOneEntity(temp)).GetcontractStatus();
                switch (temp01){
                    case 11:
                        statusCode.add("起草");
                    case 31:
                        statusCode.add("会签");
                    case 41:
                        statusCode.add("定稿");
                    case 51:
                        statusCode.add("审核");
                    case 61:
                        statusCode.add("签订");

                }
            }


            request.setAttribute("contracts", contracts);
            request.setAttribute("status", statusCode);


            request.getRequestDispatcher("ad_SearchContract.jsp").forward(request, response);
        }

    }}
