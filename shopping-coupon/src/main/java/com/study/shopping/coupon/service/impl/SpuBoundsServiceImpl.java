package com.study.shopping.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;

import com.study.shopping.coupon.dao.SpuBoundsDao;
import com.study.shopping.coupon.entity.SpuBoundsEntity;
import com.study.shopping.coupon.service.SpuBoundsService;

import com.study.shopping.common.utils.Query;
@Service("spuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsDao, SpuBoundsEntity> implements SpuBoundsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuBoundsEntity> page = this.page(
                new Query<SpuBoundsEntity>().getPage(params),
                new QueryWrapper<SpuBoundsEntity>()
        );

        return new PageUtils(page);
    }

}