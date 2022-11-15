package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.SVM.svm_train;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class svm_trainTest {
    private svm_train svm_train1;
    private String[] argv={"D:\\aa\\PDE.txt","D:\\aa\\model_r.txt"};
    @Before
    public void init(){
        svm_train1 =new svm_train();
    }
    @Test
    public void main() throws IOException{
        svm_train t = new svm_train();
        t.run(argv);
        System.out.println("test success");

    }
}