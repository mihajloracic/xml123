package com.example.demo.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.Smestaj;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SmestajService;

import javassist.NotFoundException;
import rs.ac.uns.ftn.agenti.CreateSmestajIdReponse;
import rs.ac.uns.ftn.agenti.CreateSmestajIdRequest;
import rs.ac.uns.ftn.agenti.CreateSmestajRequest;
import rs.ac.uns.ftn.agenti.CreateSmestajResponse;
import rs.ac.uns.ftn.agenti.GetSmestajForUserRequest;
import rs.ac.uns.ftn.agenti.GetSmestajForUserResponse;
import rs.ac.uns.ftn.agenti.LoginAgentRequest;
import rs.ac.uns.ftn.agenti.LoginAgentResponse;
import rs.ac.uns.ftn.agenti.SmestajWS;
import rs.ac.uns.ftn.agenti.UserWS;

@Endpoint
public class SmestajEndpoint extends EndpointMapper{

	public static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agenti";
    
    @Autowired
	SmestajService smestajService;
    
    @Autowired
    UserRepository userRepository;
    
    public SmestajEndpoint() {
  		super(Smestaj.class,SmestajWS.class);
  	}
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createSmestajIdRequest")
    @ResponsePayload
    public CreateSmestajIdReponse createId(@RequestPayload CreateSmestajIdRequest request) throws NotFoundException {
    	Smestaj smestaj = new Smestaj();
    	smestaj = smestajService.addSmestaj(smestaj);
    	CreateSmestajIdReponse response = new CreateSmestajIdReponse();
    	response.setId(smestaj.getId());
    	return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createSmestajRequest")
    @ResponsePayload
    public CreateSmestajResponse saveSmestaj(@RequestPayload CreateSmestajRequest request) throws NotFoundException {
    	Smestaj smestaj = new Smestaj();
    	CreateSmestajResponse response = objectFactory.createCreateSmestajResponse();
    	mapper.map(request.getSmestajWS(), smestaj);
    	smestaj = smestajService.addSmestaj(smestaj);
    	SmestajWS smestajWS = objectFactory.createSmestajWS();
    	mapper.map(smestaj, smestajWS);
    	response.setSmestajWS(smestajWS);
    	return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSmestajForUserRequest")
    @ResponsePayload
    public GetSmestajForUserResponse getSmestajForUser(@RequestPayload GetSmestajForUserRequest request) {
    	User user = userRepository.getOne(request.getId());
    	List<Smestaj> smestajs = smestajService.getSmestajByUser(user);
    	GetSmestajForUserResponse response = objectFactory.createGetSmestajForUserResponse();
    	for(Smestaj s: smestajs) {
    		SmestajWS smestajWS = objectFactory.createSmestajWS();
    		mapper.map(s, smestajWS);
    		response.getSmestajs().add(smestajWS);
    	}
    	
    	return response;
    }
}
