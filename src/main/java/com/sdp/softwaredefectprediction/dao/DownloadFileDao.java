package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;

import java.util.List;

public interface DownloadFileDao {

    public int addDownloadFile(DownloadFile downloadFile);

    public int deleteDownloadFileById(Integer id);

    public int updateDownloadFile(DownloadFile downloadFile);

    public int updateDownloadFileBuggyCleanById(DownloadFile downloadFile);

    public DownloadFile queryDownloadFileById(Integer id);

    public List<DownloadFile> queryDownloadFiles();

}
