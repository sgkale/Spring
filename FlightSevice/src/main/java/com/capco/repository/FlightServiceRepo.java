package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.FlightDetailsBO;

@Repository
public interface FlightServiceRepo extends JpaRepository<FlightDetailsBO,Integer> {

	public FlightDetailsBO findByRequestId(int requestId);
}
