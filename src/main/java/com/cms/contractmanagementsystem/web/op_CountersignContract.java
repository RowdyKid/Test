package com.cms.contractmanagementsystem.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

@WebServlet("/op_CountersignContract")
public class op_CountersignContract extends HttpServlet {

    public op_CountersignContract() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log log = new Log();
        log.setOperator((Integer) request.getSession().getAttribute("userid"));
        log.setContent("op_CountersignContract");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取提交的信息，写入数据库
        HttpSession session = request.getSession(true);
        int userNo = (Integer) request.getSession().getAttribute("userid");
        int contractNo = Integer.parseInt(request.getParameter("contractid"));

        //会签意见
        String hqyj = request.getParameter("countersignOpinion");
        String type = request.getParameter("type");
        if (type == null) {

            ContractDAO contractDao = new ContractDAO();
            Contract contract = (Contract) contractDao.GetOneEntity(contractNo);
            request.setAttribute("contractId", contract.GetId());
            request.setAttribute("contractName", contract.GetName());
            request.getRequestDispatcher("op_CountersignContract.jsp").forward(request, response);
        } else if (type.equals("countersign")) {
            //会签通过
            //修改contract表状态
            Contract aContract = new Contract();
            aContract.SetId(contractNo);
            ContractDAO contractDAO = new ContractDAO();
            Contract bContract = (Contract) contractDAO.GetOneEntity(aContract);
            bContract.SetCounterSignerNo(userNo);
            if (contractDAO.UpdateEntity(bContract)) {
                //获取当前时间
                SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String currTime = time.format(new Date());
                //修改operateflow表状态
                OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
                OperateFlow aTempOperateFlow = new OperateFlow(0, contractNo, userNo, StatusCode.OPERATETYPE_COUNTERSIGN, StatusCode.OPERATESTATUS_NO_FINISH, null, null);
                OperateFlow aOperateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(aTempOperateFlow);
                aOperateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
                aOperateFlow.setContent(hqyj);
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
                status.SetcontractStatus(StatusCode.STATUS_FINISH_COUNTERSIGN);
                status.SetfinishTime(currTime);
                boolean updateStatus = statusDAO.UpdateEntity(status);

                response.sendRedirect("WaitingCountersignContract");
               // request.getRequestDispatcher("op_OperatorMainPage.jsp").forward(request, response);
            } else {
                request.setAttribute("result", "操作失败！");
                request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            }
        }
    }
}

