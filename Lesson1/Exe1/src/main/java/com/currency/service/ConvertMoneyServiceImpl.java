package com.currency.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertMoneyServiceImpl implements IConvertMoneyService {
    @Override
    public double convertMoney(double USD) {
        double total = USD * 23000;
        return total;
    }
}
