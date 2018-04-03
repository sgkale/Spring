package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.MainRequestDTO;


public interface MainrequestService {

	public int addrequest(MainRequestDTO mainRequestDTO);

	MainRequestDTO GetMainRequest(int requestId);

	public String changeRequestStatus(int requestid, String status);

}
