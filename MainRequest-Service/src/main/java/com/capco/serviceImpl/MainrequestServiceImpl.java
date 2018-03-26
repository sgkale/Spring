package com.capco.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.entities.MainRequestBO;
import com.capco.entities.MainRequestDTO;
import com.capco.repository.MainrequestServiceRepo;
import com.capco.service.MainrequestService;
import com.capco.utils.Utils;

@Service
public class MainrequestServiceImpl implements MainrequestService{

	@Autowired
	private MainrequestServiceRepo repo;
	
	@Override
	public Boolean addrequest(MainRequestDTO mainRequestDTO) {
		MainRequestBO mainRequestBO=mainRequestDTO.getMainRequestBO();
		mainRequestBO.setRequestId(Utils.GetRandom());
		repo.save(mainRequestBO);
		return true;		
	}

	@Override
	public MainRequestDTO GetMainRequest(int requestId) {
		MainRequestBO mainRequestBO=repo.findByRequestId(requestId);
		MainRequestDTO mainRequestDTO=new MainRequestDTO();
		mainRequestDTO.setMainRequestBO(mainRequestBO);
		return mainRequestDTO;
	}
}
