package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.dao.DownloadFileDao;
import com.sdp.softwaredefectprediction.dao.DownloadFileDaoImpl;
import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import org.junit.Test;

import static org.junit.Assert.*;

public class DownloadFileDaoTest {

    private DownloadFileDao downloadFileDao = new DownloadFileDaoImpl();

    @Test
    public void addDownloadFile() {
    }

    @Test
    public void deleteDownloadFileById() {
    }

    @Test
    public void updateDownloadFile() {
    }

    @Test
    public void queryDownloadFileById() {
    }

    @Test
    public void queryDownloadFiles() {
        for (DownloadFile queryDownloadFile : downloadFileDao.queryDownloadFiles()){
            System.out.println(queryDownloadFile);
        }
    }
}