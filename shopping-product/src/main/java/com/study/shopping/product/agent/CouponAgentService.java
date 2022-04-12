package com.study.shopping.product.agent;

import com.study.shopping.common.to.product.SkuReductionTO;
import com.study.shopping.common.to.product.SpuBoundTO;
import com.study.shopping.common.utils.R;
import com.study.shopping.common.vo.product.Bounds;
import com.study.shopping.common.vo.product.Skus;
import com.study.shopping.product.feign.CouponFeignService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CouponAgentService {

    @Autowired
    CouponFeignService couponFeignService;

    /**
     * 新增积分信息（当前spu商品购买新增的积分规则信息）
     */
    public R saveSpuBounds(Long spuId, Bounds bounds) {
        SpuBoundTO boundTo = new SpuBoundTO();
        BeanUtils.copyProperties(bounds, boundTo);
        boundTo.setSpuId(spuId);
        return couponFeignService.saveSpuBounds(boundTo);
    }

    /**
     * 新增满减信息
     */
    public R saveSkuReduction(Long skuId, Skus sku) {
        SkuReductionTO reductionTo = new SkuReductionTO();
        BeanUtils.copyProperties(sku, reductionTo);
        reductionTo.setSkuId(skuId);
//        return couponFeignService.saveSkuReduction(reductionTo);
        return  null;
    }
}
