package com.cms.contractmanagementsystem.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.PrintWriter;
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
 * 文件名：ContractManageFinalize.java
 * 描述：管理员查看待定稿合同
 * 创建日期：2022-06-11
 * 创建者：LWJ
 */
@WebServlet("/ad_WaittingForReviseContract")
public class ad_WaittingForReviseContract  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ad_WaittingForReviseContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");

        if (type == null) {
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
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
            request.setAttribute("contracts", contracts);
            request.getRequestDispatcher("ad_WaittingForReviseContract.jsp").forward(request, response);


        } else if (type.equals("search")) {
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            OperateFlow operateFlow = new OperateFlow();
            operateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
            operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);

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
                request.setAttribute("contracts", contractSearch);
                System.out.println(contractSearch.size());
                request.getRequestDispatcher("ad_WaittingForReviseContract.jsp").forward(request, response);
            }

            }

    }
}
