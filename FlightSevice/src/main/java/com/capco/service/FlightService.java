package com.capco.service;

import org.springframework.stereotype.Service;

import com.capco.entities.FlightDetailsBO;


public interface FlightService {

	public Boolean addrequest(FlightDetailsBO flightDetailsBO);

	FlightDetailsBO getRequest(int requestId);

}
