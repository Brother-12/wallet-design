package com.kerco.wallet.design.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserWallet {
    //钱包id
    private Long id;
    //用户id
    private Long userId;
    //金额
    private BigDecimal amount;
    //状态
    private Integer status;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
}
