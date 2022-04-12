package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.AttrGroupEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.AttrGroupWithAttrsVO;
import com.study.shopping.common.vo.product.SpuItemAttrGroupVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    /**
     * 获取分类下所有分组&关联属性
     */
    List<AttrGroupWithAttrsVO> getAttrGroupWithAttrs(Long catelogId);

    /**
     * 查出当前spu对应的所有属性的分组信息以及当前分组下的所有属性对应的值
     */
    List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}

