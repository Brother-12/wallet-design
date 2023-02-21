package com.kerco.wallet.design.mapper;

import com.kerco.wallet.design.entity.UserWallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserWalletMapper {
    UserWallet getUserWallet(Long id);

    /**
     * 用户的消费
     * @param id 用户id
     * @param amount 消费的价格
     * @return 消费结果
     */
    int AmountConsume(@Param("id") Long id, @Param("amount") BigDecimal amount);

    /**
     * 用户退款接口
     * @param id 用户id
     * @param amount 退款金额
     */
    int amountRefund(Long id, BigDecimal amount);
}
