package com.sdp.softwaredefectprediction.service.impl;

import com.sdp.softwaredefectprediction.dao.AttachmentDao;
import com.sdp.softwaredefectprediction.dao.AttachmentDaoImpl;
import com.sdp.softwaredefectprediction.pojo.Attachment;
import com.sdp.softwaredefectprediction.service.AttachmentService;

import java.util.List;

public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentDao attachmentDao = new AttachmentDaoImpl();

    @Override
    public void addAttachment(Attachment attachment) {
        attachmentDao.addAttachment(attachment);
    }

    @Override
    public void deleteAttachmentById(Integer id) {
        attachmentDao.deleteAttachmentById(id);
    }

    @Override
    public void updateAttachment(Attachment attachment) {
        attachmentDao.updateAttachment(attachment);
    }

    @Override
    public Attachment queryAttachmentById(Integer id) {
        return attachmentDao.queryAttachmentById(id);
    }

    @Override
    public List<Attachment> queryAttachments() {

        return attachmentDao.queryAttachments();
    }
}
