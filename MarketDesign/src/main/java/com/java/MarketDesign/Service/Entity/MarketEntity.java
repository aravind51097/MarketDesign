package com.java.MarketDesign.Service.Entity;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Component
public class MarketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long marketId;
	private String marketName;
	private String marketAddress;
	private String marketLocation;
}
