package com.payconiq.service;

import com.payconiq.exception.StockIdNotFoundException;
import com.payconiq.model.Stock;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Service to create static stocks and handle them.
 */
@Service
public class StockStubService {

    private static Map<Integer, Stock> stocks = new HashMap<>();

    /**
     * Stub stocks
     */
    static {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Stock stock = new Stock(i, "ING BANK" + i, 100.01 + i);
            stocks.put(i, stock);
        });
    }

    /**
     *
     * @return list of stocks
     */
    public List<Stock> getStocks() {
        return new ArrayList<Stock>(stocks.values());
    }

    /**
     *
     * @param stockId
     * @return Stock
     */
    public Stock getStock(int stockId) {
        return Optional.ofNullable(stocks.get(stockId)).orElseThrow(() -> new StockIdNotFoundException("Stock Id Not Found"));
    }

    /**
     *
     * @param stockId
     * @param price
     * @return Stock
     */
    public Stock updateStocksPrice(int stockId, double price) {
        Stock stoc = Optional.ofNullable(stocks.get(stockId)).orElseThrow(() -> new StockIdNotFoundException("Stock Id Not Found"));
        stoc.setCurrentPrice(price);
        stoc.setLastUpdate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        return stoc;
    }

    /**
     *
     * @param stock
     * @return Stock
     */
    public Stock createStocks(Stock stock) {
        stocks.put(stock.getId(), stock);
        return stock;
    }
}
