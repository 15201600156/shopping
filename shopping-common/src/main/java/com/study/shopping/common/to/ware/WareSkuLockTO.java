package com.study.shopping.common.to.ware;

import com.study.shopping.common.vo.ware.OrderItemVO;
import lombok.Data;

import java.util.List;

/**
 *锁定库存传输对象
 **/

@Data
public class WareSkuLockTO {

    private String orderSn;

    /** 需要锁住的所有库存信息 **/
    private List<OrderItemVO> locks;



}
