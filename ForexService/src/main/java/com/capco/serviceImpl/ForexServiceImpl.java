package com.capco.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.entities.ForexDetailsBO;
import com.capco.repository.ForexServiceRepo;
import com.capco.service.ForexService;
@Service
public class ForexServiceImpl implements ForexService{

	@Autowired
	private ForexServiceRepo repo;
	
	
	@Override
	public Boolean addrequest(ForexDetailsBO forexDetailsBO) {
		forexDetailsBO.setCreatedOn(new Date());
		forexDetailsBO.setModifiedOn(new Date());
		repo.save(forexDetailsBO);
		return true;		
	}		
	

	@Override
	public ForexDetailsBO getRequest(int requestId) {
		ForexDetailsBO forexDetailsBO=repo.findByRequestId(requestId);
		return forexDetailsBO;
	}
}
