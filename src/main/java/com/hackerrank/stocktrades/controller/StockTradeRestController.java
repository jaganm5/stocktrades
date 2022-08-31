package com.hackerrank.stocktrades.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrades.dto.StockTradeDto;
import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.service.StockTradeService;

@RestController
@RequestMapping(value = "/trades")
public class StockTradeRestController {

  @Autowired
  private StockTradeService stockTradeService;

  
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StockTradeDto> saveStockTrade(@Valid @RequestBody StockTradeDto stockTradeDto) {
    StockTradeDto savedStockTrade = stockTradeService.saveStockTrade(stockTradeDto);    
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStockTrade);
  }
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StockTrade>> getAllStockTrades(@RequestParam(required = false) String type, @RequestParam(required = false) String userId){
	  List<StockTrade> stockTradeList = stockTradeService.getAllStockTrades(type, userId);
	  return new ResponseEntity<>(stockTradeList, HttpStatus.OK);
  }
  
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StockTradeDto> getStockTrade(@PathVariable Integer id) {
	  StockTradeDto stockTradeDto = stockTradeService.getStockTradeById(id);
	  return new ResponseEntity<>(stockTradeDto, HttpStatus.OK);
  }
  
  

}