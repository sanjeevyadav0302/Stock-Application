package com.payconiq.service;

import com.payconiq.exception.StockIdNotFoundException;
import com.payconiq.model.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class StockStubServiceTest {

    @InjectMocks
    StockStubService stockStubService;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateStocksPrice_ShouldSuccess_ForExistingStockId() {
        Stock stock = stockStubService.updateStocksPrice(2, 500.02);
        assertEquals(2, stock.getId());
        assertEquals(500.02, stock.getCurrentPrice(), 2);
    }

    @Test(expected = StockIdNotFoundException.class)
    public void updateStocksPrice_ThrowException_ForNonExistingStockId() {
        Stock stock = stockStubService.updateStocksPrice(11, 100.02);
    }

    @Test
    public void getStock_ShouldSuccess_ForExistingStockId() {
        Stock stock = stockStubService.getStock(1);
        assertEquals(1, stock.getId());
        assertEquals("ING BANK1", stock.getName());
        assertEquals(100.01, stock.getCurrentPrice(), 2);

    }

    @Test(expected = StockIdNotFoundException.class)
    public void getStock_ThrowException_ForNonExistingStockId() {
        Stock stock = stockStubService.getStock(111);
    }

    @Test
    public void createStock_Success_ForValidRequest() {
        Stock stock = new Stock();
        stock.setName( "SAN");
        stock.setId(22);
        stock.setCurrentPrice(500.01);
        Stock newStock = stockStubService.createStocks(stock);
        assertEquals("SAN", stock.getName());
        assertEquals(22, stock.getId());
        assertEquals(500.01, stock.getCurrentPrice(),2);
    }

    @Test
    public void getStock_Success() {

        List<Stock> stocks = stockStubService.getStocks();
        assertEquals(5, stocks.size());
        assertEquals("ING BANK1", stocks.get(0).getName());
        assertEquals("ING BANK2", stocks.get(1).getName());
        assertEquals("ING BANK3", stocks.get(2).getName());
        assertEquals("ING BANK4", stocks.get(3).getName());
        assertEquals("ING BANK5", stocks.get(4).getName());
        assertEquals(1, stocks.get(0).getId());
        assertEquals(2, stocks.get(1).getId());
        assertEquals(3, stocks.get(2).getId());
        assertEquals(4, stocks.get(3).getId());
        assertEquals(5, stocks.get(4).getId());
        assertEquals(100.01, stocks.get(0).getCurrentPrice(),2);
        assertEquals(101.01, stocks.get(1).getCurrentPrice(),2);
        assertEquals(102.01, stocks.get(2).getCurrentPrice(),2);
        assertEquals(103.01, stocks.get(3).getCurrentPrice(),2);
        assertEquals(104.01, stocks.get(4).getCurrentPrice(),2);
    }

}
