package com.sdp.softwaredefectprediction.dao;

import com.sdp.softwaredefectprediction.pojo.Attachment;

import java.util.List;

public class AttachmentDaoImpl extends BaseDao implements AttachmentDao {
    @Override
    public int addAttachment(Attachment attachment) {
        String sql = "insert into attachment(`filename`,`filepath`,`filetype`,`time`) values(?,?,?,?)";
        return update(sql, attachment.getFilename(),attachment.getFilepath(),attachment.getFiletype(),attachment.getTime());
    }

    @Override
    public int deleteAttachmentById(Integer id) {
        String sql = "delete from attachment where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateAttachment(Attachment attachment) {
        String sql = "update attachment set `filename`=?,`filepath`=?,`filetype`=?,`time`=? where id = ?";
        return update(sql,attachment.getFilename(),attachment.getFilepath(),attachment.getFiletype(),attachment.getTime(),attachment.getId());
    }

    @Override
    public Attachment queryAttachmentById(Integer id) {
        String sql = "select `id`,`filename`,`filepath`,`filetype`,`time` from attachment where id = ?";
        return queryForOne(Attachment.class,sql,id);
    }

    @Override
    public List<Attachment> queryAttachments() {
        String sql = "select `id`,`filename`,`filepath`,`filetype`,`time` from attachment";
        return queryForList(Attachment.class,sql);
    }
}
