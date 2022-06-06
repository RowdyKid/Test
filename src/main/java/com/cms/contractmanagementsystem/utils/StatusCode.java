package com.cms.contractmanagementsystem.utils;

/**
 * 文件名：StatusCode.java
 * 描述：声明各种状态及其对应的状态码
 * 创建日期：2022-06-06
 * 创建者：LWJ
 */
public class StatusCode {
    static public final Integer PAGE_RECORDNUM=9;	//每页显示的记录数

    static public final int DEL_DELETED=1;		//已经删除
    static public final int DEL_NO_DELETE=0;	//未删除

    static public final int STATUS_FINISH_DRAFT=11;		//完成起草
    static public final int STATUS_FINISH_ALLOCATE=21;	//完成分配
    static public final int STATUS_FINISH_COUNTERSIGN=31;//完成会签
    static public final int STATUS_FINISH_FINALIZE=41;	//完成定稿
    static public final int STATUS_FAIL_APPROVE=50;		//审核驳回
    static public final int STATUS_FINISH_APPROVE=51;	//完成审核
    static public final int STATUS_FINISH_SIGN=61;		//完成签订

    static public final int OPERATETYPE_DRAFT=1;		//操作类型：起草
    static public final int OPERATETYPE_ALLOCATE=2;		//操作类型：分配
    static public final int OPERATETYPE_COUNTERSIGN=3;	//操作类型：会签
    static public final int OPERATETYPE_FINALIZE=4;		//操作类型：定稿
    static public final int OPERATETYPE_APPROVE=5;		//操作类型：审核
    static public final int OPERATETYPE_SIGN=6;			//操作类型：签订


}
