package com.sdp.softwaredefectprediction.web;

import com.sdp.softwaredefectprediction.pojo.Attachment;
import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.AttachmentService;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;
import com.sdp.softwaredefectprediction.web.SVM.file;
import com.sdp.softwaredefectprediction.web.SVM.svm_predict;
import com.sdp.softwaredefectprediction.web.SVM.svm_train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Attachment> attachments = attachmentService.queryAttachments();
        request.setAttribute("attachments", attachments);

        System.out.println("正在获取表单...");
        String model = request.getParameter("model");
        String fileId = request.getParameter("fileId");

        System.out.println(model);
        System.out.println(fileId);

        if (model != null && fileId != null){
            if (model.equals("logistic")){

                String fileType = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFiletype();
                request.getSession().setAttribute("fileType", fileType);
                if (fileType.equals("csv")){
                    System.out.println("恭喜你，开始预测...");
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
                }else {
                    String message = "文件格式错误！若使用logistic算法，请上传csv格式文件！";
                    System.out.println(message);
                    request.setAttribute("message",message);

                }

            }else if (model.equals("SVM")) {

                String fileType = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFiletype();
                request.getSession().setAttribute("fileType", fileType);
                if (fileType.equals("txt")){
                    String filepath2 = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFilepath();
                    String train2="D:/DATA/JDT11.txt";

                    String predict2=filepath2;
                    Calendar calendar = Calendar.getInstance(); // get current instance of the calendar
                    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd_HHmm");
                    //获取生成的文件名与文件路径
                    String filename = formatter.format(calendar.getTime())+"pre"+".txt";
                    String filePath = "C:/Users/Cinderella/Desktop/demo/src/main/webapp/assets/predictFiles/" + filename;
                    String downloadPath = "/assets/predictFiles/"+filename;

                    //获取当前时间
                    SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timeStr = currTime.format(new Date());

                    //插入数据库
                    downloadFileService.addDownloadFile(new DownloadFile(null,filename,downloadPath, Timestamp.valueOf(timeStr)));

                    //输出模型文件
                    String model_r="C:/Users/Cinderella/Desktop/demo/src/main/webapp/assets/predictFiles/"+formatter.format(calendar.getTime())+"model_r"+".txt";
                    String out=filePath;
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
                }else {
                    String message = "文件格式错误！若使用SVM算法，请上传txt格式文件！";
                    System.out.println(message);
                    request.setAttribute("message",message);
                }
            }
            else {
                System.out.println("模型选择出错啦！");
            }
        }else {
            System.out.println("请选择文件！");
        }

        request.getRequestDispatcher("Prediction.jsp").forward(request, response);

    }
}
