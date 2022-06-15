package com.cms.contractmanagementsystem.dao;

import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.pojo.User;

import java.util.List;

public interface LogDao {


    public int saveLogInfo(Log log);

    public List<Log> getAllLogs();



}
