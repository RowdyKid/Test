package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.dao.AttachmentDaoImpl;
import com.sdp.softwaredefectprediction.pojo.Attachment;
import com.sdp.softwaredefectprediction.service.AttachmentService;
import com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/prediction")
public class Prediction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AttachmentService attachmentService = new AttachmentServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prediction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Attachment> attachments = attachmentService.queryAttachments();
        request.setAttribute("attachments", attachments);
        request.getRequestDispatcher("Prediction.jsp").forward(request, response);

    }
}
