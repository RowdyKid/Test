package test;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.logging.Level;

@SuppressWarnings("unused")
public class FormatTrans {

    private BufferedReader br;
    private String path;
    private int COLUMN_NUM=62;
    public FormatTrans(String filepath) throws FileNotFoundException {
        this.path=filepath;
        br = new BufferedReader(new FileReader(new File(path)));
    }

    /**'
     * 从文件中提取分类名称到数组中
     * @return
     */
    public String[] getAttributeToArray() throws IOException {
        String attributeStr = br.readLine();
        String[] atts = attributeStr.split(",");
        return atts;
    }

    /**
     * 从文件中提取数据到数组
     * @return
     * @throws IOException
     */
    public Object[][] getDataToArray() throws IOException {
        String line="";
        ArrayList<Object[]> lineList = new ArrayList<>();
        while ((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line, ",");
            Object[] currCol = new Object[COLUMN_NUM];
            for (int i = 0; i < COLUMN_NUM; i++) {
                if (st.hasMoreTokens()){
                    currCol[i]=st.nextToken();
                }
            }
            lineList.add(currCol);
        }
        Object[][] col = new Object[lineList.size()][COLUMN_NUM];
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                col[i][j]=lineList.get(i)[j];
            }
        }
        br.close();
        return col;
    }


    
//    public static void main(String[] args) throws IOException {
//        FormatTrans ft = new FormatTrans("D:\\DATA\\train.csv");
//        Object[][] dataToArray = ft.getDataToArray();
////        ft.getAttributeToArray();
////        Object[][] dataToArray = ft.getDataToArray();
//        for (int i = 0; i < dataToArray.length; i++) {
//            for (int i1 = 0; i1 < dataToArray[i].length; i1++) {
//                System.out.print(dataToArray[i][i1]+",");
//            }
//            System.out.println();
//        }
//    }
}

