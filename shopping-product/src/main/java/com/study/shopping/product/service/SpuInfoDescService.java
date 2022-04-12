package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SpuInfoDescEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * spu信息介绍

 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 新增描述图片
     */
    void saveSpuInfoDesc(Long spuId, List<String> decript);
}

