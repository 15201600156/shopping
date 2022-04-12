package com.study.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;
import com.study.shopping.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author zyf
 * @email zhangyanfeng0603@163.com
 * @date 2022-04-02 15:24:44
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

