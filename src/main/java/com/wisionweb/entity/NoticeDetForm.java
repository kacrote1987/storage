package com.wisionweb.entity;

import java.util.List;

public class NoticeDetForm {
    private Long noticeId;
    private String noticeName;
    private String noticeContent;
    private String noticeTime;
    private String updateTime;
    private List<FileListForm> fileList;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
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

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<FileListForm> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileListForm> fileList) {
        this.fileList = fileList;
    }
}
