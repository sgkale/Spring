package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.AccomodationDetailsBO;


public interface AccomodationService {

	public Boolean Addrequest(AccomodationDetailsBO accomodationDetailsBO);

	AccomodationDetailsBO GetAccomodationRequest(int requestId);

}
