package com.java.MarketDesign.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.java.MarketDesign.Service.Entity.MarketEntity;

@Repository
public interface  MarketRepository extends JpaRepository<MarketEntity,Long>{
	
	

	public Optional<MarketEntity> findByMarketId(Long marketId);

}
