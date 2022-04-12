package com.study.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;
import com.study.shopping.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author zyf
 * @email zhangyanfeng0603@163.com
 * @date 2022-04-02 15:24:45
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

