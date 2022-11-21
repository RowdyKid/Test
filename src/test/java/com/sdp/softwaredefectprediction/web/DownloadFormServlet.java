package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DownloadForm", value = "/DownloadForm")
public class DownloadFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();

    public DownloadFormServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<DownloadFile> downloadFiles = downloadFileService.queryDownloadFiles();
        request.setAttribute("downloadFiles", downloadFiles);
        request.getRequestDispatcher("Download.jsp").forward(request, response);

        System.out.println("正在获取下载文件表单...");
        String downloadFileId = request.getParameter("fileId");
        System.out.println(downloadFileId);
        if (downloadFileId!=null) {
            String downloadFileName = downloadFileService.queryDownloadFileById(Integer.valueOf(downloadFileId)).getFilename();
            String downloadFilePath = downloadFileService.queryDownloadFileById(Integer.valueOf(downloadFileId)).getFilepath();
            System.out.println(downloadFileName);
            System.out.println(downloadFilePath);

            request.getSession().setAttribute("downloadFileId", downloadFileId);
            request.getSession().setAttribute("downloadFileName", downloadFileName);
            request.getSession().setAttribute("downloadFilePath", downloadFilePath);

            response.sendRedirect("http://localhost:8085/demo_war_exploded/DownloadForm");

        }

    }

    public String getDownloadFileName(HttpServletRequest request){
        String downloadFileName = (String) request.getSession().getAttribute("downloadFileName");
        return downloadFileName;
    }

    public String getDownloadFilePath(HttpServletRequest request){
        String downloadFilePath = (String) request.getSession().getAttribute("downloadFilePath");
        return downloadFilePath;
    }

}
