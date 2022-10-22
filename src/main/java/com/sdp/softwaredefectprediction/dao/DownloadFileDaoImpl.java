package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;

import java.util.List;

public class DownloadFileDaoImpl extends BaseDao implements DownloadFileDao {
    @Override
    public int addDownloadFile(DownloadFile downloadFile) {
        String sql = "insert into download(`filename`,`filepath`,`time`,`buggy`,`clean`) values(?,?,?,?,?)";
        return update(sql, downloadFile.getFilename(),downloadFile.getFilepath(),downloadFile.getTime());
    }

    @Override
    public int deleteDownloadFileById(Integer id) {
        String sql = "delete from download where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateDownloadFile(DownloadFile downloadFile) {
        String sql = "update download set `filename`=?,`filepath`=?,`time`=?,`buggy`=?,`clean`=? where id = ?";
        return update(sql,downloadFile.getFilename(),downloadFile.getFilepath(),downloadFile.getTime(),downloadFile.getId());
    }

    @Override
    public int updateDownloadFileBuggyCleanById(DownloadFile downloadFile) {
        String sql = "update download set`buggy`=?,`clean=? where id = ?";
        return update(sql,downloadFile.getBuggy(),downloadFile.getClean());
    }

    @Override
    public DownloadFile queryDownloadFileById(Integer id) {
        String sql = "select `id`,`filename`,`filepath`,`time`,`buggy`,`clean` from download where id = ?";
        return queryForOne(DownloadFile.class,sql,id);
    }

    @Override
    public List<DownloadFile> queryDownloadFiles() {
        String sql = "select `id`,`filename`,`filepath`,`time`,`buggy`,`clean` from download";
        return queryForList(DownloadFile.class,sql);
    }
}
