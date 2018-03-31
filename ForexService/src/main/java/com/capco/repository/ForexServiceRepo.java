package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.ForexDetailsBO;

@Repository
public interface ForexServiceRepo extends JpaRepository<ForexDetailsBO,Integer> {

	public ForexDetailsBO findByRequestId(int requestId);
}
