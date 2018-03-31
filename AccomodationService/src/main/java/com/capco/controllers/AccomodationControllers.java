package com.capco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.entities.AccomodationDetailsBO;
import com.capco.service.AccomodationService;

@RestController
@RequestMapping(value="/rest/accomodationrequest")
public class AccomodationControllers {
	
	@Autowired
	private AccomodationService accomodationService;
	
	@PostMapping
	@RequestMapping(value="/add")
	public Boolean AddAccomodationRequest(@RequestBody AccomodationDetailsBO accomodationDetailsBO) {
		if(accomodationDetailsBO == null) {
			return false;
		}
		
		//Integer requestId=mainrequestService.Addrequest(mainRequestDTO);
		if (accomodationService.Addrequest(accomodationDetailsBO)) {
			return true;
		}
		
		return false;
	}
	
	@GetMapping
	@RequestMapping(value="/get/{requestId}")
	public AccomodationDetailsBO GetAccomodationRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		AccomodationDetailsBO accomodationDetailsBO=accomodationService.GetAccomodationRequest(requestId);
		return accomodationDetailsBO;
	}
	

}
