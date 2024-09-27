package com.wisionweb.mapper;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeNewForm;
import com.wisionweb.entity.UserListForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManageMapper {
    UserListForm login(String userCode, String userPwd);
    boolean insertNotice(@Param("params") NoticeNewForm params);
    Long selNewNoticeId(String noticeName);
    boolean insertFile(String fileLink,Long noticeId);
    boolean updateNotice(@Param("params") NoticeDetForm params);
    boolean deleteFile(Long noticeId);
    boolean updateFile(@Param("params") NoticeDetForm params);
    Long checkNoticeId(Long noticeId);
    boolean deleteNotice(Long noticeId);
    boolean updateInfo(@Param("params") InfoDetForm params);
}