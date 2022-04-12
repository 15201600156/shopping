package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SkuImagesEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * sku图片

 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询sku图片信息
     */
    List<SkuImagesEntity> getImagesBySkuId(Long skuId);
}

