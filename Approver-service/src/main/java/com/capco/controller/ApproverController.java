package com.capco.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capco.clients.MainRequestClient;

@RestController
@RequestMapping(value="/rest/approver")
public class ApproverController {

	@Autowired
	private MainRequestClient mainRequestClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping
	@RequestMapping(value="/approve/{requestid}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String approveRequest(@PathVariable("requestid") Integer requestId,HttpServletRequest request) throws Exception {
		String token=request.getHeader("Authorization");
		System.out.println(" "+token);
		if(requestId==null) {
			throw new Exception("invalid data");
		}
		String response=changeRequestStatus(request, requestId, "Approved");
		if (response.equals("success")) {
			return "Approved";
		}
		return response;
		
	}
	
	
	@PostMapping
	@RequestMapping(value="/reject/{requestid}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String rejectRequest(@PathVariable("requestid") Integer requestId,HttpServletRequest request) throws Exception{
		String token=request.getHeader("Authorization");
		System.out.println("Auth"+token);
		if(requestId==null) {
			throw new Exception("invalid data");
		}
		String response=changeRequestStatus(request, requestId, "Rejected");
		if (response.equals("success")) {
			return "Rejected";
		}
		return response;		
	}
	
	public String changeRequestStatus(HttpServletRequest request,int requestId,String status) {
		List<ServiceInstance> instances=discoveryClient.getInstances("MAINREQUESTSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl = baseUrl+"/rest/mainrequest/changestatus/"+status+"/id/"+requestId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,HttpMethod.POST, getHeaders(request),String.class);
		
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody();
	}
	
	private static HttpEntity<?> getHeaders(HttpServletRequest request) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", request.getHeader("Authorization"));
		return new HttpEntity<>(headers);
	}
}
