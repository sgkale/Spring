package com.capco.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("MAINREQUESTSERVICE")
public interface MainRequestClient {
	
	@RequestMapping(method=RequestMethod.POST, value="/rest/mainrequest/changestatus/{status}/id/{requestid}")
	public String changeRequestStatus(@RequestHeader("Authorization") String token,@PathVariable("requestid")int requestid,@PathVariable("status") String status);

}
