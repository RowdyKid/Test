package com.sdp.softwaredefectprediction.service;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;

import java.util.List;

public interface DownloadFileService {

    public void addDownloadFile(DownloadFile downloadFile);

    public void deleteDownloadFileById(Integer id);

    public void updateDownloadFile(DownloadFile downloadFile);

    public void updateDownloadFileBuggyCleanById(DownloadFile downloadFile);

    public DownloadFile queryDownloadFileById(Integer id);

    public List<DownloadFile> queryDownloadFiles();
}
