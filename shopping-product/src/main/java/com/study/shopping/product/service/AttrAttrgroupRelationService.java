package com.study.shopping.product.service;

import com.study.shopping.common.entity.product.AttrAttrgroupRelationEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.vo.product.AttrGroupRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrGroupRelationVO> vos);
}

