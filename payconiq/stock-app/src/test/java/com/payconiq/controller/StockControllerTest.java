package com.payconiq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payconiq.exception.StockIdNotFoundException;
import com.payconiq.model.Stock;
import com.payconiq.service.StockStubService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockStubService stockStubService;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStocks_Success_ShouldReturnOkResponse() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(22);
        stock.setCurrentPrice(500.01);
        when(stockStubService.getStocks())
                .thenReturn(Arrays.asList(stock));
        mockMvc.perform(get("/api/stocks").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getStock_Success_ShouldReturnOkResponse() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(22);
        stock.setCurrentPrice(500.01);
        when(stockStubService.getStock(1))
                .thenReturn(stock);
        mockMvc.perform(get("/api/stocks/{stockId}", 1).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void getStock_ThrowException_ForNonExistingStockId() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(22);
        stock.setCurrentPrice(500.01);
        when(stockStubService.getStock(1))
                .thenThrow(new StockIdNotFoundException("Stock id not found"));
        mockMvc.perform(get("/api/stocks/{stockId}", 1).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateStock_Success_ShouldReturnOkResponse() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(1);
        stock.setCurrentPrice(100.02);
        when(stockStubService.updateStocksPrice(1, 100.02))
                .thenReturn(stock);
        mockMvc.perform(put("/api/stocks/{stockId}", 1)
                .contentType("application/json")
                .content(asJsonString(stock)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStock_ThrowException_ForNoNExistingStockId() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(11);
        stock.setCurrentPrice(100.02);
        when(stockStubService.updateStocksPrice(11, 100.02))
                .thenThrow(new StockIdNotFoundException("Stock id not found"));
        mockMvc.perform(put("/api/stocks/{stockId}", 11)
                .contentType("application/json")
                .content(asJsonString(stock)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createStock_Success_ShouldReturnOkResponse() throws Exception {
        Stock stock = new Stock();
        stock.setName("SAN");
        stock.setId(1);
        stock.setCurrentPrice(100.02);
        when(stockStubService.updateStocksPrice(1, 100.02))
                .thenReturn(stock);
        mockMvc.perform(post("/api/stocks", 1)
                .contentType("application/json")
                .content(asJsonString(stock)))
                .andExpect(status().isOk());
    }
}
