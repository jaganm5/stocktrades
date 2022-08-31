package com.hackerrank.stocktrades.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StockTrade {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Integer userId;
    private String symbol;
    private Integer shares;
    private Integer price;
    private Long timestamp;

    public StockTrade() {
    }

    public StockTrade(String type, Integer userId, String symbol, Integer shares, Integer price, Long timestamp) {
      this.type = type;
      this.userId = userId;
      this.symbol = symbol;
      this.shares = shares;
      this.price = price;
      this.timestamp = timestamp;
    }
    
    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public Integer getUserId() {
      return userId;
    }

    public void setUserId(Integer userId) {
      this.userId = userId;
    }

    public Integer getShares() {
      return shares;
    }

    public void setShares(Integer shares) {
      this.shares = shares;
    }

    public Integer getPrice() {
      return price;
    }

    public void setPrice(Integer price) {
      this.price = price;
    }

    public Long getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
    }

}
