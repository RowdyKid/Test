package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.dao.*;
import com.sdp.softwaredefectprediction.pojo.Log;
import com.sdp.softwaredefectprediction.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/ad_AddContract")

public class ad_AddContract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ad_AddContract() {
        super();
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Log log = new Log();
        log.setOperator((Integer) request.getSession().getAttribute("userid"));
        log.setContent("ad_AddContract");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if (type == null) {
            request.getRequestDispatcher("ad_AddContract.jsp").forward(request, response);
        } else if (type.equals("addOper")) {
            //获取前台数据
            HttpSession session = request.getSession(true);
            String name = request.getParameter("contractName");
            String startTime = request.getParameter("startTime");
            String finishTime = request.getParameter("endTime");
            String content = request.getParameter("contractContent");
            String clientName = request.getParameter("customerName");
            //控制台输出合同名称
            System.out.println(name);
            System.out.println(startTime);
            System.out.println(finishTime);
            System.out.println(content);
            System.out.println(clientName);

            int drafterNo = (Integer) session.getAttribute("userid");

            //写入数据库
            //Contract tempContract = new Contract(0, name, 6, startTime, finishTime, content, drafterNo);


                //获取当前时间
                SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStr = currTime.format(new Date());


                //把操作信息写入日志
                //boolean addLog=new LogDAO().AddEntity(new Log(0,drafterNo,"起草了一份合同，合同编号："+aContract.GetId(),currTime.format(new Date())));

                //上传附件
                String filename = request.getParameter("textfield");
                if (filename != null) {
                    //上传指定文件
                    Attachment attachment = new Attachment(0,filename,filename,null,timeStr);
                    AttachmentDAOC attachmentDAO = new AttachmentDAOC();
                    attachmentDAO.AddEntity(attachment);
                }

            request.getRequestDispatcher("ad_AdminMainPage.jsp").forward(request, response);

        }
    }
}

