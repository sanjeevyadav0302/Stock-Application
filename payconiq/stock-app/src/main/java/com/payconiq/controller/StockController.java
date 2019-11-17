package com.payconiq.controller;

import com.payconiq.model.Stock;
import com.payconiq.service.StockStubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class StockController {

    @Autowired
    StockStubService stockStubService;

    /**
     * Get List of stocks
     * @return List of stocks
     */
    @GetMapping("stocks")
    public List<Stock> getStocks() {
        return stockStubService.getStocks();
    }

    /**
     * Get stock based on id
     * @param stockId
     * @return Stock
     */
    @GetMapping("stocks/{stockId}")
    public Stock getStock(@PathVariable("stockId") int stockId) {
        return stockStubService.getStock(stockId);
    }

    /**
     * Update stock with given stockId
     * @param stockId
     * @param stock
     * @return Stock
     */
    @PutMapping("stocks/{stockId}")
    public Stock updateStocks(@PathVariable("stockId") int stockId, @RequestBody Stock stock) {
        return stockStubService.updateStocksPrice(stockId, stock.getCurrentPrice());
    }

    /**
     * Create new stock
     * @param stock
     * @return Stock
     */
    @PostMapping("stocks")
    public Stock createStocks(@RequestBody Stock stock) {
        return stockStubService.createStocks(stock);
    }


}
