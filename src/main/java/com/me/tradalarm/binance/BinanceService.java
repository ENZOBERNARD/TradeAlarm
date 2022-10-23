package com.me.tradalarm.binance;


import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
public class BinanceService {
    public BigDecimal getPrice(String symbole1, String symbole2) {
        try {
            BinanceApi api = new BinanceApi();
            return api.pricesMap().get(symbole1.toUpperCase()+symbole2.toUpperCase());
        } catch (BinanceApiException e) {
            System.out.println( "ERROR: " + e.getMessage());
        }
        return null;
    }


}
