package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.ProductAttrValueEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.BaseAttrs;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * spu属性值

 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu商品基本属性值
     */
    void saveProductAttrValue(Long spuId, List<BaseAttrs> baseAttrs);

    /**
     * 获取spu规格
     */
    List<ProductAttrValueEntity> baseAttrlistforspu(Long spuId);

    /**
     * 修改商品规格
     */
    void updateSpuAttr(Long spuId, List<ProductAttrValueEntity> entities);
}

