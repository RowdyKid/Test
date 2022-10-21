package com.sdp.softwaredefectprediction.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

       String downloadFilename = "city.png";

       ServletContext servletContext = getServletContext();

       String mimeType = servletContext.getMimeType("/assets/imgs/"+downloadFilename);
       System.out.println("下载的文件类型："+ mimeType);

       resp.setContentType(mimeType);
       resp.setHeader("Content-Disposition","attachment;filename="+ downloadFilename);

       InputStream resourceAsStream = servletContext.getResourceAsStream("/assets/imgs/"+downloadFilename);
       OutputStream outputStream = resp.getOutputStream();

       IOUtils.copy(resourceAsStream,outputStream);

    }

}
