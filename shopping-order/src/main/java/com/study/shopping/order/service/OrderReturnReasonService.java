package com.study.shopping.order.service;

import com.study.shopping.common.entity.order.OrderReturnReasonEntity;
import com.study.shopping.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 退货原因
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

