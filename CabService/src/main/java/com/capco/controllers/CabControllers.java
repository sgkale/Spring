package com.capco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.entities.CabDetailsBO;
import com.capco.service.CabService;

@RestController
@RequestMapping(value="/rest/cabrequest")
public class CabControllers {
	
	@Autowired
	private CabService cabService;
	
	@PostMapping
	@RequestMapping(value="/add")
	public Boolean AddCabRequest(@RequestBody CabDetailsBO cabDetailsBO) {
		if(cabDetailsBO == null) {
			return false;
		}
		
		//Integer requestId=mainrequestService.Addrequest(mainRequestDTO);
		if (cabService.Addrequest(cabDetailsBO)) {
			return true;
		}
		
		return false;
	}
	
	@GetMapping
	@RequestMapping(value="/get/{requestId}")
	public CabDetailsBO getCabRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		CabDetailsBO cabDetailsBO=cabService.GetRequest(requestId);
		return cabDetailsBO;
	}
	

}
