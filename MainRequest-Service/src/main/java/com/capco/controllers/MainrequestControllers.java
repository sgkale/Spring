package com.capco.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
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
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN')")
	public MainRequestDTO GetMainRequest(@PathVariable("requestId") Integer requestId) {
		if(requestId == null) {
			return null;
		}
		MainRequestDTO mainRequestDTO=mainrequestService.GetMainRequest(requestId);
		return mainRequestDTO;
	}
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.POST, value="/changestatus/{status}/id/{requestid}")
	public String changeRequestStatus(@PathVariable("requestid")int requestid,@PathVariable("status") String status) {
		System.out.println("inside change status");
		String stautscode=mainrequestService.changeRequestStatus(requestid,status);
		return stautscode;
	}
	

}
