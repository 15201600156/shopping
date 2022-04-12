package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SpuInfoEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.SpuSaveVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 分页查询
     */
    PageUtils queryPageByCondition(Map<String, Object> params);

    /**
     * 发布商品
     */
    void saveSpuInfo(SpuSaveVO vo);

    /**
     * 新增spuInfoEntity
     */
    void saveBaseSpuInfo(SpuInfoEntity spuInfo);

    /**
     * spu商品上架
     */
    void up(Long spuId);

    /**
     * 根据SkuId查询SPU信息
     */
    SpuInfoEntity getBySkuId(Long skuId);
}

