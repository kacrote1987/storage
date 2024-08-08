package com.wisionweb.service.impl;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeListForm;
import com.wisionweb.entity.FileListForm;
import com.wisionweb.mapper.HomeMapper;
import com.wisionweb.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    HomeMapper homeMapper;

    @Override
    public List<NoticeListForm> noticeList(Long typeId) {
        List<NoticeListForm> noticeList=homeMapper.noticeList(null,typeId);
        for(int i=0;i<noticeList.size();i++){
            noticeList.get(i).setFileLink(homeMapper.selOneFileLink(noticeList.get(i).getNoticeId()));
        }
        return noticeList;
    }

    @Override
    public NoticeDetForm noticeDet(Long typeId,Long noticeId) {
        NoticeDetForm noticeDet = homeMapper.noticeDet(typeId,noticeId);
        List<FileListForm> picList = homeMapper.selFileList(noticeId);
        noticeDet.setPicList(picList);
        return noticeDet;
    }

    @Override
    public InfoDetForm infoDet() {
        InfoDetForm infoDet = homeMapper.infoDet();
        return infoDet;
    }

}
