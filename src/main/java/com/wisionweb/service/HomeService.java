package com.wisionweb.service;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeListForm;

import java.util.List;

public interface HomeService {
    List<NoticeListForm> noticeList(Long typeId);
    NoticeDetForm noticeDet(Long typeId,Long noticeId);
    InfoDetForm infoDet();
}
