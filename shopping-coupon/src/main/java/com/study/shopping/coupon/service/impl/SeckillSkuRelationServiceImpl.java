package com.study.shopping.coupon.service.impl;

import com.study.shopping.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;

import com.study.shopping.coupon.dao.SeckillSkuRelationDao;
import com.study.shopping.coupon.entity.SeckillSkuRelationEntity;
import com.study.shopping.coupon.service.SeckillSkuRelationService;
import com.study.shopping.common.utils.Query;

@Service("seckillSkuRelationService")
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationDao, SeckillSkuRelationEntity> implements SeckillSkuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuRelationEntity> page = this.page(
                new Query<SeckillSkuRelationEntity>().getPage(params),
                new QueryWrapper<SeckillSkuRelationEntity>()
        );

        return new PageUtils(page);
    }

}