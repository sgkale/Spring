package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.CabDetailsBO;


public interface CabService {

	public Boolean Addrequest(CabDetailsBO cabDetailsBO);

	CabDetailsBO GetRequest(int requestId);

}
