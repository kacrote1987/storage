package com.wisionweb.service;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeNewForm;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ManageService {
    /**
     * 登陆
     * @return
     */
    String login(String userCode,String userPwd);
    /**
     * 附件上传
     * @return
     */
    String fileUpload(@RequestParam MultipartFile file,Long noticeId);
    /**
     * 通知新增
     * @return
     */
    void noticeAdd(NoticeNewForm params);
    /**
     * 通知修改
     * @return
     */
    void noticeEdit(NoticeDetForm params);
    /**
     * 通知删除
     * @return
     */
    void noticeDel(Long noticeId);
    /**
     * 联系我们修改
     * @return
     */
    void infoEdit(InfoDetForm params);
}
