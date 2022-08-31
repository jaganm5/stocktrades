package com.hackerrank.stocktrades.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrades.dto.StockTradeDto;
import com.hackerrank.stocktrades.exception.RecordNotFoundException;
import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import com.hackerrank.stocktrades.service.StockTradeService;

@Service
public class StockTradeServiceImpl implements StockTradeService {

  @Autowired
  private StockTradeRepository stockTradeRepo;

  @Override
  public StockTradeDto saveStockTrade(StockTradeDto stockTradeDto) {
    StockTrade stockTrade = new StockTrade();
    BeanUtils.copyProperties(stockTradeDto, stockTrade);
    StockTrade savedStockTrade = stockTradeRepo.save(stockTrade);
    stockTradeDto.setId(savedStockTrade.getId());
    return stockTradeDto;
  }

 @Override
 public List<StockTrade> getAllStockTrades(String type, String userId) {
	Specification<StockTrade> specification = getSpecification(type, userId);
	List<StockTrade> stockTradeList = stockTradeRepo.findAll(specification);
	return stockTradeList;
 }

 private Specification<StockTrade> getSpecification(String type, String userId){
	return (root, query, criteriaBuilder) -> {
		List<Predicate> predicates = new ArrayList<>();
		if(type != null && !type.isEmpty()) {
			predicates.add(criteriaBuilder.equal(root.get("type"), type));
		}
		if(userId != null && !userId.isEmpty()) {
			predicates.add(criteriaBuilder.equal(root.get("userId"), userId));
		}
		query.orderBy(criteriaBuilder.asc(root.get("id")));
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	};
 }
 

 @Override
 public StockTradeDto getStockTradeById(Integer stockTradeId) {
	 Optional<StockTrade> optionalStock = stockTradeRepo.findById(stockTradeId);
	 if(!optionalStock.isPresent()) {
		 throw new RecordNotFoundException("The stock trade with id " + stockTradeId + " is not found", "E-4004");
	 }
	 StockTrade stockTrade = optionalStock.get();
	 StockTradeDto dto = new StockTradeDto();
	 BeanUtils.copyProperties(stockTrade, dto);
	 return dto;
 }

}