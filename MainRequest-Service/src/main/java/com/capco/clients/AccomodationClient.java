package com.capco.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.entities.AccomodationDetailsBO;

@FeignClient("ACCOMODATIONSERVICE")
@RibbonClient(name="ACCOMODATIONSERVICE")
public interface AccomodationClient {

	@RequestMapping(method=RequestMethod.POST,value="/rest/accomodationrequest/add")
	public Boolean AddAccomodationRequest(@RequestBody AccomodationDetailsBO accomodationDetailsBO);
	
	@RequestMapping(method=RequestMethod.GET,value="/rest/accomodationrequest/get/{requestId}")
	public AccomodationDetailsBO GetAccomodationRequest(@PathVariable("requestId") Integer requestId);
}
