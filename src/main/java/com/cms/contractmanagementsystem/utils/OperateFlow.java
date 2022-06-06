package com.cms.contractmanagementsystem.utils;
/**
 * 文件名：OperateFlow.java
 * 描述：对实体进行操作
 * 创建日期：2022-06-06
 * 创建者：LWJ
 */
public class OperateFlow implements IEntity {


    private int id;//合同序号
    private String contractNo;//合同编号
    private String operatorNo;//操作着编号
    private int operateType;//操作类型
    private int operateStatus;//操作后状态
    private String content;//合同内容
    private String operateDate;//操作日期

    public OperateFlow(){
        this.id=0;
        this.contractNo=null;
        this.operatorNo=null;
        this.operateType=0;
        this.operateStatus=-2;
        this.content=null;
        this.operateDate=null;

    }

    public OperateFlow(int id,String contractNo,String operatorNo,int operateType,
                       int operateStatus,String content,String operateDate){
        this.id=id;
        this.contractNo=contractNo;
        this.operatorNo=operatorNo;
        this.operateType=operateType;
        this.operateStatus=operateStatus;
        this.content=content;
        this.operateDate=operateDate;
    }

    @Override
    public int GetId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public void SetId(int id) {
        // TODO Auto-generated method stub
        this.id=id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public int getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(int operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

}

