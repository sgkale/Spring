package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.MainRequestDTO;


public interface MainrequestService {

	public Boolean addrequest(MainRequestDTO mainRequestDTO);

	MainRequestDTO GetMainRequest(int requestId);

}
