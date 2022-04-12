package com.study.shopping.member.service.impl;

import com.study.shopping.common.constant.ObjectConstant;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.Query;
import com.study.shopping.member.dao.MemberLevelDao;
import com.study.shopping.member.entity.MemberLevelEntity;
import com.study.shopping.member.service.MemberLevelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("memberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberLevelEntity> page = this.page(
                new Query<MemberLevelEntity>().getPage(params),
                new QueryWrapper<MemberLevelEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询默认等级
     */
    @Override
    public MemberLevelEntity getDefaultLevel() {
        return baseMapper.selectOne(new QueryWrapper<MemberLevelEntity>().eq("default_status", ObjectConstant.BooleanIntEnum.YES.getCode()));
    }

}