package com.wisionweb.entity;

import java.util.List;

public class NoticeNewForm {
    private Long typeId;
    private String noticeName;
    private String noticeContent;
    private List<FileListForm> fileList;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public List<FileListForm> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileListForm> fileList) {
        this.fileList = fileList;
    }
}
