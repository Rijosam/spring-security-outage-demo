package com.demo.springsecurity.controller;

import java.math.BigDecimal;

public record BalanceResponse(Long accountId, BigDecimal balance, String currency) {
}
