package com.demo.springsecurity.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.random.RandomGenerator;

@Service
public class BalanceService {
    public BigDecimal getBalance(Long accountId) {
        //simulate database call here by providing a random balance
        return BigDecimal.valueOf
                (RandomGenerator.getDefault().nextInt(1000,100000));
    }
}
