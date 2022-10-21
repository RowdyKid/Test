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

import static com.sdp.softwaredefectprediction.test.LogisticRegressionTest.testConcrete;


@WebServlet(name = "Prediction", value = "/Prediction")
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

        System.out.println("正在获取表单...");
        String model = request.getParameter("model");
        String fileId = request.getParameter("fileId");

        System.out.println(model);
        System.out.println(fileId);

        if (model != null && fileId != null){
            if (model.equals("logistic")){

                String filepath = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFilepath();
                System.out.println(filepath);

                String train="D:/DATA/train - 副本.csv";
                String test="D:/DATA/test - 副本.csv";
                String predict=filepath;
                try {
                    testConcrete(train,test,predict);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }else if (model.equals("SVM")) {
            }
            else {
                System.out.println("模型选择出错啦！");
            }
        }

    }
}
