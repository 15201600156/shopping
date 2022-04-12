package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SkuInfoEntity;
import com.study.shopping.common.entity.product.SpuInfoEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.SkuItemVO;
import com.study.shopping.common.vo.product.Skus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * sku检索
     */
    PageUtils queryPageByCondition(Map<String, Object> params);

    /**
     * 新增sku信息
     */
    void saveSkuInfo(SpuInfoEntity spuInfo, List<Skus> skus);

    /**
     * 查询spuId对应的所有sku信息
     */
    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    /**
     * 查询skuId商品信息，封装VO返回
     */
    SkuItemVO item(Long skuId) throws ExecutionException, InterruptedException;

    /**
     * 根据集合查询
     */
    List<SkuInfoEntity> getByIds(Collection<Long> skuIds);
}

