package com.study.shopping.member.feign;

import com.study.shopping.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("shopping-coupon")
public interface CouponFeignService {

    /**
     * 测试openFeign
     */
    @RequestMapping("/coupon/coupon/member/list")
    R membercoupons();

}
