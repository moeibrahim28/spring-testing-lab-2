package com.example.SpringUnitTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BitCoinService bitCoinService;

    @Test
    void price() throws Exception {
        mockMvc.perform(get("/bitcoin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Price of Bitcoin currently: ")));
    }


}
