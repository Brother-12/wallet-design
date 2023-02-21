package com.kerco.wallet.design.service;

import java.math.BigDecimal;

public interface UserWalletAmountChangeService {
    int purchaseHistory(String orderId, Long id, BigDecimal userAmount,BigDecimal amount,String description);
}
