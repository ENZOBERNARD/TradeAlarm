package com.me.tradalarm.binance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class BinanceController {


    @Autowired
    private BinanceService binanceService;

    @GetMapping("/binance/price/{symbole1}/{symbole2}")
    public BigDecimal getPrice(@PathVariable String symbole1, @PathVariable String symbole2){
        return binanceService.getPrice(symbole1,symbole2);
    }



}
