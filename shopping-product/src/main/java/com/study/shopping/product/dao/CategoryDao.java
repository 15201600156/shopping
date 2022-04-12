package com.study.shopping.product.dao;

import com.study.shopping.common.entity.product.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
