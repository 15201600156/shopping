package com.study.shopping.product.feign;

import com.study.shopping.common.to.es.SkuEsModel;
import com.study.shopping.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("shopping-search")
public interface SearchFeignService {

    /**
     * 上架商品
     */
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);


}
