package com.wisionweb.mapper;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeListForm;
import com.wisionweb.entity.FileListForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<NoticeListForm> noticeList(String noticeName,Long typeId);
    String selOneFileLink(Long noticeId);
    NoticeDetForm noticeDet(Long typeId,Long noticeId);
    List<FileListForm> selFileList(Long noticeId);
    InfoDetForm infoDet();
}
