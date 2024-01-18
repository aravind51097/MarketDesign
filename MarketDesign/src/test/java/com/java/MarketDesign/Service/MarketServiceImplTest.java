package com.java.MarketDesign.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.MarketDesign.ErrorHandler.MarketNotFoundException;
import com.java.MarketDesign.Repository.MarketRepository;
import com.java.MarketDesign.Service.Entity.MarketEntity;




@SpringBootTest
class MarketServiceImplTest {
	
	@MockBean
	public MarketRepository marketRepository;
	
	@Autowired
	MarketService marketService;
			
	@BeforeEach
	void setUp() throws Exception {
		
		MarketEntity market_obj=
				MarketEntity.builder()
				.marketId(1L)
				.marketAddress("Hosur")
				.marketLocation("KA")
				.marketName("D-mart")
				.build();
		System.out.println("Mocking the method");
		
		Optional<MarketEntity> markets=Optional.ofNullable(market_obj);
		
		Mockito.when(marketRepository.findByMarketId(1L)).thenReturn(markets);
		
	}

	
	@Test
	public void whenGetMarketByIdCalled() throws MarketNotFoundException {
		
		MarketEntity marketEnity=marketService.getMarketById(1L);
		
		assertEquals("KA", marketEnity.getMarketLocation());
		
	}

}
