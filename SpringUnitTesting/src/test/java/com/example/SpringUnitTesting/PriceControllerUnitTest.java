package com.example.SpringUnitTesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceControllerUnitTest {

    @Test
    void shouldReturnGreeting() {
        BitCoinService bitCoinService = Mockito.mock(BitCoinService.class);
        String bitcoinPrice = "1000.056";
        PriceController priceController = new PriceController(bitCoinService);
        when(bitCoinService.getBitcoinPrice()).thenReturn(bitcoinPrice);
        String expected = "Price of Bitcoin currently: " +
                bitcoinPrice;
        String actual = priceController.price();
        assertEquals(expected, actual);
    }
}