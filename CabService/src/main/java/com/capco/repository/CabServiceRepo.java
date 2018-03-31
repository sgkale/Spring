package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.CabDetailsBO;

@Repository
public interface CabServiceRepo extends JpaRepository<CabDetailsBO,Integer> {

	public CabDetailsBO findByRequestId(int requestId);
}
