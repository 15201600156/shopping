package com.study.shopping.product.agent;

import com.study.shopping.common.to.es.SkuEsModel;
import com.study.shopping.common.utils.R;
import com.study.shopping.product.feign.SearchFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchAgentService {

    @Autowired
    SearchFeignService searchFeignService;

    /**
     * 上架商品
     */
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) {
        R result = searchFeignService.productStatusUp(skuEsModels);
        return result.getCode() == 0 ? true : false;
    }


}
