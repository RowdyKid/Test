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

import static com.sdp.softwaredefectprediction.web.logistic.LogisticRegressionTest.testConcrete;


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

        System.out.println("??????????????????...");
        String model = request.getParameter("model");
        String fileId = request.getParameter("fileId");

        System.out.println(model);
        System.out.println(fileId);

        if (model != null && fileId != null){
            if (model.equals("logistic")){

                String fileType = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFiletype();
                request.getSession().setAttribute("fileType", fileType);
                if (fileType.equals("csv")){
                    System.out.println("????????????????????????...");
                    String filepath1 = attachmentService.queryAttachmentById(Integer.valueOf(fileId)).getFilepath();
                    System.out.println(filepath1);

                    String train1="D:/DATA/train - ??????.csv";
                    String test1="D:/DATA/test - ??????.csv";
                    String predict1 = filepath1;
                    try {
                        testConcrete(train1,test1,predict1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    String message = "??????????????????????????????logistic??????????????????csv???????????????";
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
                    //???????????????????????????????????????
                    String filename = formatter.format(calendar.getTime())+"pre"+".txt";
                    String filePath = "C:/Users/Cinderella/IdeaProjects/Test/src/main/webapp/assets/predictFiles/" + filename;
                    String downloadPath = "/assets/predictFiles/"+filename;

                    //??????????????????
                    SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timeStr = currTime.format(new Date());

                    //???????????????
                    downloadFileService.addDownloadFile(new DownloadFile(null,filename,downloadPath, Timestamp.valueOf(timeStr)));

                    //??????????????????
                    String model_r="C:/Users/Cinderella/IdeaProjects/Test/src/main/webapp/assets/predictFiles/"+formatter.format(calendar.getTime())+"model_r"+".txt";
                    String out=filePath;
                    int buggy=0;
                    file f=new file();
                    String[] arg = { train2, model_r }; // ??????SVM?????????????????????/ //???????????????????????????
                    String[] parg = { predict2, model_r, out}; // ?????????????????????????????????
                    System.out.println("........SVM????????????..........");

                    // ????????????????????????
                    svm_train t = new svm_train();
                    // ???????????????????????????????????????
                    svm_predict p = new svm_predict();
                    t.main(arg); // ??????
                    p.main(parg); // ??????
                    buggy=f.readFile02(out);
                    System.out.println("???????????????????????????"+buggy);
                }else {
                    String message = "??????????????????????????????SVM??????????????????txt???????????????";
                    System.out.println(message);
                    request.setAttribute("message",message);
                }
            }
            else {
                System.out.println("????????????????????????");
            }
        }else {
            System.out.println("??????????????????");
        }

        request.getRequestDispatcher("Prediction.jsp").forward(request, response);

    }
}
