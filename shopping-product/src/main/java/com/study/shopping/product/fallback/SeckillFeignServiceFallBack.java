package com.study.shopping.product.fallback;


import com.study.shopping.common.exception.BizCodeEnume;
import com.study.shopping.common.utils.R;
import com.study.shopping.product.feign.SeckillFeignService;
import lombok.extern.slf4j.Slf4j;

/**
 * 熔断方法的具体实现，也可以是降级方法的具体实现
 **/
@Slf4j
public class SeckillFeignServiceFallBack implements SeckillFeignService {

    @Override
    public R getSkuSeckilInfo(Long skuId) {
        log.debug("熔断方法调用...getSkuSeckilInfo，获取秒杀商品详情");
        return R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
    }

}
