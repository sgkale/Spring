package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.ForexDetailsBO;


public interface ForexService {

	public Boolean addrequest(ForexDetailsBO forexDetailsBO);

	ForexDetailsBO getRequest(int requestId);

}
