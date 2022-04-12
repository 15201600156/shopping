package com.study.shopping.order.feign;

import com.study.shopping.common.vo.order.OrderItemVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 购物车系统
 */
@FeignClient("shopping-cart")
public interface CartFeignService {

    /**
     * 查询当前用户购物车选中的商品项
     */
    @GetMapping(value = "/currentUserCartItems")
    List<OrderItemVO> getCurrentCartItems();

}
