package com.cms.contractmanagementsystem.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 文件名：ContractManageFinalize.java
 * 描述：合同签订操作
 * 创建日期：2022-06-10
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

@WebServlet("/op_ApproveContract")
public class op_ApproveContract extends HttpServlet {

    public op_ApproveContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取提交的信息，写入数据库
        HttpSession session = request.getSession(true);
        int userNo = (Integer) request.getSession().getAttribute("userid");
        int contractNo = Integer.parseInt(request.getParameter("contractid"));

        //审批意见
        String spyj = request.getParameter("approvalOpinion");
        String option = request.getParameter("approveResult");
        String type = request.getParameter("type");
        if (type == null) {

            ContractDAO contractDao = new ContractDAO();
            Contract contract = (Contract) contractDao.GetOneEntity(contractNo);

            request.setAttribute("contractId", contract.GetId());
            request.setAttribute("contractName", contract.GetName());
            request.getRequestDispatcher("op_ApproveContract.jsp").forward(request, response);
        } else if (type.equals("approve")) {
            if (option.equals("1")) {
                System.out.println("审批通过");
                //审批通过
                //修改contract表状态
                Contract aContract = new Contract();
                aContract.SetId(contractNo);
                ContractDAO contractDAO = new ContractDAO();
                Contract bContract = (Contract) contractDAO.GetOneEntity(aContract);
                bContract.SetApproverNo(userNo);
                if (contractDAO.UpdateEntity(bContract)) {
                    //获取当前时间
                    SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String currTime = time.format(new Date());
                    //修改operateflow表状态
                    OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
                    OperateFlow aTempOperateFlow = new OperateFlow(0, contractNo, userNo, StatusCode.OPERATETYPE_APPROVE, StatusCode.OPERATESTATUS_NO_FINISH, null, null);
                    OperateFlow aOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(aTempOperateFlow);
                    aOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
                    aOperateFlow.setContent(spyj);
                    aOperateFlow.setOperateDate(currTime);
                    boolean aUpdateOperateFlow = operateFlowDAO.UpdateEntity(aOperateFlow);
                    //将operateflow表中签订状态从OPERATESTATUS_NO_READY改为OPERATESTATUS_NO_FINISH
                    OperateFlow bTempOperateFlow = new OperateFlow();
                    bTempOperateFlow.setContractNo(contractNo);
                    bTempOperateFlow.setOperateType(StatusCode.OPERATETYPE_SIGN);
                    bTempOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_READY);
                    OperateFlow bOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(bTempOperateFlow);
                    bOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);
                    boolean bUpdateOperateFlow = operateFlowDAO.UpdateEntity(bOperateFlow);
                    //修改Status表状态
                    StatusDAO statusDAO = new StatusDAO();
                    Status aStatus = new Status();
                    aStatus.SetcontractNo(contractNo);
                    Status status = (Status) statusDAO.GetOneEntity(aStatus);
                    status.SetcontractStatus(StatusCode.STATUS_FINISH_APPROVE);
                    status.SetfinishTime(currTime);
                    boolean updateStatus = statusDAO.UpdateEntity(status);
                    //把操作信息写入日志
                    request.setAttribute("result", "操作成功！");
                    request.getRequestDispatcher("op_OperatorMainPage.jsp").forward(request, response);

                } else {
                    //修改contract表状态不成功，即操作失败
                    request.setAttribute("result", "操作失败！");
                }
            } else {
                //审批不通过
                //修改contract表状态
                Contract aContract = new Contract();
                aContract.SetId(contractNo);
                ContractDAO contractDAO = new ContractDAO();
                Contract bContract = (Contract) contractDAO.GetOneEntity(aContract);
                bContract.SetApproverNo(userNo);
                if (contractDAO.UpdateEntity(bContract)) {
                    //获取当前时间
                    SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String currTime = time.format(new Date());
                    //修改operateflow表状态
                    OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
                    OperateFlow aTempOperateFlow = new OperateFlow(0, contractNo, userNo, StatusCode.OPERATETYPE_APPROVE, StatusCode.OPERATESTATUS_NO_FINISH, null, null);
                    OperateFlow aOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(aTempOperateFlow);
                    aOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_REJECT);
                    aOperateFlow.setContent(spyj);
                    aOperateFlow.setOperateDate(currTime);
                    boolean aUpdateOperateFlow = operateFlowDAO.UpdateEntity(aOperateFlow);
                    //将operateflow表中定稿状态从OPERATESTATUS_HAVE_FINISH改为OPERATESTATUS_NO_FINISH
                    OperateFlow bTempOperateFlow = new OperateFlow();
                    bTempOperateFlow.setContractNo(contractNo);
                    bTempOperateFlow.setOperateType(StatusCode.OPERATETYPE_FINALIZE);
                    bTempOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
                    OperateFlow bOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(bTempOperateFlow);
                    bOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_NO_FINISH);
                    boolean bUpdateOperateFlow = operateFlowDAO.UpdateEntity(bOperateFlow);
                    //修改Status表状态
                    StatusDAO statusDAO = new StatusDAO();
                    Status aStatus = new Status();
                    aStatus.SetcontractNo(contractNo);
                    Status status = (Status) statusDAO.GetOneEntity(aStatus);
                    status.SetcontractStatus(StatusCode.STATUS_FINISH_COUNTERSIGN);
                    status.SetfinishTime(currTime);
                    boolean updateStatus = statusDAO.UpdateEntity(status);
                    request.getRequestDispatcher("op_OperatorMainPage.jsp").forward(request, response);
                } else {
                    //修改contract表状态不成功，即操作失败
                    request.setAttribute("result", "操作失败！");
                }
            }
        }
    }
}

