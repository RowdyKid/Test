package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.logistic.Matrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;

class MatrixTest {

    private Matrix matrix;

    @Before
    public void init() {
        matrix = new Matrix();
    }

    @Test
    void copy() throws Exception {
        float[][] m = {{2, 3}, {3, 4}};
        float[][] result = new float[m.length][m[0].length];
        matrix.copy(m, result);
        Assert.assertArrayEquals(m, result);
    }

    @Test
    void rows() {
        float[][] m = {{2, 3}, {3, 4}};
        int result = matrix.rows(m);
        int expect = m.length;
        Assert.assertEquals(result, expect);
    }

    @Test
    void cols() throws Exception {
        float[][] m = {{2, 3}, {3, 4}};
        int result = matrix.cols(m);
        int expect = m[0].length;
        Assert.assertEquals(result, expect);
        try {
            float[][] me = null;
            int n = matrix.cols(me);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    @Test
    void getRow() throws Exception {
        float[][] m = {{2, 3}, {5, 4}};
        float[] result = matrix.getRow(m, 1);
        Assert.assertArrayEquals(new float[]{5, 4}, result, 0);
        try {
            float[][] me = null;
            float[] n = matrix.getRow(me, 1);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
        try {
            float[] n = matrix.getRow(m, 2);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    @Test
    void getCol() throws Exception {
        float[][] m = {{2, 3}, {5, 4}};
        float[] result = matrix.getCol(m, 1);
        Assert.assertArrayEquals(new float[]{3, 4}, result, 0);
        try {
            float[][] me = null;
            float[] n = matrix.getCol(me, 1);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
        try {
            float[] n = matrix.getCol(m, 2);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    /**
     * 测试float[][] times(float[][] left, float[][] right, float[][] result)
     *
     * @throws Exception
     */
    @Test
    void testTimes() throws Exception {
        float[][] left = {{2, 3}, {1, 1}};
        float[][] right = {{1, 0}, {0, 1}};
        float[][] result = new float[2][2];
        result = matrix.times(left, right, result);
        Assert.assertArrayEquals(new float[][]{{2, 3}, {1, 1}}, result);
        try {
            float[][] rightf = {{1, 0}};
            float[][] resultf = new float[2][2];
            resultf = matrix.times(left, rightf, resultf);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    /**
     * 测试float[][] times(float a, float[][] matrix, float[][] result)
     */
    @Test
    void testTimes1() throws Exception {
        float a = 2;
        float[][] m = {{2, 3}, {5, 4}};
        float[][] result = new float[2][2];
        result = matrix.times(a, m, result);
        Assert.assertArrayEquals(new float[][]{{4, 6}, {10, 8}}, result);
    }

    /**
     * 测试float[][] add(float[][] left, float multiplier, float[][] right, float[][] result)
     */
    @Test
    void testAdd() throws Exception {
        float[][] left = {{2, 3}, {1, 1}};
        float[][] right = {{1, 0}, {0, 1}};
        float[][] result = new float[2][2];
        float n = 2;
        result = matrix.add(left, n, right, result);
        Assert.assertArrayEquals(new float[][]{{4, 3}, {1, 3}}, result);

        try {
            float[][] rightf = {{1, 0}};
            result = matrix.add(left, n, rightf, result);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }

        try {
            float[][] resultf = new float[3][20];
            resultf = matrix.add(left, n, right, resultf);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    /**
     * 测试float[][] transpose(float[][] matrix, float[][] result)
     */
    @Test
    void testTranspose() throws Exception {
        float[][] m = {{2, 3}, {5, 4}};
        float[][] result = new float[2][2];
        result = matrix.transpose(m, result);
        Assert.assertArrayEquals(new float[][]{{2, 5}, {3, 4}}, result);
    }

    /**
     * 测试float[][] rowVectorToMatrix(float[] row, float[][] result)
     */
    @Test
    void testRowVectorToMatrix() throws Exception {
        float[] m = {2, 3};
        float[][] result = new float[1][2];
        result = matrix.rowVectorToMatrix(m, result);
        Assert.assertArrayEquals(new float[][]{{2, 3}}, result);
        try {
            float[][] resultf = new float[3][1];
            resultf = matrix.rowVectorToMatrix(m, resultf);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }
    }

    /**
     * 测试float[][] colVectorToMatrix(float[] col, float[][] result)
     */
    @Test
    void testColVectorToMatrix() throws Exception {
        float[] m = {2, 3};
        float[][] result = new float[2][1];
        result = matrix.colVectorToMatrix(m, result);
        Assert.assertArrayEquals(new float[][]{{2}, {3}}, result);
        try {
            float[][] resultf = new float[5][1];
            resultf = matrix.colVectorToMatrix(m, resultf);
            fail("没有抛出异常");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof Exception);
        }

    }

    @Test
    void matrixToRowVector() throws Exception {
        float[][] m = {{2, 3}, {5, 4}};
        float[] result = new float[2];
        result = matrix.matrixToRowVector(m);
        Assert.assertArrayEquals(new float[]{2, 3}, result, 0);
    }

    @Test
    void matrixToColVector() throws Exception {
        float[][] m = {{2, 3}, {5, 4}};
        float[] result = new float[2];
        result = matrix.matrixToColVector(m);
        Assert.assertArrayEquals(new float[]{2, 5}, result, 0);
    }

    @Test
    void dotProduct() {
        float[] left = {2, 3};
        float[] right = {1, 0};
        float result;
        result = matrix.dotProduct(left, right);
        Assert.assertEquals(2, result, 0);
    }

    /**
     * 测试matrixToString(float[][] matrix, int dot)
     */
    @Test
    void matrixToString() {
        float[][] m = {{2, 3}, {5, 4}};
        StringBuffer result = new StringBuffer("");
        result = matrix.matrixToString(m, 3);
        System.out.println(result);

    }

    /**
     * 测试matrixToString(float[] vector, int dot)
     */
    @Test
    void testMatrixToString() {
        float[] m = {2, 3};
        StringBuffer result = new StringBuffer("");
        result = matrix.matrixToString(m, 3);
        System.out.println(result);
    }

}