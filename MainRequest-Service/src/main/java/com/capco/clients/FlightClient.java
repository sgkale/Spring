package com.capco.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.entities.FlightDetailsBO;

@FeignClient("FLIGHTSERVICE")
@RibbonClient(name="FLIGHTSERVICE")
public interface FlightClient {
	
	@RequestMapping(method=RequestMethod.POST,value="/rest/flightrequest/add")
	public Boolean addRequest(@RequestBody FlightDetailsBO flightDetailsBO);
	
	@RequestMapping(method=RequestMethod.GET,value="/rest/flightrequest/get/{requestId}")
	public FlightDetailsBO getRequest(@PathVariable("requestId") Integer requestId);

}
