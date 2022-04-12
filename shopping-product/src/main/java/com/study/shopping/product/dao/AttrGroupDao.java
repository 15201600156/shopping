package com.study.shopping.product.dao;

import com.study.shopping.common.entity.product.AttrGroupEntity;
import com.study.shopping.common.vo.product.SpuItemAttrGroupVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性分组

 */
@Mapper
public interface AttrGroupDao extends BaseMapper<AttrGroupEntity> {

    /**
     * 查询当前spu对应的所有属性的分组信息以及当前分组下的所有属性对应的值
     * @param spuId
     * @param catalogId
     * @return
     */
    List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuId(@Param("spuId") Long spuId, @Param("catalogId") Long catalogId);

}
