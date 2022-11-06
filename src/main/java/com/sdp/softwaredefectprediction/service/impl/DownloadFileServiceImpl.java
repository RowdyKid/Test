package com.sdp.softwaredefectprediction.service.impl;

import com.sdp.softwaredefectprediction.dao.DownloadFileDao;
import com.sdp.softwaredefectprediction.dao.DownloadFileDaoImpl;
import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;

import java.util.List;

public class DownloadFileServiceImpl implements DownloadFileService {

    private DownloadFileDao downloadFileDao = new DownloadFileDaoImpl();

    @Override
    public void addDownloadFile(DownloadFile downloadFile) {
        downloadFileDao.addDownloadFile(downloadFile);
    }

    @Override
    public void deleteDownloadFileById(Integer id) {
        downloadFileDao.deleteDownloadFileById(id);
    }

    @Override
    public void updateDownloadFile(DownloadFile downloadFile) {
        downloadFileDao.updateDownloadFile(downloadFile);
    }

    @Override
    public DownloadFile queryDownloadFileById(Integer id) {
        return downloadFileDao.queryDownloadFileById(id);
    }

    @Override
    public List<DownloadFile> queryDownloadFiles() {

        return downloadFileDao.queryDownloadFiles();
    }
}
