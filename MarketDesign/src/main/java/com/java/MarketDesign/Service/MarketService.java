package com.java.MarketDesign.Service;

import java.util.List;

import com.java.MarketDesign.ErrorHandler.MarketNotFoundException;
import com.java.MarketDesign.ErrorHandler.ModelNotFoundException;
import com.java.MarketDesign.ErrorHandler.UpdateModelException;
import com.java.MarketDesign.Model.MarketModel;
import com.java.MarketDesign.Service.Entity.MarketEntity;

public interface MarketService {

	MarketEntity addMarkets(MarketEntity market);

	MarketEntity getMarketById(Long marketId) throws MarketNotFoundException;

	MarketEntity updatemarketDetails(MarketEntity market, Long id) throws UpdateModelException;

	void deleteMarketbyId(Long id);

	List<MarketEntity> getAllMarkets();

	MarketModel getModel(long id) throws  ModelNotFoundException;

}
