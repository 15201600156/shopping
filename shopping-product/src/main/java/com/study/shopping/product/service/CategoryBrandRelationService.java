package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.BrandEntity;
import com.study.shopping.common.entity.product.CategoryBrandRelationEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    /**
     * 更新冗余数据
     */
    void updateBrand(Long brandId, String name);

    /**
     * 更新冗余数据
     */
    void updateCategory(Long catId, String name);

    /**
     * 获取分类关联的所有品牌
     */
    List<BrandEntity> getBrandsByCatId(Long catId);
}

