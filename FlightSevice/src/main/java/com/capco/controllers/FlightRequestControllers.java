package com.capco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.entities.FlightDetailsBO;
import com.capco.service.FlightService;

@RestController
@RequestMapping(value="/rest/flightrequest")
public class FlightRequestControllers {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping
	@RequestMapping(value="/add")
	public Boolean AddFlightRequest(@RequestBody FlightDetailsBO flightDetailsBO) {
		if(flightDetailsBO == null) {
			return false;
		}
		
		//Integer requestId=mainrequestService.Addrequest(mainRequestDTO);
		if (flightService.addrequest(flightDetailsBO)) {
			return true;
		}
		
		return false;
	}
	
	
	@GetMapping
	@RequestMapping(value="/get/{requestId}")
	public FlightDetailsBO GetRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		FlightDetailsBO flightDetailsBO=flightService.getRequest(requestId);
		return flightDetailsBO;
	}
	

}
