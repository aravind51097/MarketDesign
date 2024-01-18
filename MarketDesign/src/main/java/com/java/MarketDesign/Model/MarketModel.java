package com.java.MarketDesign.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.java.MarketDesign.Service.Entity.MarketEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MarketModel {
	
	@Autowired
	private MarketEntity marketEntityInModelClass;
	private String message;
	private HttpStatus status;

}
