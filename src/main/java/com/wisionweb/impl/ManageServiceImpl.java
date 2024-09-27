package com.wisionweb.impl;

import com.wisionweb.entity.*;
import com.wisionweb.exception.UnAuthorizationException;
import com.wisionweb.mapper.ManageMapper;
import com.wisionweb.service.ManageService;
import com.wisionweb.util.MinioUtil;
import com.wisionweb.util.MyCache;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ManageServiceImpl implements ManageService {
    @Resource
    ManageMapper manageMapper;
    @Resource
    MinioUtil minioUtil;

    @Override
    public String login(String userCode, String userPwd) {
        UserListForm userInfo = manageMapper.login(userCode,userPwd);
        if(userInfo==null) throw new UnAuthorizationException("用户名或者密码有误");
        String token = UUID.randomUUID().toString();
        MyCache.put(token,userInfo,2, TimeUnit.HOURS);
        return token;
    }

    @Override
    public String fileUpload(MultipartFile file, Long noticeId) {
        String fileName = file.getOriginalFilename();
        String filePath = "D:/upload/";
        String fileLink = filePath + fileName;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
//        manageMapper.insertFile(fileLink,noticeId);
        return fileLink;
    }


    @Override
    public void noticeAdd(NoticeNewForm params){
        manageMapper.insertNotice(params);
        Long noticeId = manageMapper.selNewNoticeId(params.getNoticeName());
        for(int i=0;i<params.getFileList().size();i++){
            manageMapper.insertFile(params.getFileList().get(i).getFileLink(),noticeId);
        }
    }

    @Override
    public void noticeEdit(NoticeDetForm params) {
        manageMapper.updateNotice(params);
        manageMapper.deleteFile(params.getNoticeId());
        for(int i=0;i<params.getFileList().size();i++){
            manageMapper.insertFile(params.getFileList().get(i).getFileLink(),params.getNoticeId());
        }
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

    @Override
    public String minioUpload(MultipartFile file) {
        String fileName = minioUtil.upload(file);
        String url = minioUtil.preview(fileName);
        return url;
    }

    @Override
    public List<UrlListForm> minioUploadMultip(MultipartFile[] files) {
        List<UrlListForm> urlList = new ArrayList<>();
        UrlListForm urlForm = new UrlListForm();
        for(int i=0;i<files.length;i++){
            String fileName = minioUtil.upload(files[i]);
            String fileLink = minioUtil.preview(fileName);
            urlForm.setFileName(fileName);
            urlForm.setFileLink(fileLink);
            urlList.add(urlForm);
        }
        return urlList;
    }
}
