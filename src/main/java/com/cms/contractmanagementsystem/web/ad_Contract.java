package com.cms.contractmanagementsystem.web;

import com.cms.contractmanagementsystem.dao.ContractDAO;
import com.cms.contractmanagementsystem.dao.LogDaoImpl;
import com.cms.contractmanagementsystem.pojo.Log;
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
import java.util.List;

/**
 * Servlet implementation class ad_AddContract
 */

@WebServlet("/ad_Contract")

public class ad_Contract extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ad_Contract() {
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
        log.setContent("ad_Contract");
        log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new LogDaoImpl().saveLogInfo(log);

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Contract contract = new Contract();

        ArrayList<IEntity> contracts = new ContractDAO().GetEntitySet(contract,1,20);
        request.setAttribute("contracts", contracts);

        request.getRequestDispatcher("ad_WaittingForDistributeContract.jsp").forward(request, response);
    }
}

