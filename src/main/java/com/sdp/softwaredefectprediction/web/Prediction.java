package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.Attachment;
import com.sdp.softwaredefectprediction.service.AttachmentService;
import com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl;
import com.sdp.softwaredefectprediction.web.SVM.file;
import com.sdp.softwaredefectprediction.web.SVM.svm_predict;
import com.sdp.softwaredefectprediction.web.SVM.svm_train;

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

                String filepath1 = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFilepath();
                System.out.println(filepath1);

                String train1="D:/DATA/train - 副本.csv";
                String test1="D:/DATA/test - 副本.csv";
                String predict1 = filepath1;
                try {
                    testConcrete(train1,test1,predict1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }else if (model.equals("SVM")) {

                String filepath2 = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFilepath();

                String train2="D:/DATA/JDT11.txt";
                String model_r="D:/DATA/model_r.txt";
                String predict2=filepath2;
                String out="D:/DATA/out.txt";
                int buggy=0;
                file f=new file();
                String[] arg = { train2, model_r }; // 存放SVM通过训练数据训/ //练出来的模型的路径
                String[] parg = { predict2, model_r, out}; // 生成的结果的文件的路径
                System.out.println("........SVM运行开始..........");

                // 创建一个训练对象
                svm_train t = new svm_train();
                // 创建一个预测或者分类的对象
                svm_predict p = new svm_predict();
                t.main(arg); // 调用
                p.main(parg); // 调用
                buggy=f.readFile02(out);
                System.out.println("该预测集缺陷个数为"+buggy);
            }
            else {
                System.out.println("模型选择出错啦！");
            }
        }

    }
}
