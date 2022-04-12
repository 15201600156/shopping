package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SpuImagesEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 新增商品图片
     */
    void saveSpuImages(Long spuId, List<String> images);
}

