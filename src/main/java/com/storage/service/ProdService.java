package com.storage.service;

import com.github.pagehelper.PageInfo;
import com.storage.entity.*;

import java.util.List;

public interface ProdService {
    PageInfo<ProdListVo> prodList(ProdListForm params);
    List<ProdDetVo> prodDet(Long prodId);
}
