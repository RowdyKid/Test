
package demo.ai.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Common {

	public Common() {
	}

	public static ArrayList<String> readFileToArrayList(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		String[] colNames={"CvsEntropy","WCHU_wmc","WCHU_rfc","LDHH_rfc","class"};
		int[] colNum=new int[5];
		String[] features;
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 不读header
			tempString = reader.readLine();
			
			
			//读取指定列名
			features=tempString.split(",");
		
			for(int i=0;i<colNames.length;++i){
				for(int j=0;j<features.length;++j){
					if(colNames[i].compareTo(features[j])==0){
						colNum[i]=j;
					    break;
					}
				}
			}
			
			while ((tempString = reader.readLine()) != null) {
				features=tempString.split(",");
				tempString=features[colNum[0]];
				for(int i=1;i<colNum.length;++i){
					tempString=tempString+","+features[colNum[i]];
				}
				result.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}
	
	public static ArrayList<String> readFileToArrayListp(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		String[] colNames={"CvsEntropy","WCHU_wmc","WCHU_rfc","LDHH_rfc","class"};
		int[] colNum=new int[5];
		String[] features;
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 不读header
			tempString = reader.readLine();
			
			
			//读取指定列名
			features=tempString.split(",");
		
			for(int i=0;i<colNames.length;++i){
				for(int j=0;j<features.length;++j){
					if(colNames[i].compareTo(features[j])==0){
						colNum[i]=j;
					    break;
					}
				}
			}
			
			while ((tempString = reader.readLine()) != null) {
				features=tempString.split(",");
				tempString=features[colNum[0]];
				for(int i=1;i<colNum.length-1;++i){
					tempString=tempString+","+features[colNum[i]];
				}
				result.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}
}