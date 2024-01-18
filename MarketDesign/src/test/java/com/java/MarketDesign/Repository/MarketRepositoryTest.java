package com.java.MarketDesign.Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.java.MarketDesign.Service.Entity.MarketEntity;


@DataJpaTest
class MarketRepositoryTest {
	
	@Autowired
	private MarketRepository marketRepo;
	
	@Autowired
	private TestEntityManager testEnitity;
	
	
	

	@BeforeEach
	void setUp()  {
		
		MarketEntity marketEntity=MarketEntity.builder()
				.marketAddress("Martahlli")
				.marketLocation("KA")
				.marketName("D-Mart")
				.build();
		
		testEnitity.persist(marketEntity);
		
		
	}

	@Test
	@DisplayName("When market repository called for ID ")
	void test() {
	
		MarketEntity market =marketRepo.findById(1L).get();
		
		assertEquals("KA", market.getMarketLocation());
	
	}

}
