package com.cms.contractmanagementsystem.web;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 文件名：ContractManageFinalize.java
 * 描述：合同签订
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
import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.utils.*;
@WebServlet("/op_SignContract")
public class op_SignContract extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public op_SignContract() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log log = new Log();
        log.setOperator((Integer) request.getSession().getAttribute("userid"));
        log.setContent("op_SignContract");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取提交的信息，写入数据库
        HttpSession session = request.getSession(true);
        int userNo = (Integer) request.getSession().getAttribute("userid");
        int contractNo = Integer.parseInt(request.getParameter("contractid"));
        String type=request.getParameter("type");
        if (type==null){
            ContractDAO contractDAO = new ContractDAO();
            Contract contract = (Contract) contractDAO.GetOneEntity(contractNo);
            int clientNo = contract.GetClientNo();
            ClientDAO clientdao = new ClientDAO();
            Client client=(Client)clientdao.GetOneEntity(clientNo);

            request.setAttribute("customerName",client.GetName());
            request.setAttribute("contractName",contract.GetName());
            request.setAttribute("contractId",contract.GetId());

            request.getRequestDispatcher("op_SignContract.jsp").forward(request, response);
        }
        else if(type.equals("Sign")) {
            //获取提交的信息，写入数据库
            String qdxx = request.getParameter("contractContent");
            //修改contract信息
            Contract aContract = new Contract();
            aContract.SetId(contractNo);
            ContractDAO contractDAO = new ContractDAO();
            Contract bContract = (Contract) contractDAO.GetOneEntity(aContract);
            bContract.SetSignerNo(userNo);
            if (contractDAO.UpdateEntity(bContract)) {
                //修改contract表成功，即操作成功
                //获取当前时间
                SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String currTime = time.format(new Date());
                //修改operate表数据
                OperateFlowDAO operateFlowDAO = new OperateFlowDAO();
                OperateFlow tempOperateFlow = new OperateFlow(0, contractNo, userNo, StatusCode.OPERATETYPE_SIGN, StatusCode.OPERATESTATUS_NO_FINISH, null, null);
                OperateFlow operateFlow = (OperateFlow) operateFlowDAO.GetOneEntity(tempOperateFlow);
                operateFlow.setOperateStatus(StatusCode.OPERATESTATUS_HAVE_FINISH);
                operateFlow.setContent(qdxx);
                operateFlow.setOperateDate(currTime);
                boolean updateOperateFlow = operateFlowDAO.UpdateEntity(operateFlow);

                //更改status表数据
                StatusDAO statusDAO = new StatusDAO();
                Status status = new Status();
                status.SetcontractNo(contractNo);
                status.SetcontractStatus(StatusCode.STATUS_FINISH_SIGN);
                status.SetfinishTime(currTime);
                boolean updateStatus = statusDAO.UpdateEntity(status);
                if (updateOperateFlow && updateOperateFlow && updateStatus) {
                    request.setAttribute("result", "操作成功！");   //操作成功
                    request.getRequestDispatcher("op_OperatorMainPage.jsp").forward(request, response);
                } else {
                    request.setAttribute("result", "操作成功，但操作、状态、日志信息可能不完整！");
                    request.getRequestDispatcher("op_OperatorMainPage.jsp").forward(request, response);
                }
            } else {
                //操作失败
                request.setAttribute("result", "操作失败！");
                request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);

            }
      }
        }

 }




