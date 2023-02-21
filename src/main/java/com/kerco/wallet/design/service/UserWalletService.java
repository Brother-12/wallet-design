package com.kerco.wallet.design.service;

import com.kerco.wallet.design.entity.User;

import java.math.BigDecimal;

public interface UserWalletService {
    /**
     * 查询用户钱包余额
     * @param id 用户id
     * @return 用户余额
     */
    BigDecimal getUserWalletAmount(Long id);

    /**
     * 用户消费接口
     * @param user 用户信息
     * @param bigDecimal 消费金额
     * @return 消费结果
     */
    Integer amountConsume(User user, BigDecimal bigDecimal);

    /**
     * 用户退款接口
     * @param user 用户信息
     * @param bigDecimal 退款金额
     * @return 退款结果
     */
    public Integer amountRefund(User user,BigDecimal bigDecimal);
}
