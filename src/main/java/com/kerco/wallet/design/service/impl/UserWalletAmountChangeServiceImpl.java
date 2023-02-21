package com.kerco.wallet.design.service.impl;

import com.kerco.wallet.design.entity.User;
import com.kerco.wallet.design.entity.UserWalletAmountChange;
import com.kerco.wallet.design.mapper.UserWalletAmountChangeMapper;
import com.kerco.wallet.design.service.UserWalletAmountChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserWalletAmountChangeServiceImpl implements UserWalletAmountChangeService {

    @Autowired
    private UserWalletAmountChangeMapper amountChangeMapper;

    /**
     * 购买记录
     * @param id 用户id
     * @param userAmount 用户金额
     * @param amount 消费金额
     * @param description 描述
     * @return 记录结果
     */
    @Override
    public int purchaseHistory(String orderId, Long id, BigDecimal userAmount, BigDecimal amount,String description) {
        return amountChangeMapper.purchaseHistory(orderId , id,userAmount,amount,1,description);
    }

    /**
     * 分页获取用户金额变动表
     * @return
     */
    public List<UserWalletAmountChange> getUserWalletAmountChangeList(User user,int page){
        //信息验证....

        //分页获取用户金额变动表
        List<UserWalletAmountChange> userWalletAmountChangeList = amountChangeMapper.getUserWalletAmountChangeList(user, page);

        //其他信息处理...
        return userWalletAmountChangeList;
    }

    /**
     * 指定获取用户金额明细
     * @param orderId 订单id
     * @param user 用户信息
     * @return 用户金额明细
     */
    public UserWalletAmountChange getChangeByUserId(String orderId,User user){
        //信息验证....

        //...
        return amountChangeMapper.getChangeByUserId(orderId,user.getId());
    }
}
