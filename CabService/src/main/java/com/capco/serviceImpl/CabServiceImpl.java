package com.capco.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.entities.CabDetailsBO;
import com.capco.repository.CabServiceRepo;
import com.capco.service.CabService;
@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabServiceRepo repo;
	
	@Override
	public Boolean Addrequest(CabDetailsBO cabDetailsBO) {
		//MainRequestBO mainRequestBO=mainRequestDTO.getMainRequestBO();
		//mainRequestBO.setRequestId(Utils.GetRandom());
		cabDetailsBO.setCreatedOn(new Date());
		cabDetailsBO.setModifiedOn(new Date());
		repo.save(cabDetailsBO);
		return true;		
	}

	@Override
	public CabDetailsBO GetRequest(int requestId) {
		CabDetailsBO cabDetailsBO=repo.findByRequestId(requestId);
		//MainRequestDTO mainRequestDTO=new MainRequestDTO();
		//mainRequestDTO.setMainRequestBO(mainRequestBO);
		return cabDetailsBO;
	}
}
