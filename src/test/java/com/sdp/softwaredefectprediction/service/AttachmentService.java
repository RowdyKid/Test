package com.sdp.softwaredefectprediction.service;

import com.sdp.softwaredefectprediction.pojo.Attachment;

import java.util.List;

public interface AttachmentService {

    public void addAttachment(Attachment attachment);

    public void deleteAttachmentById(Integer id);

    public void updateAttachment(Attachment attachment);

    public Attachment queryAttachmentById(Integer id);

    public List<Attachment> queryAttachments();
}
