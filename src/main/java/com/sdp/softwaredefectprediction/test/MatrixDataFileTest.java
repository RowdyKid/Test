package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.logistic.MatrixDataFile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MatrixDataFileTest {

    private MatrixDataFile file;

    @Test
    void testInit() throws Exception {
        file = new MatrixDataFile("D:/DATA/train - 副本.csv",1);
        file.loadDatap();
        file.initDatap();
    }

    @Test
    void getSourceFile() throws Exception {
        file = new MatrixDataFile("D:/DATA/train - 副本.csv",1);
        Assert.assertEquals("D:/DATA/train - 副本.csv",file.getSourceFile());
    }

    @Test
    void getData() throws Exception {
        file = new MatrixDataFile("D:/DATA/train - 副本.csv",1);
        file.getData();
    }

    @Test
    void featureScaling() throws Exception {
        file = new MatrixDataFile("D:/DATA/train - 副本.csv",1);
        int n= file.featureScaling();
        Assert.assertEquals(5,n);
    }
}