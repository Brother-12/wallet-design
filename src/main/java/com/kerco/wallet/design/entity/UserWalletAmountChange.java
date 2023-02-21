package com.kerco.wallet.design.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserWalletAmountChange {
    //金额变动id
    private Long id;
    //用户id
    private Long userId;
    //当前金额
    private BigDecimal currentAmount;
    //变动金额
    private BigDecimal changeAmount;
    //变动原因
    private String description;
    //状态
    private Integer status;
    //创建时间
    private LocalDateTime createTime;

    //完成时间
    private LocalDateTime updateTime;
}
