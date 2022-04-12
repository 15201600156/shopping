package com.study.shopping.member.feign;

import com.study.shopping.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 *  订单模块feign调用
 **/
@FeignClient("shopping-order")
public interface OrderFeignService {

    /**
     * 分页查询当前用户的订单列表
     */
    @PostMapping("/order/order/listWithItem")
    R listWithItem(@RequestBody Map<String, Object> params);

}
