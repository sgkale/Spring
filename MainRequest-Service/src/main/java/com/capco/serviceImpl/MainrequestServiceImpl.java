package com.capco.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.clients.AccomodationClient;
import com.capco.clients.CabClient;
import com.capco.clients.FlightClient;
import com.capco.clients.ForexClient;
import com.capco.entities.AccomodationDetailsBO;
import com.capco.entities.CabDetailsBO;
import com.capco.entities.FlightDetailsBO;
import com.capco.entities.ForexDetailsBO;
import com.capco.entities.MainRequestBO;
import com.capco.entities.MainRequestDTO;
import com.capco.repository.MainrequestServiceRepo;
import com.capco.service.MainrequestService;
import com.capco.utils.Utils;

@Service
public class MainrequestServiceImpl implements MainrequestService{

	@Autowired
	private MainrequestServiceRepo repo;
	
	@Autowired
	private AccomodationClient accomodationClient;
	
	@Autowired
	private CabClient cabclient;
	
	@Autowired
	private ForexClient forexClient;
	
	@Autowired
	private FlightClient flightClient;
	
	@Override
	public int addrequest(MainRequestDTO mainRequestDTO) {
		MainRequestBO mainRequestBO=mainRequestDTO.getMainRequestBO();
		mainRequestBO.setRequestId(Utils.GetRandom());
		mainRequestBO.setCreatedOn(new Date());
		mainRequestBO.setModifiedOn(new Date());
		repo.save(mainRequestBO);
		if(mainRequestDTO.getAccomodationDetailsBO()!=null) {
			AccomodationDetailsBO accomodationDetailsBO=mainRequestDTO.getAccomodationDetailsBO();
			accomodationDetailsBO.setRequestId(mainRequestBO.getRequestId());
			accomodationClient.AddAccomodationRequest(accomodationDetailsBO);
		}
		if(mainRequestDTO.getCabDetailsBO()!=null) {
			CabDetailsBO cabDetailsBO=mainRequestDTO.getCabDetailsBO();
			cabDetailsBO.setRequestId(mainRequestBO.getRequestId());
			cabclient.AddCabRequest(cabDetailsBO);
		}
		if(mainRequestDTO.getForexDetailsBO()!=null) {
			ForexDetailsBO forexDetailsBO=mainRequestDTO.getForexDetailsBO();
			forexDetailsBO.setRequestId(mainRequestBO.getRequestId());
			forexClient.addRequest(forexDetailsBO);
		}
		if(mainRequestDTO.getFlightDetailsBO()!=null) {
			FlightDetailsBO flightDetailsBO=mainRequestDTO.getFlightDetailsBO();
			flightDetailsBO.setRequestId(mainRequestBO.getRequestId());
			flightClient.addRequest(flightDetailsBO);
		}
		return mainRequestBO.getRequestId();		
	}

	@Override
	public MainRequestDTO GetMainRequest(int requestId) {
		MainRequestBO mainRequestBO=repo.findByRequestId(requestId);
		MainRequestDTO mainRequestDTO=new MainRequestDTO();
		mainRequestDTO.setMainRequestBO(mainRequestBO);
		mainRequestDTO.setAccomodationDetailsBO(accomodationClient.GetAccomodationRequest(requestId));
		mainRequestDTO.setCabDetailsBO(cabclient.GetCabRequest(requestId));
		mainRequestDTO.setForexDetailsBO(forexClient.getRequest(requestId));
		mainRequestDTO.setFlightDetailsBO(flightClient.getRequest(requestId));
		return mainRequestDTO;
	}
}
