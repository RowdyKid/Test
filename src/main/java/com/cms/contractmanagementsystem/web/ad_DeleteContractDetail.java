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
@WebServlet("/ad_DeleteContractDetail")
public class ad_DeleteContractDetail extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public  ad_DeleteContractDetail () {
        super();
        // TODO Auto-generated constructor s}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();


        //注意：此处应删除多个表中的数据：contract,attachment,operateFlow,status

        Integer id=Integer.parseInt(request.getParameter("id"));
        if(id!=null){
            ContractDAO contractDao=new ContractDAO();
            Contract contract=(Contract)contractDao.GetOneEntity(id);
            contractDao.DeleteEntity(contract);

            AttachmentDAO attachmentDao=new AttachmentDAO();
            Attachment attachment=new Attachment();
            attachment.setContractNo(id);

            boolean res01=true;
            boolean res02=true;
            boolean res03=true;

            //删除附件
            if(attachmentDao.GetOneEntity(attachment)!=null){
                res01=attachmentDao.DeleteEntity(attachment);
            }

            OperateFlowDAO operateflowDao=new OperateFlowDAO();
            OperateFlow operateflow=new OperateFlow();
            operateflow.setContractNo(id);
            res02=operateflowDao.DeleteEntity(operateflow);

            StatusDAO statusDao=new StatusDAO();
            Status status=new Status();
            status.SetcontractNo(id);
            res03=statusDao.DeleteEntity(status);

            if(res01&&res02&&res03){


                out.write("删除成功！");
            }else{
                out.write("删除失败！");
            }

        }

    }
    }
