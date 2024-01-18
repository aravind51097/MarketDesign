package com.java.MarketDesign.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.MarketDesign.ErrorHandler.MarketNotFoundException;
import com.java.MarketDesign.ErrorHandler.ModelNotFoundException;
import com.java.MarketDesign.ErrorHandler.UpdateModelException;
import com.java.MarketDesign.Model.MarketModel;
import com.java.MarketDesign.Service.MarketService;
import com.java.MarketDesign.Service.Entity.MarketEntity;

@RestController
public class MarketController {
	
	@Autowired
	private MarketService marketService;
	
	@PostMapping("/addMarkets")
	public MarketEntity addMarkets(@RequestBody MarketEntity market) {
		
		return marketService.addMarkets(market);
		
	}
	
	
	@GetMapping("/getMarket/{id}")
	public MarketEntity getMarket(@PathVariable("id") Long marketId) throws MarketNotFoundException {
		
		return marketService.getMarketById(marketId);
		
	}
	
	@PutMapping("/updateMarket/{id}")
	public MarketEntity updateMarket(@RequestBody MarketEntity market,
			@PathVariable("id") Long id	) throws UpdateModelException {
		return marketService.updatemarketDetails(market,id);
	}
	
	@DeleteMapping("/deleteMarket/{id}")
	public String deleteMarket( @PathVariable("id") Long id) {
		
		marketService.deleteMarketbyId(id);
		
		return "Market successfully deleted ! ";
	}
	
	@GetMapping("/getAllMarkets")
	public List<MarketEntity> getAllMarkets(){
		
		return marketService.getAllMarkets();
	}
	
	@GetMapping("/getMarketModel/{id}")
	public MarketModel marketModel(@PathVariable("id") long id) throws ModelNotFoundException {
		
		return marketService.getModel(id);
		
	}
	
}
