package com.study.shopping.coupon.dao;

import com.study.shopping.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author zyf
 * @email zhangyanfeng0603@163.com
 * @date 2022-04-02 15:24:45
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
