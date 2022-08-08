package com.example.SpringUnitTesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    private BitCoinService bitCoinService;

    public PriceController(BitCoinService bitCoinService) {
        this.bitCoinService = bitCoinService;
    }

    @GetMapping("/bitcoin")
    public String price() {
               String greeting = "Price of Bitcoin currently: " + bitCoinService.getBitcoinPrice();
        return greeting;
    }

}