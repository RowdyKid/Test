package com.sdp.softwaredefectprediction.web.SVM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class file {
	
    
	 public static int readFile02(String path) throws IOException {
	        // ʹ��һ���ַ����������洢�ı��е�·�� ��Ҳ����String []����
	        List<String> list = new ArrayList<String>();
	        FileInputStream fis = new FileInputStream(path);
	        // ��ֹ·������   ���utf-8 ����  ��GBK     eclipse�ﴴ����txt  ��UTF-8���ڵ������Լ�������txt  ��GBK
	        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	        BufferedReader br = new BufferedReader(isr);
	        int clean = 0;
	        int buggy = 0;
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            if (line.equals("1.0")) {
	                clean++;
	            }
	            else buggy++;
	            //line = br.readLine();
	        }
	        br.close();
	        isr.close();
	        fis.close();
            return buggy;
     }
}