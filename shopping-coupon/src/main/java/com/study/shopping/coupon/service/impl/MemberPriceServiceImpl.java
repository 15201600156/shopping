package com.study.shopping.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;

import com.study.shopping.coupon.dao.MemberPriceDao;
import com.study.shopping.coupon.entity.MemberPriceEntity;
import com.study.shopping.coupon.service.MemberPriceService;
import com.study.shopping.common.utils.Query;

@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements MemberPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberPriceEntity> page = this.page(
                new Query<MemberPriceEntity>().getPage(params),
                new QueryWrapper<MemberPriceEntity>()
        );

        return new PageUtils(page);
    }

}