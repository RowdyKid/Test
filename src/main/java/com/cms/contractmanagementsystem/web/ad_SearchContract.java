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
      //  this.doPost(request, response);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");



            //从数据库读取所有合同,默认显示第一页
            ContractDAO contractdao=new ContractDAO();
            Contract contract=new Contract();
            //查找
            if(request.getParameter("contractName")!=null){

                contract.SetName(new String(request.getParameter("contractName").getBytes("iso-8859-1"),"UTF-8"));
                //contract.SetName(request.getParameter("contractName"));
                request.setAttribute("contractName", contract.GetName());
            }


            ArrayList<IEntity> contracts=contractdao.GetEntitySet(contract);
//            ArrayList<Integer> statusCode=new ArrayList<Integer>();
//            for(int i=0;i<contracts.size();i++){
//                Status temp=new Status();
//                temp.SetcontractNo(contracts.get(i).GetId());
//                statusCode.add(((Status)new StatusDAO().GetOneEntity(temp)).GetcontractStatus());
//            }


            request.setAttribute("contracts", contracts);

            request.getRequestDispatcher("ad_SearchContract.jsp").forward(request, response);


    }}