package com.study.shopping.member.service;

import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.member.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 会员等级
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询默认等级
     */
    MemberLevelEntity getDefaultLevel();
}

