package com.cms.contractmanagementsystem.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
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
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
                int temp01 = ((Status) new StatusDAO().GetOneEntity(temp)).GetcontractStatus();
                switch (temp01) {
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

        } else if (type.equals("search")) {
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();

            operateFlow.setOperateType(StatusCode.OPERATETYPE_DRAFT);

            ArrayList<IEntity> arr = operateFlowDAO.GetEntitySet(operateFlow);
            ArrayList<Contract> contracts = new ArrayList<Contract>();
            ArrayList<Contract> contractSearch = new ArrayList<Contract>();
            String conName = request.getParameter("contractName");
            System.out.println(conName);

            Pattern pattern = Pattern.compile(conName, Pattern.CASE_INSENSITIVE);

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    // Matcher matcher = pattern.matcher(((OperateFlow) arr.get(i)).getContent());
                    contracts.add(contract);
                }
                for (int i = 0; i < contracts.size(); i++) {
                    Matcher matcher = pattern.matcher(contracts.get(i).GetName());
                    if (matcher.find()) {
                        //把找到的图书放入arraySearch集合
                        contractSearch.add(contracts.get(i));
                    }
                }

                ArrayList<String> statusCode = new ArrayList<String>();
                for (int i = 0; i < contractSearch.size(); i++) {
                    Status temp = new Status();
                    temp.SetcontractNo(contractSearch.get(i).GetId());
                    int temp01 = ((Status) new StatusDAO().GetOneEntity(temp)).GetcontractStatus();
                    switch (temp01) {
                        case 11:
                            statusCode.add("起草");
                            break;
                        case 31:
                            statusCode.add("会签");
                            break;
                        case 41:
                            statusCode.add("定稿");
                            break;
                        case 51:
                            statusCode.add("审核");
                            break;
                        case 61:
                            statusCode.add("签订");
                            break;
                        default:
                            statusCode.add("未知");
                            break;
                    }
                }


                request.setAttribute("contracts", contractSearch);
                request.setAttribute("status", statusCode);


                request.getRequestDispatcher("ad_SearchContract.jsp").forward(request, response);
            }

        }
    }}
