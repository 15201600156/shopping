package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.BrandEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 品牌
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 修改品牌表，同时修改冗余表数据
     */
    void updateDetail(BrandEntity brand);
}

