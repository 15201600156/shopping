package com.study.shopping.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;

import com.study.shopping.coupon.dao.SkuFullReductionDao;
import com.study.shopping.coupon.entity.SkuFullReductionEntity;
import com.study.shopping.coupon.service.SkuFullReductionService;
import com.study.shopping.common.utils.Query;

@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

}