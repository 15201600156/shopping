package com.study.shopping.order.dao;

import com.study.shopping.common.entity.order.MqMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {
	
}
