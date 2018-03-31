package com.capco.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.entities.ForexDetailsBO;

@FeignClient("FOREXSERVICE")
@RibbonClient(name="FOREXSERVICE")
public interface ForexClient {
	@RequestMapping(method=RequestMethod.POST,value="/rest/forexrequest/add")
	public Boolean addRequest(@RequestBody ForexDetailsBO forexDetailsBO);
	
	@RequestMapping(method=RequestMethod.GET,value="/rest/forexrequest/get/{requestId}")
	public ForexDetailsBO getRequest(@PathVariable("requestId") Integer requestId);

}
