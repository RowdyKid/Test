package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.web.SVM.file;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class fileTest {

    @Test
    void readFile02() throws IOException {
        file f=new file();
        int buggy;
        String out="D:\\aa\\out.txt";
        buggy= file.readFile02(out);
        System.out.println("该预测集缺陷个数为"+buggy);
    }
}