package com.storage.mapper;

import com.storage.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProdMapper {
    List<ProdListVo> prodList(@Param("params") ProdListForm params);
    List<ProdDetVo> prodDet(Long prodId);
}
