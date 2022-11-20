package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.dao.DownloadFileDao;
import com.sdp.softwaredefectprediction.dao.impl.DownloadFileDaoImpl;
import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import org.junit.Test;

public class DownloadFileDaoTest {

    private DownloadFileDao downloadFileDao = new DownloadFileDaoImpl();
    private DownloadFile downloadFile = new DownloadFile(null,"10-21_1940pre.csv","d:/DATA/10-21_1940pre.csv",null);
    private DownloadFile downloadFile1 = new DownloadFile(1,"10-21_1940pre.csv","d:/Downloads/10-21_1940pre.csv",null);
    @Test
    public void addDownloadFile() {
        System.out.println( downloadFileDao.addDownloadFile(new DownloadFile(null,null,null,null)));
        System.out.println( downloadFileDao.addDownloadFile(downloadFile));
    }

    @Test
    public void deleteDownloadFileById() {
        System.out.println( downloadFileDao.deleteDownloadFileById(6));
    }

    @Test
    public void updateDownloadFile() {
        System.out.println( downloadFileDao.updateDownloadFile(new DownloadFile(null,null,null,null)));
        System.out.println( downloadFileDao.updateDownloadFile(downloadFile1));
    }

    @Test
    public void queryDownloadFileById() {
        System.out.println( downloadFileDao.queryDownloadFileById(1));
    }

    @Test
    public void queryDownloadFiles() {
        for (DownloadFile queryDownloadFile : downloadFileDao.queryDownloadFiles()){
            System.out.println(queryDownloadFile);
        }
    }
}