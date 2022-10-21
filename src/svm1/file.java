package svm1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class file {
	
    
	 public static int readFile02(String path) throws IOException {
	        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
	        List<String> list = new ArrayList<String>();
	        FileInputStream fis = new FileInputStream(path);
	        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
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
	            line = br.readLine();
	        }
	        br.close();
	        isr.close();
	        fis.close();
            return buggy;
     }
}