package com.cms.contractmanagementsystem.dao;

import com.cms.contractmanagementsystem.pojo.Log;
import com.cms.contractmanagementsystem.pojo.User;

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
