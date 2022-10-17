package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.Log;

import java.util.List;

public interface LogDao {


    public int saveLogInfo(Log log);

    public List<Log> getAllLogs();

}
