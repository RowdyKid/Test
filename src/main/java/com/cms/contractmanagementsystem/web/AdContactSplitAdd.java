package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.dao.ClientDAO;
import com.cms.contractmanagementsystem.dao.ContractDAO;
import com.cms.contractmanagementsystem.dao.LogDaoImpl;
import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.utils.Client;
import com.cms.contractmanagementsystem.utils.Contract;
import com.cms.contractmanagementsystem.utils.IEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/AdContactSplitAdd")
public class AdContactSplitAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdContactSplitAdd() {
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
        log.setContent("ad_LogManager");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String signerone = request.getParameter("signerone");
        String signertwo = request.getParameter("signertwo");
        String signerthree = request.getParameter("signerthree");
        String id = request.getParameter("id");

        if(null == signerone || null == signertwo || null == signerthree){
            request.getRequestDispatcher("ad_AllocateContract.jsp").forward(request, response);
        }

        Contract contract = new Contract();
        contract.setId(Integer.parseInt(id));
        contract.setCounterSignerNo(Integer.parseInt(signerone));
        contract.setApproverNo(Integer.parseInt(signertwo));
        contract.setSignerNo(Integer.parseInt(signerthree));
        new ContractDAO().UpdateEntity(contract);

        request.getRequestDispatcher("/ad_Contract").forward(request, response);
    }
}

