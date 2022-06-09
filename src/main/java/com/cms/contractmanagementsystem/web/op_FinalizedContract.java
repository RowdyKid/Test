package com.cms.contractmanagementsystem.web;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * 文件名：ContractManageFinalize.java
 * 描述：合同定稿操作
 * 创建日期：2022-06-08
 * 创建者：LWJ
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.contractmanagementsystem.dao.*;
import com.cms.contractmanagementsystem.utils.*;
@WebServlet("/op_FinalizedContract")
public class op_FinalizedContract extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public op_FinalizedContract() {
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
        //获取提交的信息，写入数据库
        Integer contractNo=Integer.parseInt(request.getParameter("id"));
        String htnr = (String)request.getParameter("contractContent");
        ContractDAO contractDAO = new ContractDAO();
        Contract newContract = (Contract) contractDAO.GetOneEntity(contractNo);
        newContract.SetContent(htnr);

        if(contractDAO.UpdateEntity(newContract)) {
            //更新合同内容成功
            //获取当前时间
            Calendar date = Calendar.getInstance();
            int day = date.get(Calendar.DAY_OF_MONTH);
            int month = date.get(Calendar.MONTH) + 1;
            int year = date.get(Calendar.YEAR);
            int hour = date.get(Calendar.HOUR_OF_DAY);
            int minute = date.get(Calendar.MINUTE);
            int second = date.get(Calendar.SECOND);
            String currentTime = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
            //更改operateflow表中数据
            OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
            //将合同定稿的状态从OPERATESTATUS_NO_FINISH改为OPERATESTATUS_HAVE_FINISH
            OperateFlow aOperateFlow = new OperateFlow();
            aOperateFlow.setContractNo(contractNo);
            aOperateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
            aOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);
            OperateFlow aNewOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(aOperateFlow);
            aNewOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
            aNewOperateFlow.setOperateDate(currentTime);
            boolean aUpdateOperateFlow=operateFlowDAO.UpdateEntity(aNewOperateFlow);
            //将合同审批的状态从OPERATESTATUS_NO_REDY改为OPERATESTATUS_NO_FINISH
            OperateFlow bOperateFlow = new OperateFlow();
            bOperateFlow.setContractNo(contractNo);
            bOperateFlow.setOperateType(StatusCode.OPERATETYPE_APPROVE);
            OperateFlow bNewOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(bOperateFlow);
            bNewOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);
            boolean bUpdateOperateFlow = operateFlowDAO.UpdateEntity(bNewOperateFlow);

            //更改status表数据
            StatusDAO statusDAO = new StatusDAO();
            Status aStatus = new Status();
            aStatus.SetcontractNo(contractNo);
            Status status = (Status) statusDAO.GetOneEntity(aStatus);
            status.SetcontractStatus(StatusCode.STATUS_FINISH_FINALIZE);
            status.SetfinishTime(currentTime);
            statusDAO.UpdateEntity(status);
            boolean UpdateStatus = statusDAO.UpdateEntity(status);




            //操作成功与否的提示
            if(aUpdateOperateFlow&&bUpdateOperateFlow&&UpdateStatus){
                request.setAttribute("result", "操作成功！");   //操作成功
            }else{
                request.setAttribute("result", "操作成功，但操作、状态、日志信息可能不完整！");
            }

        } else {
            //定稿失败

            request.setAttribute("result", "操作失败！");

        }


    }



}
