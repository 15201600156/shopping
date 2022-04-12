package com.study.shopping.order.service.impl;

import com.study.shopping.common.entity.order.MqMessageEntity;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.Query;
import com.study.shopping.order.dao.MqMessageDao;
import com.study.shopping.order.service.MqMessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mqMessageService")
public class MqMessageServiceImpl extends ServiceImpl<MqMessageDao, MqMessageEntity> implements MqMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MqMessageEntity> page = this.page(
                new Query<MqMessageEntity>().getPage(params),
                new QueryWrapper<MqMessageEntity>()
        );

        return new PageUtils(page);
    }

}