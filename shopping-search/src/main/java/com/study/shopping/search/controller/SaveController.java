package com.study.shopping.search.controller;

import com.study.shopping.common.exception.BizCodeEnume;
import com.study.shopping.common.to.es.SkuEsModel;
import com.study.shopping.common.utils.R;
import com.study.shopping.search.service.impl.ProductSaveServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * es保存
 */
@Slf4j
@RequestMapping("/search/save")
@RestController
public class SaveController {

    @Autowired
    ProductSaveServiceImpl productSaveService;

    /**
     * 上架商品
     */
    @PostMapping("product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {
        boolean result = false;// 是否执行成功
        try {
             result = productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            // es客户端连接失败
            log.error("ElasticSaveController商品上架错误：{}", e);
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
        if (result) {
            return R.ok();// 执行成功
        } else {
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
    }

}
