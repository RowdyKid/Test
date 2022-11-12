package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.dao.AttachmentDao;
import com.sdp.softwaredefectprediction.dao.AttachmentDaoImpl;
import com.sdp.softwaredefectprediction.pojo.Attachment;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttachmentDaoTest {

    private AttachmentDao attachmentDao = new AttachmentDaoImpl();

    @Test
    public void addAttachment() {
        attachmentDao.addAttachment(new Attachment(null,"111ceshi.txt","e:/111ceshi.txt","txt",null));
    }

    @Test
    public void deleteAttachmentById() {
        attachmentDao.deleteAttachmentById(33);
    }

    @Test
    public void updateAttachment() {
    }

    @Test
    public void queryAttachmentById() {
        System.out.println(attachmentDao.queryAttachmentById(32));
    }

    @Test
    public void queryAttachments() {
        for (Attachment queryAttachment : attachmentDao.queryAttachments()){
            System.out.println(queryAttachment);
        }
    }
}