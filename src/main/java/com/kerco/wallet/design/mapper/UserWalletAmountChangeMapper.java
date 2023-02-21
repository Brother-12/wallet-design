package com.kerco.wallet.design.mapper;

import com.kerco.wallet.design.entity.User;
import com.kerco.wallet.design.entity.UserWalletAmountChange;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserWalletAmountChangeMapper {

    /**
     * 购买记录
     * @param id 用户id
     * @param userAmount 用户金额
     * @param amount 消费金额
     * @param i 状态值
     * @return 记录结果
     */
    int purchaseHistory(String orderId,Long id, BigDecimal userAmount, BigDecimal amount, int i,String description);

    List<UserWalletAmountChange> getUserWalletAmountChangeList(User user, int page);

    /**
     * 根据订单id 和 用户id 获取指定信息
     * @param orderId 订单id
     * @param id 用户id
     * @return 明细
     */
    UserWalletAmountChange getChangeByUserId(String orderId, Long id);
}
