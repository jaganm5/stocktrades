package com.hackerrank.stocktrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrades.model.StockTrade;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer>, JpaSpecificationExecutor<StockTrade> {

}
