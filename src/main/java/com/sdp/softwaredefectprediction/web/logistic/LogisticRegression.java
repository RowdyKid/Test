package com.sdp.softwaredefectprediction.web.logistic;

import com.sdp.softwaredefectprediction.utils.logistic.Calculate;
import com.sdp.softwaredefectprediction.utils.logistic.Matrix;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Calendar;


//public class LogisticRegression extends LinearRegression {
public class LogisticRegression {

    public static final int METHOD_GRADIENT_DESCENT = 0;    // 梯度下降法
    public static final int METHOD_NORMAL_EQUATIONS = 1;    // 正规方程法

    private float[][] x;                    // 特征矩阵
    private float[][] parameters;            // 参数矩阵
    private float[][] y;                    // 标签矩阵(只用第一1列) -1 or 1
    private float step = 0.0001f;            // 步长step,即公式中的 a
//    private int iterationTimes = 10;        // 迭代次数

    private int m;                            // 特征矩阵x的行数
    private int n;                            // 特征矩阵x的列数
    private float[][] xT;                    // 特征矩阵x的转置矩阵	= Matrix.transpose(x);
    private float[][] a_times_xT;            // 梯度 a 与 xT 的乘积 = Matrix.constantProduct(a, xT);
    private float[][] parametersT;            // 参数矩阵的转置矩阵 = Matrix.transpose(parameters);

    private float[][] A;                    // 中间计算矩阵 A = new float[m][1];
    private float[][] g;                   // 中间计算矩阵 g = 1/1+e^(-A)
    private float[][] E;                    // 中间计算矩阵 E= new float[m][1];
    private float[][] tA;                    // 中间计算矩阵 A = new float[m][1];
    private float[][] tg;                   // 中间计算矩阵 g = 1/1+e^(-A)
    private float[][] tE;                    // 中间计算矩阵 E= new float[m][1];
    private float[][] a_times_xT_times_E;    // 中间计算矩阵 a*xT*E = new float[n][1];

    private float[][] testX;                // 测试数据集合x
    private float[][] testY;                // 测试数据集合y

    //    private int moitorCount = 100;                                                // 监控输出数据的数量
//    private ArrayList<HashMap> moitorTraining = new ArrayList<HashMap>();        // 训练监控数据
//    private ArrayList<HashMap> moitorTesting;                                    // 测试监控数据
//
//    private float totalErrorAvg = 0;        // 总体平均误差
//    private float totalErrorAvgPercent = 0;    // 总体平均误差比
    private float[][] parametersCopy;        // 参数拷贝
    private int iterationTimes;

    public LogisticRegression() {
    }

    public void setXY(float[][] x, float[][] y) throws Exception {
        setX(x);
        setY(y);
    }

    public void setX(float[][] x) throws Exception {
        this.x = x;
        this.xT = Matrix.transpose(x);
        this.m = x.length;
        this.n = x[0].length;

        this.parameters = new float[1][n];
        this.A = new float[m][1];
        this.g = new float[m][1];
        this.E = new float[m][1];
        this.a_times_xT_times_E = new float[n][1];
    }

    public void setY(float[][] y) {
        this.y = y;
    }

    public float[][] getX() {
        return this.x;
    }

    public float[][] getY() {
        return this.y;
    }


    public float[][] getParameters() {
        return parameters;
    }

    public float[][] getTestX() {
        return testX;
    }

    public float[][] getTestY() {
        return testY;
    }

    public void setTestXY(float [][]x,float[][]y) {
        int tm=x.length;
        this.tA = new float[tm][1];
        this.tg = new float[tm][1];
        this.tE = new float[tm][1];
        this.testX=x;
        this.testY=y;
    }



    public void setStep(float alpha) {
        this.step = alpha;
    }

    public void setIterationTimes(int iterationTimes) {
        this.iterationTimes = iterationTimes;
    }

    public float[] predict(float[][] parametersT, float[] yp) throws Exception{
        Matrix.times(x, parametersT, A);
        Calculate.sigmoid(A, g);
        Matrix.add(g, -1, y, E);
        for(int i=0;i<g.length;i++){
            if(g[i][0]/(1-g[i][0])>5)//类别不平衡
                yp[i]=1;
            else
                yp[i]=-1;
        }
        return yp;
    }

