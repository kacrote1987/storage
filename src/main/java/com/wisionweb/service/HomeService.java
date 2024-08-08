package com.wisionweb.service;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeListForm;

import java.util.List;

public interface HomeService {
    /**
     * 通知列表
     * @return
     */
    List<NoticeListForm> noticeList(Long typeId);
    /**
     * 通知详细
     * @return
     */
    NoticeDetForm noticeDet(Long typeId,Long noticeId);
    /**
     * 关于我们详细
     * @return
     */
    InfoDetForm infoDet();
}
