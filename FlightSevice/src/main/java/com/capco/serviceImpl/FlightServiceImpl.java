package com.capco.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.entities.FlightDetailsBO;
import com.capco.repository.FlightServiceRepo;
import com.capco.service.FlightService;
@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightServiceRepo repo;
	
	
	@Override
	public Boolean addrequest(FlightDetailsBO flightDetailsBO) {
		flightDetailsBO.setCreatedOn(new Date());
		flightDetailsBO.setModifiedOn(new Date());
		repo.save(flightDetailsBO);
		return true;		
	}		
	

	@Override
	public FlightDetailsBO getRequest(int requestId) {
		FlightDetailsBO flightDetailsBO=repo.findByRequestId(requestId);
		return flightDetailsBO;
	}
}
