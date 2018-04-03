package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capco.entities.MainRequestBO;

@Repository
public interface MainrequestServiceRepo extends JpaRepository<MainRequestBO, Integer>{

	public MainRequestBO findByRequestId(int requestId);
	
	@Modifying
	@Query("update MainRequestBO m set m.currentStatus = :status where m.requestId = :id")
	public void setMainRequestBoByRequestId(@Param("status")String status,@Param("id")int requestId);
}
