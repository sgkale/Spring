package com.capco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.entities.ForexDetailsBO;
import com.capco.service.ForexService;

@RestController
@RequestMapping(value="/rest/forexrequest")
public class ForexRequestControllers {
	
	@Autowired
	private ForexService forexService;
	
	@PostMapping
	@RequestMapping(value="/add")
	public Boolean AddCabRequest(@RequestBody ForexDetailsBO forexDetailsBo) {
		if(forexDetailsBo == null) {
			return false;
		}
		
		//Integer requestId=mainrequestService.Addrequest(mainRequestDTO);
		if (forexService.addrequest(forexDetailsBo)) {
			return true;
		}
		
		return false;
	}
	
	
	@GetMapping
	@RequestMapping(value="/get/{requestId}")
	public ForexDetailsBO GetRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		ForexDetailsBO forexDetailsBO=forexService.getRequest(requestId);
		return forexDetailsBO;
	}
	

}
