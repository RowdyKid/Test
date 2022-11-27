package com.sdp.softwaredefectprediction.web.logistic;

import com.sdp.softwaredefectprediction.utils.logistic.MatrixDataFile;

import java.util.ArrayList;

public class LogisticRegressionTest  {


    public LogisticRegressionTest() {
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void testConcrete(String train,String test,String predict) throws Exception{

        // 数据文件
        MatrixDataFile testDataSource = new MatrixDataFile(test);
        MatrixDataFile trainDataSource = new MatrixDataFile(train);
        trainDataSource.featureScaling();
        testDataSource.featureScaling();
        ArrayList<float[][]> trainData = trainDataSource.get();
        ArrayList<float[][]> testData  = testDataSource.get();

        // 建立模型开始训练
        LogisticRegression LR = new LogisticRegression();
        LR.setXY(trainData.get(0),trainData.get(1));
        LR.setTestXY(testData.get(0),testData.get(1));
        LR.train(new float[]{1, 1,1,1,1}, 0.001f, 1);

        // 测试模型
        LR.test(testData.get(0), testData.get(1));
        
        MatrixDataFile preDataSource = new MatrixDataFile(predict,0);
        preDataSource.featureScaling();
        ArrayList<float[][]> preData  = preDataSource.get();
        LR.predictFile(preData.get(0),predict);
        

    }

    public static void main(String[] args) throws Exception {
    	String train="D:/DATA/train - 副本.csv";
    	String test="D:/DATA/test - 副本.csv";
    	String predict="D:/DATA/test - 副本 - 副本.csv";
        testConcrete(train,test,predict);
    }
    
}
