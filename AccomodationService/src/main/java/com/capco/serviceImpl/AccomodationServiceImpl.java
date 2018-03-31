package com.capco.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.entities.AccomodationDetailsBO;
import com.capco.repository.AccomodationtServiceRepo;
import com.capco.service.AccomodationService;
@Service
public class AccomodationServiceImpl implements AccomodationService{

	@Autowired
	private AccomodationtServiceRepo repo;
	
	@Override
	public Boolean Addrequest(AccomodationDetailsBO accomodationDetailsBO) {
		//MainRequestBO mainRequestBO=mainRequestDTO.getMainRequestBO();
		//mainRequestBO.setRequestId(Utils.GetRandom());
		accomodationDetailsBO.setCreatedOn(new Date());
		accomodationDetailsBO.setModifiedOn(new Date());
		repo.save(accomodationDetailsBO);
		return true;		
	}

	@Override
	public AccomodationDetailsBO GetAccomodationRequest(int requestId) {
		AccomodationDetailsBO accomodationDetailsBO=repo.findByRequestId(requestId);
		//MainRequestDTO mainRequestDTO=new MainRequestDTO();
		//mainRequestDTO.setMainRequestBO(mainRequestBO);
		return accomodationDetailsBO;
	}
}
