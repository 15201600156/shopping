package com.study.shopping.member.service;

import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.member.entity.MemberReceiveAddressEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 会员收货地址
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据会员ID查询会员收货地址列表
     */
    List<MemberReceiveAddressEntity> getAddress(Long memberId);
}

