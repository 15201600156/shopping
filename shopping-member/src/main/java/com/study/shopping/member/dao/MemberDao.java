package com.study.shopping.member.dao;

import com.study.shopping.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
