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
 * Servlet implementation class DraftContract
 */

@WebServlet("/DraftContract")

public class DraftContract extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public DraftContract(){
        super();
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //TODO
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if(type == null){
            //截止2022.06.07 15：02 dao与utils文件夹中未整理好client
            //request.setAttribute("clients", new ClientDAO().GetEntitySet(new Client()));
            request.getRequestDispatcher("DraftContract.jsp").forward(request, response);
        } else if (type.equals("draftOper")) {

            //获取前台数据
            HttpSession session = request.getSession(true);
            String name = request.getParameter("contractName");
            String startTime = request.getParameter("startTime");
            String finishTime = request.getParameter("endTime");
            String content=request.getParameter("contractContent");
            String clientName=request.getParameter("customerName");
            int drafterNo=(Integer)session.getAttribute("id");

            //截止2022.06.07 15：02 dao与utils文件夹中未整理好client
            //根据获得的客户名获取客户ID
            //Client aClient = new Client();
            //aClient.SetName(clientName);
            //Client client=(Client) new ClientDAO().GetOneEntity(aClient);

            //写入数据库
            //Contract tempContract=new Contract(0, name, client.GetId(), startTime, finishTime, content, drafterNo);
            ContractDAO contractDAO = new ContractDAO();
            //if(contractDAO.AddEntity(tempContract)){

                //获取当前时间
                SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStr = currTime.format(new Date());

                //写入数据库oprateflow表
                //Contract aContract = (Contract) contractDAO.GetOneEntity(tempContract);
                //OperateFlow operateFlow = new OperateFlow(0, aContract.GetId(), drafterNo, StatusCode.OPERATETYPE_DRAFT, StatusCode.OPERATESTATUS_HAVE_FINISH, null, timeStr);
                //boolean addOperateFlow = new OperateFlowDAO().AddEntity(operateFlow);
                //OperateFlow bOperateFlow = new OperateFlow(0, aContract.GetId(), drafterNo, StatusCode.OPERATETYPE_FINALIZE, StatusCode.OPERATESTATUS_NO_READY, null, timeStr);
                //boolean is=new OperateFlowDAO().AddEntity(bOperateFlow);

                //写入数据库status表
                Status status=new Status();
                //status.SetcontractNo(aContract.GetId());
                status.SetcontractStatus(StatusCode.STATUS_FINISH_DRAFT);
                status.SetfinishTime(timeStr);
                boolean addStatus=new StatusDAO().AddEntity(status);

                //把操作信息写入日志
                //boolean addLog=new LogDAO().AddEntity(new Log(0,drafterNo,"起草了一份合同，合同编号："+aContract.GetId(),currTime.format(new Date())));

                //上传附件
                String filename=request.getParameter("textfield");
                if(filename!=null){
                    //上传指定文件
                }

                //if(addOperateFlow&&addStatus
                        //&&addLog
                //){
                //    request.setAttribute("result", "起草成功！");   //合同起草成功
                //}else{
                //    request.setAttribute("result", "合同插入成功，但操作、状态、日志信息可能不完整！");
                //}
            //} else {
                //起草失败
            //    request.setAttribute("result", "起草失败！");
            //}

            //截止2022.06.07 15：02 dao与utils文件夹中未整理好client
            //request.setAttribute("clients", new ClientDAO().GetEntitySet(new Client()));
            request.getRequestDispatcher("ContractManageDraft.jsp").forward(request, response);

        }

    }

}
