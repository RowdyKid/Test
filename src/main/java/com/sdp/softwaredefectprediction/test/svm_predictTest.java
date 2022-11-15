package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.SVM.svm;
import com.sdp.softwaredefectprediction.utils.SVM.svm_model;
import com.sdp.softwaredefectprediction.utils.SVM.svm_predict;
import com.sdp.softwaredefectprediction.utils.SVM.svm_print_interface;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.*;

class svm_predictTest {
    private svm_predict svm_predict1;
    private static svm_print_interface svm_print_stdout = new svm_print_interface()
    {
        public void print(String s)
        {
            System.out.print(s);
        }
    };
    private static svm_print_interface svm_print_string = svm_print_stdout;
    @Before
    public void init(){
        svm_predict1 =new svm_predict();
    }
    @Test
    void info() {
        String s="test success";
        svm_print_string.print(s);
    }

    @Test
    void main() throws IOException {
        String test="D:\\aa\\PDE.txt";
        String out="D:\\aa\\out.txt";
        String model1="D:\\aa\\model_r.txt";
        int  predict_probability=0;
        BufferedReader input = new BufferedReader(new FileReader(test));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(out)));
        svm_model model = svm.svm_load_model(model1);
        svm_predict1.predict(input,output,model,predict_probability);
        System.out.println("test success");
    }
}