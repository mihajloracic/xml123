package com.example.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import javassist.NotFoundException;
import rs.ac.uns.ftn.agenti.LoginAgentRequest;
import rs.ac.uns.ftn.agenti.LoginAgentResponse;
import rs.ac.uns.ftn.agenti.ObjectFactory;
import rs.ac.uns.ftn.agenti.UserWS;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

@Endpoint
public class UserEndpoint extends EndpointMapper{
    public static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agenti";
    
    @Autowired
    UserService userService;
    
    
    public UserEndpoint() {
    	super(User.class, UserWS.class);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginAgentRequest")
    @ResponsePayload
    public LoginAgentResponse login(@RequestPayload LoginAgentRequest request) throws NotFoundException {
    	User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
    	LoginAgentResponse reposnse = new LoginAgentResponse();
    	UserWS u = objectFactory.createUserWS();
    	mapper.map(user, u);    	
    	reposnse.setUserWS(u);
    	return reposnse;
    }
}
