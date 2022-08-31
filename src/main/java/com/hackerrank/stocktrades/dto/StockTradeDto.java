package com.hackerrank.stocktrades.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StockTradeDto implements Serializable {
  
  private static final long serialVersionUID = 1921840991961255512L;

  private Integer id;

  @NotNull
  @Pattern(regexp = "buy|sell", message = "Entered invalid type")
  private String type;

  @NotNull
  private Integer userId;

  @NotNull
  private String symbol;

  @NotNull
  @Min(1)
  @Max(100)
  private Integer shares;

  @NotNull
  private Integer price;

  private Long timestamp;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}