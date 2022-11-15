package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.utils.logistic.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CommonTest {

    private Common common;
    @Before
    public void init(){
        common = new Common();
    }

    @Test
    public void readFileToArrayList() {
        String fileName="D:/DATA/train - 副本.csv";
        ArrayList<String> result;
        result=common.readFileToArrayList(fileName);
        System.out.println(result);
    }

    @Test
    public void readFileToArrayListp() {
        String fileName="D:/DATA/train - 副本.csv";
        ArrayList<String> result;
        result=common.readFileToArrayListp(fileName);
        System.out.println(result);
    }
}