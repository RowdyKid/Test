package com.cms.contractmanagementsystem;

public class Start {

    public static void main(String[] args) {


        Double [][] data = {{7.0,9.0,8.0},{85.0,18.0,23.0},{15.0,18.0, 9.5},{9.5,10.5,8.0}};
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                System.out.print(data[i][j]+"   ");
            }
            System.out.println();
        }

    }
}
