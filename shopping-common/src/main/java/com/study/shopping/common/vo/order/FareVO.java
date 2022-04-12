package com.study.shopping.common.vo.order;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class FareVO {
    private MemberAddressVO address;
    private BigDecimal fare;
}
