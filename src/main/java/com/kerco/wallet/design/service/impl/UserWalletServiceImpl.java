package com.kerco.wallet.design.service.impl;

import com.kerco.wallet.design.entity.User;
import com.kerco.wallet.design.entity.UserWallet;
import com.kerco.wallet.design.mapper.UserWalletMapper;
import com.kerco.wallet.design.service.UserWalletAmountChangeService;
import com.kerco.wallet.design.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    private UserWalletMapper userWalletMapper;

    @Autowired
    private UserWalletAmountChangeService userWalletAmountChangeService;

    /**
     * 查询用户钱包余额
     * @param id 用户id
     * @return 用户余额
     */
    @Override
    public BigDecimal getUserWalletAmount(Long id) {
        UserWallet userWallet = userWalletMapper.getUserWallet(id);
        if(Objects.isNull(userWallet)){
            throw new NullPointerException("该用户id不存在");
        }

        return userWallet.getAmount();
    }

    /**
     * 用户消费接口
     * 因为金额这类是比较敏感的数据，需要保证过程要么都执行，要么不执行
     * @param user 用户信息
     * @param amount 消费金额
     * @return 消费结果
     */
    @Transactional
    @Override
    public Integer amountConsume(User user, BigDecimal amount) {
        UserWallet userWallet = userWalletMapper.getUserWallet(user.getId());
        //保证用户id获取的对象是存在的
        if(Objects.isNull(userWallet)){
            throw new NullPointerException("该用户id不存在，数据非法异常");
        }
        //获取当前用户的金额
        BigDecimal userAmount = userWallet.getAmount();
        //如果当前用户的金额比消费金额 多或者相等
        if(userAmount.compareTo(amount) >= 0){
            int consumeResult = userWalletMapper.AmountConsume(user.getId(), amount);

            //生成订单信息以及其他处理....

            //需要把购买记录写入到表中，这里省略了购买原因
            int recordResult = userWalletAmountChangeService.purchaseHistory("",user.getId(), userAmount,amount,"");
            return 1;
        }else{
            //如果消费金额比钱包少，直接抛异常 余额不足
            throw new IllegalArgumentException("余额不足");
        }
    }

    /**
     * 用户退款接口
     * @param user 用户信息
     * @param amount 退款金额
     * @return 退款结果
     */
    @Transactional
    @Override
    public Integer amountRefund(User user,BigDecimal amount){
        //验证订单状态、是否有发起，是否已经支付....
        UserWallet userWallet = userWalletMapper.getUserWallet(user.getId());
        //保证用户id获取的对象是存在的
        if(Objects.isNull(userWallet)){
            throw new NullPointerException("该用户id不存在，数据非法异常");
        }

        //用户退款修改
        int result = userWalletMapper.amountRefund(user.getId(),amount);
        //...
        return 1;
    }
}
