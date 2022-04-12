package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.SkuSaleAttrValueEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.SkuItemSaleAttrVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值

 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取spu下的所有销售属性组合
     */
    List<SkuItemSaleAttrVO> getSaleAttrBySpuId(Long spuId);

    /**
     * 根据skuId查询销售属性值
     * @param skuId
     * @return skuId:skuValue
     */
    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}

