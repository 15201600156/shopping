package com.study.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.R;
import com.study.shopping.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * 专题商品
 *
 * @author zyf
 * @email zhangyanfeng0603@163.com
 * @date 2022-04-02 15:24:45
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

