package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.logistic.Calculate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CalculateTest {

    private Calculate calculate;

    @Before
    public void init(){
        calculate =new Calculate();
    }

    @Test
    public void testSigmoid() throws Exception {
        float[][] a= {{1},{0}};
        float[][] g=new float[2][1];
        float[][] result=calculate.sigmoid(a,g);
        System.out.println(Arrays.deepToString(result));
        Assert.assertArrayEquals(result, new float[][]{{0.7310586f}, {0.5f}});
    }

    @Test
    public void testSetG() throws Exception {
        float[][] x={{2,1},{3,2}};
        calculate.setG(x);
    }

}