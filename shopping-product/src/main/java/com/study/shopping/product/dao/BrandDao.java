package com.study.shopping.product.dao;

import com.study.shopping.common.entity.product.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
