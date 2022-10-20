package com.sdp.softwaredefectprediction.test;

import com.sdp.softwaredefectprediction.pojo.Attachment;
import com.sdp.softwaredefectprediction.service.AttachmentService;
import com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttachmentServiceTest {

    private AttachmentService attachmentService = new AttachmentServiceImpl();

    @Test
    public void addAttachment() {
        attachmentService.addAttachment(new Attachment(null,"test2.txt","e:\\test2.txt","txt",null));
    }

    @Test
    public void deleteAttachmentById() {
    }

    @Test
    public void updateAttachment() {
    }

    @Test
    public void queryAttachments() {
        for (Attachment queryAttachment : attachmentService.queryAttachments()){
            System.out.println(queryAttachment);
        }
    }
}