package test;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * �滻��ǩΪ1��-1
 *
 */

public class ReplaceCsv {
	
	public static void main(String[] args) throws Exception {
//		String source_path="D:/DATA/JDT.csv";
//		String source_path="D:/DATA/PDE.csv";
		String source_path="D:/DATA/Lucene.csv";
		replace(source_path);
		System.out.println("OK");
	}

	/**
	 * д��ѵ��������Լ�
	 * @param class_name
	 * @throws Exception 
	 */
	public static void replace(String source_path) throws Exception {
		
		// ���ļ�
		FileInputStream fis = new FileInputStream(source_path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		String newFile=source_path.replace(".csv", "1.csv");
		// д��ѵ����
		FileWriter fw = new FileWriter(newFile, true);
		PrintWriter out = new PrintWriter(fw);
		String line = "";
		String head;
		line = br.readLine();
		head=line;
		out.write(head);
		out.println();
		line = br.readLine();

		System.out.println(line);
		System.out.println(line.contains("buggy"));
		
		while (line != null) {
			
			if(line.contains("buggy")){
				List<String> list = Arrays.asList(line.split(","));
		        List arrList = new ArrayList(list);
		        arrList.remove((int)list.size() - 1);
		        arrList.add(Integer.toString(1));
				line=String.join(",", arrList);
			}
			else if(line.contains("clean")){
				List<String> list = Arrays.asList(line.split(","));
		        List arrList = new ArrayList(list);
		        arrList.remove((int)list.size() - 1);
		        arrList.add(Integer.toString(-1));
				line=String.join(",", arrList);
			}
			out.write(line);
			out.println();
			line = br.readLine();
		}
		
		// �ر��ļ�
		fw.close();
		out.close();
			
		br.close();
		fis.close();
	}
}