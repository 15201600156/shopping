package com.study.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;
import com.study.shopping.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author zyf
 * @email zhangyanfeng0603@163.com
 * @date 2022-04-02 15:24:45
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

