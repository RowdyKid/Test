package com.cms.contractmanagementsystem.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.utils.*;



/**
 *
 */
@WebServlet("/ad_ReviseContract")
public class ad_ReviseContract extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public  ad_ReviseContract() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
       // Integer operatorNo=(Integer)request.getSession().getAttribute("id");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String NewContractName = request.getParameter("NewContractName");
        String StartTime = request.getParameter("StartTime");
        String FinishTime = request.getParameter("FinishTime");
        String contractContent = request.getParameter("contractContent");
        if (id != null) {
            ContractDAO contractDao = new ContractDAO();
            Contract contract = (Contract) contractDao.GetOneEntity(id);
            Contract s = new Contract();

            s.SetName(new String(NewContractName.getBytes("iso-8859-1"), "UTF-8"));
            Contract tt = (Contract) contractDao.GetOneEntity(s);
            boolean canModify = false;
            if (tt == null) {
                canModify = true;
            } else if (tt.GetId() == id) {
                canModify = true;
            }
            //修改合同信息，名字，内容，时间
            if (canModify) {
                contract.SetName(new String(NewContractName.getBytes("iso-8859-1"), "UTF-8"));
                contract.SetStartTime(new String(StartTime.getBytes("iso-8859-1"), "UTF-8"));
                contract.SetFinishTime(new String(FinishTime.getBytes("iso-8859-1"), "UTF-8"));
                contract.SetContent(new String(contractContent.getBytes("iso-8859-1"), "UTF-8"));
             out.write("修改合同成功");
            }
            else{
                out.write("该合同名称已存在!");
            }
        }
    }
}