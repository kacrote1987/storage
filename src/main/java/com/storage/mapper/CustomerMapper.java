package com.storage.mapper;

import com.storage.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerVo> selectCustomer(String code);
    Long selectcustomerid(String code);
    void register(String name,Long idCard,Long tel,String vipCard);
    void unregister(Long id);
}
