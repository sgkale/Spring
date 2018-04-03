package com.capco.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.entities.ApproverBO;

@Repository
public interface ApproverRepository  extends JpaRepository<ApproverBO, Integer>{
	
	public ApproverBO findByApproverId(int approverId);
	
	public ApproverBO findByLevel(int level);

}
