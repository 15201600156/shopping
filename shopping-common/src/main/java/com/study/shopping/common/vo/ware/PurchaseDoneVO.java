package com.study.shopping.common.vo.ware;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 **/

@Data
public class PurchaseDoneVO {

    @NotNull(message = "id不允许为空")
    private Long id;// 采购单ID

    private List<PurchaseItemDoneVO> items;// 采购需求

}
