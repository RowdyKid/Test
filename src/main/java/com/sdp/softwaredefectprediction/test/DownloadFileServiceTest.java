package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.pojo.DownloadFile;
import com.sdp.softwaredefectprediction.service.DownloadFileService;
import com.sdp.softwaredefectprediction.service.impl.DownloadFileServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class DownloadFileServiceTest {

    private DownloadFileService downloadFileService = new DownloadFileServiceImpl();

    @Test
    public void addDownloadFile() {
        downloadFileService.addDownloadFile(new DownloadFile(null,"10-21_1940pre.csv","d:/DATA/10-21_1940pre.csv",null));
    }

    @Test
    public void deleteDownloadFileById() {
    }

    @Test
    public void updateDownloadFile() {
        downloadFileService.updateDownloadFile(new DownloadFile());
    }

    @Test
    public void updateDownloadFileBuggyCleanById(){
        downloadFileService.updateDownloadFileBuggyCleanById(new DownloadFile());
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