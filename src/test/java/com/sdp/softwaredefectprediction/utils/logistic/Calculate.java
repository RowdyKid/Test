package com.sdp.softwaredefectprediction.utils.logistic;

public class Calculate {
    private float[][] g;
    public Calculate() {

    }

    /**
     *
     * @param A
     * @param g
     * @return 返回每列的 1/1+e^(-x)值
     * @throws Exception
     */
    public static float[][] sigmoid(float[][] A, float[][] g) throws Exception {
        int rows = Matrix.rows(A);
        for (int i = 0; i < rows; i++) {
            g[i][0] = 1 / (float) (1 + Math.exp(-A[i][0]));        
        }
        return g;
    }

    /**
     * 给中间值g赋值
     * @param x
     * @throws Exception
     */
    public void setG(float[][] x) throws Exception {
        int m = x.length;
        this.g = new float[m][1];
    }

//    public void train() throws Exception{
//        float[][] A = new float[3][1];
//        setG(A);
//        A[0]= new float[]{1};
//        A[1]= new float[]{2};
//        A[2]= new float[]{3};
//        sigmoid(A, g);
//        for(int i=0;i<g.length;i++){
//            for(int j=0;j<g[0].length;j++){
//            }
//        }
//    }
}
