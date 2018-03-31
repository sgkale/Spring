package com.capco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.entities.MainRequestDTO;
import com.capco.service.MainrequestService;

@RestController
@RequestMapping(value="/rest/mainrequest")
public class MainrequestControllers {
	
	@Autowired
	private MainrequestService mainrequestService;
	
	@PostMapping
	@RequestMapping(value="/add")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String AddMainRequest(@RequestBody MainRequestDTO mainRequestDTO) {
		if(mainRequestDTO == null) {
			return "invalid data";
		}
		
		Integer requestId=mainrequestService.addrequest(mainRequestDTO);
		if (requestId!=null) {
			return "sucess : "+requestId;
		}
		
		return "fail";
	}
	
	@GetMapping
	@RequestMapping(value="/get/{requestId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MainRequestDTO GetMainRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		MainRequestDTO mainRequestDTO=mainrequestService.GetMainRequest(requestId);
		return mainRequestDTO;
	}
	

}
