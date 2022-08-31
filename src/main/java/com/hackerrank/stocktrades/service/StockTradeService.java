package com.hackerrank.stocktrades.service;

import java.util.List;

import com.hackerrank.stocktrades.dto.StockTradeDto;
import com.hackerrank.stocktrades.model.StockTrade;

public interface StockTradeService {

   StockTradeDto saveStockTrade(StockTradeDto stockTradeDto);
   
   List<StockTrade> getAllStockTrades(String type, String userId);
   
   StockTradeDto getStockTradeById(Integer stockTradeId);
}