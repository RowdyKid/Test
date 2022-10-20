package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.dao.*;
import com.sdp.softwaredefectprediction.pojo.Attachment;

import java.util.List;


public interface AttachmentDao {
    public int addAttachment(Attachment attachment);

    public int deleteAttachmentById(Integer id);

    public int updateAttachment(Attachment attachment);

    public Attachment queryAttachmentById(Integer id);

    public List<Attachment> queryAttachments();
}
