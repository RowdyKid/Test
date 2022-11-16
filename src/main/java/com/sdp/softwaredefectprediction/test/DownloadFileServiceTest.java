package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;
import org.junit.Test;

public class DownloadFileServiceTest {

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();
    private DownloadFile downloadFile = new DownloadFile(null,"10-21_1940pre.csv","d:/DATA/10-21_1940pre.csv",null);
    private DownloadFile downloadFile1 = new DownloadFile(1,"10-21_1940pre.csv","d:/Downloads/10-21_1940pre.csv",null);

    @Test
    public void addDownloadFile() {
        downloadFileService.addDownloadFile(downloadFile);
    }

    @Test
    public void deleteDownloadFileById() {
        downloadFileService.deleteDownloadFileById(1);
    }

    @Test
    public void updateDownloadFile() {
        downloadFileService.updateDownloadFile(downloadFile1);
    }

    @Test
    public void queryDownloadFileById() {
        System.out.println( downloadFileService.queryDownloadFileById(1).getFilepath());
    }

    @Test
    public void queryDownloadFiles() {
        for (DownloadFile queryDownloadFile : downloadFileService.queryDownloadFiles()){
            System.out.println(queryDownloadFile);
        }
    }
}