    public void train(float[] initParameters, float initStep, int iterationTimes) throws Exception {
        float[][] paramsBefore = new float[initParameters.length][1];
        float[][] paramsTBefore = new float[1][initParameters.length];
        float[] yp;
        float distAll = 0;
        float distAvg = 0;
        float distAvgBefore = 0;

        // 初始参数矩阵
        for (int i = 0; i < parameters[0].length; i++) {
            if (i < initParameters.length) parameters[0][i] = initParameters[i];
        }

        // 设置梯度
        this.setStep(initStep);

        // 设置迭代次数
        this.setIterationTimes(iterationTimes);

        // 转置参数矩阵
        parametersT = Matrix.transpose(parameters);

        // 中间矩阵 a * xT
        a_times_xT = Matrix.times(this.step, xT);

        double[] time=new double[iterationTimes];
        double[] accs = new double[iterationTimes];


        // 迭代
        for (int times = 0; times < iterationTimes; times++) {
            yp=new float[y.length];
            for(int i=0;i<y.length;i++){
                yp[i]=0;
            }
            predict(parametersT,yp);

            // 监控输出，求下降程度
            distAll = 0;
            for (int i = 0; i < x.length; i++) {
                if(y[i][0]!=yp[i]){
                    distAll ++;
                }

            }
            distAvg = 1-distAll / x.length ;  // j(θ)
            System.out.printf("迭代第%d次准确率：",times+1);
            System.out.println(distAvg);


            time[times]=times+1;
            accs[times]=distAvg;


            paramsBefore=parameters;
            paramsTBefore=parametersT;
            Matrix.times(a_times_xT, E, a_times_xT_times_E);
            Matrix.add(parametersT, -1, a_times_xT_times_E, parametersT);
            parameters = Matrix.transpose(parametersT);
            distAvgBefore = distAvg;

        }
        draw(time,accs);
    }

    public void test(float[][] fs, float[][] fs2) throws Exception {
        float error=0;
        Matrix.times(testX, parametersT, tA);
        Calculate.sigmoid(tA, tg);
        float[] yp = new float[testX.length];
        for(int i=0;i<testX.length;i++){
            if(tg[i][0]/(1-tg[i][0])>5)
                yp[i]=1;
            else
                yp[i]=-1;
            if (yp[i]!=testY[i][0])
                error++;
        }
        float acc=0;
        acc=1-error/testX.length;
        System.out.println("测试集准确率："+acc);

    }

    public void predictFile(float[][] X, String name) throws Exception{
        float[] Y=new float[X.length];
        int tm=X.length;
        float[][] pA = new float[tm][1];
        float[][] pg = new float[tm][1];
        Matrix.times(X, parametersT, pA);
        Calculate.sigmoid(pA, pg);
        for(int i=0;i<tm;i++){
            if(pg[i][0]/(1-pg[i][0])>5)
                Y[i]=1;
            else
                Y[i]=-1;
        }

        writeFile(Y,name);


    }

    private void writeFile(float[] Y,String sourceFile) throws IOException {

        Calendar calendar = Calendar.getInstance(); // get current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd_HHmm");
        String filePath="D:/DATA/" + formatter.format(calendar.getTime())+"pre"+".csv";
        File file = new File(filePath);
        //创建目录
        File fileParent = file.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        //删除并创建新文件
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileInputStream fis = new FileInputStream(sourceFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        FileWriter fw=new FileWriter(filePath, true);
        PrintWriter out=new PrintWriter(fw);

        String line="";
        line=br.readLine();
        out.write(line);
        out.println();
        line=br.readLine();

        int i=0;
        int clean=0,buggy=0;
        while(line!=null){
            if(Y[i]==-1){
                line=line+"clean";
                clean++;
            }
            else{
                line=line+"buggy";
                buggy++;
            }
            i++;
            out.write(line);
            out.println();
            line=br.readLine();
        }

        fw.close();
        out.close();
        br.close();
        fis.close();
        System.out.printf("该文件共有%d个buggy,%d个clean\n",buggy,clean);
        System.out.println("预测完成，文件保存成功");

    }

    public void draw(double[] x,double [] y){

        // 创建图表
        XYChart chart = QuickChart.getChart("逻辑回归", "迭代次数", "准确率", "y(x)", x, y);

        // 进行绘制
        new SwingWrapper<XYChart>(chart).displayChart();

    }

}
