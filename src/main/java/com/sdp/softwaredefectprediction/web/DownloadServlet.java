package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;
import com.sdp.softwaredefectprediction.web.logistic.LogisticRegression;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


@WebServlet(name = "Download", value = "/Download")
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();

    public DownloadServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        this.doPost(request, response);

        System.out.println("正在获取下载表单...");
        String fileId = request.getParameter("fileId");
        System.out.println(fileId);

        if (fileId != null){
            String downloadFileName = downloadFileService.queryDownloadFileById(Integer.valueOf(fileId)).getFilename();
            String downloadFilePath = downloadFileService.queryDownloadFileById(Integer.valueOf(fileId)).getFilepath();

            if (downloadFileName!=null && downloadFilePath!=null){

                System.out.println(downloadFileName);
                System.out.println(downloadFilePath);

                ServletContext servletContext = getServletContext();

                String mimeType = servletContext.getMimeType(downloadFilePath);
                System.out.println("下载的文件类型："+ mimeType);

                response.setContentType(mimeType);
                response.setHeader("Content-Disposition","attachment;filename="+ downloadFileName);

                InputStream resourceAsStream = servletContext.getResourceAsStream(downloadFilePath);
                OutputStream outputStream = response.getOutputStream();

                IOUtils.copy(resourceAsStream,outputStream);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<DownloadFile> downloadFiles = downloadFileService.queryDownloadFiles();
        request.setAttribute("downloadFiles", downloadFiles);
        request.getRequestDispatcher("Download.jsp").forward(request, response);

    }

}
