package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.Log;

import java.util.List;

public class LogDaoImpl extends BaseDao implements LogDao {

    @Override
    public int saveLogInfo(Log log) {
        String sql = "INSERT INTO `log`(`operator`, `content`, `time`) VALUES (?,?,?)";
        return update(sql, log.getOperator(),log.getContent(),log.getTime());
    }

    @Override
    public List<Log> getAllLogs() {
        String sql = "select * from log order by time DESC";
        return queryForList(Log.class,sql);
    }
}
