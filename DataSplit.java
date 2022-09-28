package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * 
 * 分割数据集，标签1为buggy，-1为clean
 *
 */

public class DataSplit {
	
	public static double test_percent = 0.2;
	public static void main(String[] args) throws Exception {
		String source_path="D:/DATA/JDT1.csv";
		String source_path2="D:/DATA/PDE1.csv";
		String train_path="D:/DATA/train.csv";
		String test_path="D:/DATA/test.csv";
		splitData(source_path,source_path2,train_path,test_path);
		System.out.println("OK");
	}
	/**
	 * 写入训练集与测试集
	 * @param class_name
	 * @throws Exception 
	 */
	public static void splitData(String source_path,String source_path2, String train_path,String test_path) throws Exception {
		
		long allNum = getLineNumber(source_path);
		int end = (int) (((int)allNum-1) * (1 - test_percent));
		System.out.println(end);
		
		long allNum2 = getLineNumber(source_path2);
		int end2 = (int) (((int)allNum2-1) * (1 - test_percent));
		System.out.println(end2);
		// 打开文件
		FileInputStream fis = new FileInputStream(source_path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		FileInputStream fis2 = new FileInputStream(source_path2);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fis2, "UTF-8"));
		// 写入训练集
		FileWriter fw = new FileWriter(test_path, true);
		PrintWriter out = new PrintWriter(fw);
		String line = "";
		int count = 0;
		String head;
		line = br.readLine();
		head=line;
		System.out.println(line);
		System.out.println(head);
		out.write(head);
		out.println();
		line = br.readLine();

		
		while (line != null) {
			out.write(line);
			out.println();
			count ++;
			if (count == end) 
				break;
			line = br.readLine();
		}
		count=0;	
		line = br1.readLine();
		line = br1.readLine();
		while ((line != null)) {
			out.write(line);
			out.println();
			count ++;
			if (count == end2) 
				break;
			line = br.readLine();
		}
		// 关闭文件
		fw.close();
		out.close();
		// 写入测试集
		FileWriter fw2 = new FileWriter(train_path, true);
		PrintWriter out2 = new PrintWriter(fw2);
		out2.write(head);
		out2.println();
		while ((line = br.readLine()) != null) {
			out2.write(line);
			out2.println();
		}
		while ((line = br1.readLine()) != null) {
			out2.write(line);
			out2.println();
		}
		// 关闭文件
		fw2.close();
		out2.close();		
		br.close();
		fis.close();
	}
	/**
	 * 获取文件的行数
	 * @param file
	 * @return
	 */
	public static long getLineNumber(String path) {
		File file = new File(path);
	    if (file.exists()) {
	        try {
	            FileReader fileReader = new FileReader(file);
	            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
	            lineNumberReader.skip(Long.MAX_VALUE);
	            long lines = lineNumberReader.getLineNumber() + 1;
	            fileReader.close();
	            lineNumberReader.close();
	            return lines;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}
	
	

}
