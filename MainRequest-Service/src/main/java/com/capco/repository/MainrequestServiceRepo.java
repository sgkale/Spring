package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.MainRequestBO;

@Repository
public interface MainrequestServiceRepo extends JpaRepository<MainRequestBO,Integer> {

	public MainRequestBO findByRequestId(int requestId);
}
