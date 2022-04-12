package com.study.shopping.search.feign;

import com.study.shopping.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 */
@FeignClient("shopping-product")
public interface ProductFeignService {

    /**
     * 查询属性
     */
    @GetMapping("/product/attr/info/{attrId}}")
    R attrInfo(@PathVariable("attrId") Long attrId);
}