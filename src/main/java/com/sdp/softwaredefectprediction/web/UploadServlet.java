package com.sdp.softwaredefectprediction.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        System.out.println("文件上传");
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//
//        String username = request.getParameter("username");
//        System.out.println("username" + username);
//
//        Part part = request.getPart("dataFile");
//        String fileName = part.getSubmittedFileName();
//
//        String filePath = request.getServletContext().getRealPath("/");
//
//        part.write(filePath+"/"+fileName);
        if (ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list){
                    System.out.println("表单项的name属性值" + fileItem.getFieldName());
                    System.out.println("上传的文件名" + fileItem.getName());
                    fileItem.write(new File("e:\\" + fileItem.getName()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        ServletInputStream inputStream = req.getInputStream();
//
//        byte[] buffer = new byte[1024000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer,0,read));

    }

}
