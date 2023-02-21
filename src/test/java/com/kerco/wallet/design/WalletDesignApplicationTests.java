package com.kerco.wallet.design;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WalletDesignApplicationTests {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(52);
        BigDecimal b2 = new BigDecimal(51);

        int i = b1.compareTo(b2);
        System.out.println(i);
    }

    @Test
    void contextLoads() {
    }

}
