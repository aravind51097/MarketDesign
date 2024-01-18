package com.java.MarketDesign.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.java.MarketDesign.Service.MarketService;
import com.java.MarketDesign.Service.Entity.MarketEntity;


@WebMvcTest
class MarketControllerTest {
	
	@MockBean
	public MarketService marketService;
	
	@Autowired
	public MockMvc mockMvc;
	
	MarketEntity market_res;
	
	
	@BeforeEach
	void setUp() throws Exception {
		  market_res=MarketEntity.builder()
				 				.marketId(1L)
				 				.marketAddress("KA")
				 				.marketLocation("Marathalli")
				 				.marketName("D-Mart")
				 				.build();
		
		
	}

	@Test
	void addDepartment() throws Exception {
		
		MarketEntity market_input=MarketEntity.builder()
 				.marketAddress("KA")
 				.marketLocation("Marathalli")
 				.marketName("D-Mart")
 				.build();
		Mockito.when(marketService.addMarkets(market_input)).thenReturn(market_res);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/addMarkets")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\r\n"
								+ "    \"marketName\":\"D-Mart\",\r\n"
								+ "    \"marketLocation\":\"Delhi\",\r\n"
								+ "    \"marketAddress\":\"KA\"\r\n"
								+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}

}
