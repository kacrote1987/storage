package com.wisionweb.service.impl;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeNewForm;
import com.wisionweb.entity.UserListForm;
import com.wisionweb.exception.UnAuthorizationException;
import com.wisionweb.mapper.ManageMapper;
import com.wisionweb.service.ManageService;
import com.wisionweb.util.MyCache;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ManageServiceImpl implements ManageService {
    @Resource
    ManageMapper manageMapper;

    @Override
    public String login(String userCode, String userPwd) {
        UserListForm userInfo = manageMapper.login(userCode,userPwd);
        if(userInfo==null) throw new UnAuthorizationException("用户名或者密码有误");
        String token = UUID.randomUUID().toString();
        MyCache.put(token,userInfo,2, TimeUnit.HOURS);
        return token;
    }

    @Override
    public String fileUpload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
//        String filePath = "D:/upload/";
        String filePath = "http://localhost:6060/web/upload/";
        String fileLink = filePath + fileName;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
           throw new IllegalArgumentException(e.getMessage());
        }
        return fileLink;
    }

    @Override
    public void noticeAdd(NoticeNewForm params){
        manageMapper.insertNotice(params);
        Long noticeId = manageMapper.selNewNoticeId(params.getNoticeName());
        manageMapper.insertFile(params.getFileLink(),noticeId);
    }

    @Override
    public void noticeEdit(NoticeDetForm params) {
        manageMapper.updateNotice(params);
    }

    @Override
    public void noticeDel(Long noticeId){
        Long check = manageMapper.checkNoticeId(noticeId);
        if(check==null) throw new UnAuthorizationException("空指针");
        manageMapper.deleteNotice(noticeId);
    }

    @Override
    public void infoEdit(InfoDetForm params) {
        manageMapper.updateInfo(params);
    }
}
