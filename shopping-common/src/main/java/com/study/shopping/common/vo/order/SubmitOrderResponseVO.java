package com.study.shopping.common.vo.order;

import com.study.shopping.common.entity.order.OrderEntity;
import lombok.Data;

/**
 * 提交订单返回结果
 */
@Data
public class SubmitOrderResponseVO {
    private OrderEntity order;
}
