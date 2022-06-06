package com.cms.contractmanagementsystem.utils;

import java.util.Date;

/**
 * 文件名：Status.java
 * 描述：实体相关状态的操作
 * 创建日期：2022-06-06
 * 创建者：LWJ
 */
public class Status implements IEntity {

    private int id;//合同序号
    private String  contractNo;//合同编号
    private int contractStatus;//合同状态
    private String finishTime;//留着写日志用

    public Status(){
        this.id=0;
        this.contractNo=null;
        this.contractStatus=0;
        this.finishTime=null;
    }

    public Status(int id,String contractNo,int contractStatus,String  finishTime){
        this.id=id;
        this.contractNo=contractNo;
        this.contractStatus=contractStatus;
        this.finishTime=finishTime;
    }
    public int GetId(){
        return id;
    }
    public String GetcontractNo(){
        return contractNo;
    }
    public int GetcontractStatus(){
        return contractStatus;
    }
    public String GetfinishTime(){
        return finishTime;
    }
    public void SetId(int id){
        this.id=id;
    }
    public void SetcontractNo(String  contractNo){
        this.contractNo=contractNo;
    }
    public void SetcontractStatus(int contractStatus){
        this.contractStatus=contractStatus;
    }
    public void SetfinishTime(String finishTime){
        this.finishTime=finishTime;
    }
}
