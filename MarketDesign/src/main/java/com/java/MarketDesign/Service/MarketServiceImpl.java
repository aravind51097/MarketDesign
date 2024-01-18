package com.java.MarketDesign.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.java.MarketDesign.ErrorHandler.MarketNotFoundException;
import com.java.MarketDesign.ErrorHandler.ModelNotFoundException;
import com.java.MarketDesign.ErrorHandler.UpdateModelException;
import com.java.MarketDesign.Model.MarketModel;
import com.java.MarketDesign.Repository.MarketRepository;
import com.java.MarketDesign.Service.Entity.MarketEntity;

@Service
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	MarketRepository marketRepo;
	
	@Autowired
	MarketModel marketmodel;

	@Override
	public MarketEntity addMarkets(MarketEntity market) {
		
		return marketRepo.save(market);
	}

	@Override
	public MarketEntity getMarketById(Long marketId) throws MarketNotFoundException {
		
		Optional<MarketEntity> market=marketRepo.findByMarketId(marketId);
		System.out.println(market);
		
		if(market.isEmpty()) {
			
			throw new MarketNotFoundException("Sorry Market not found for the ID :");
		}
		
		return market.get();
	}

	@Override
	public MarketEntity updatemarketDetails(MarketEntity market, Long id) throws UpdateModelException {
			
		Optional<MarketEntity> marketDB= marketRepo.findById(id);
		
		if(marketDB.isEmpty()) {
			throw new UpdateModelException("Sorry Record not found for Update ");
		}
		
		MarketEntity marketDB_found = marketDB.get();
		
		if(Objects.nonNull(market) && !"".equalsIgnoreCase(market.getMarketName())) {
			marketDB_found.setMarketName(market.getMarketName());
		}
		
		if(Objects.nonNull(market) && !"".equalsIgnoreCase(market.getMarketAddress())) {
			marketDB_found.setMarketAddress(market.getMarketAddress());
		}
		
		
		if(Objects.nonNull(market) && !"".equalsIgnoreCase(market.getMarketLocation())) {
			marketDB_found.setMarketLocation(market.getMarketLocation());
		}
		
		return marketRepo.save(marketDB_found);
	}

	@Override
	public void deleteMarketbyId(Long id) {
		marketRepo.deleteById(id);
		
	}

	@Override
	public List<MarketEntity> getAllMarkets() {
		
		return marketRepo.findAll();
	}

	@Override
	public MarketModel getModel(long id) throws ModelNotFoundException {
		
		Optional<MarketEntity> market=marketRepo.findById(id);
		
		System.out.println("Before market object Check ");
		if(market.isEmpty()) {
			throw new ModelNotFoundException("Sorry Model Not found ! ");
		}else {
			marketmodel.setStatus(HttpStatus.OK);
		}
		
		MarketEntity market_found=market.get();
		
		marketmodel.setMarketEntityInModelClass(market_found);
		marketmodel.setMessage("Record successFully retrived  ! ");	
		
		return marketmodel;
	}

}
