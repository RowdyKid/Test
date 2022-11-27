package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.service.AttachmentService;
import com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAttachment")

public class DeleteAttachment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request, response);
        System.out.println(request.getParameter("id"));
        AttachmentService attachmentService = new AttachmentServiceImpl();
        attachmentService.deleteAttachmentById(Integer.valueOf(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/Predict");
    }
}

