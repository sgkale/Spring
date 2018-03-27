package com.capco.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.entities.CabDetailsBO;

@FeignClient("CABSERVICE")
public interface CabClient {
	
	@RequestMapping(method=RequestMethod.POST,value="/rest/cabrequest/add")
	public Boolean AddCabRequest(@RequestBody CabDetailsBO cabDetailsBO);
	
	@RequestMapping(method=RequestMethod.GET,value="/rest/cabrequest/get/{requestId}")
	public CabDetailsBO GetCabRequest(@PathVariable("requestId") Integer requestId);

}
