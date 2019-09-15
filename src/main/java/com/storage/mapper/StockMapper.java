package com.storage.mapper;

import com.storage.entity.vo.StockVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<StockVo> select(Long catgId,String name, Long num, String cabno);
    String insert(Long catgId,String name, Long num, String cabno);
    String out(Long id,Long num);
}