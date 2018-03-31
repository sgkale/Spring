package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.AccomodationDetailsBO;

@Repository
public interface AccomodationtServiceRepo extends JpaRepository<AccomodationDetailsBO,Integer> {

	public AccomodationDetailsBO findByRequestId(int requestId);
}
