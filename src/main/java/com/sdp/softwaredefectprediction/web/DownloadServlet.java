package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;
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

@WebServlet(name = "Download", value = "/Download")
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DownloadServlet(){
        super();
    }

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String downloadFileName = (String) request.getSession().getAttribute("downloadFileName");
        String downloadFilePath = (String) request.getSession().getAttribute("downloadFilePath");

//        String downloadFileName = "10-21_1547pre.csv";
//        String downloadFilePath = "D:/DATA/"+downloadFileName;

//        String downloadFileName = "10-21_1547pre.csv";
//        String downloadFilePath = "/assets/file/"+downloadFileName;

        System.out.println("get到文件名"+downloadFileName);
        System.out.println("get到文件路径"+downloadFilePath);

        if (downloadFileName!=null && downloadFilePath!=null){
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
