package com.kerco.wallet.design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.kerco.wallet.design.mapper")
@SpringBootApplication
public class WalletDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletDesignApplication.class, args);
    }

}
