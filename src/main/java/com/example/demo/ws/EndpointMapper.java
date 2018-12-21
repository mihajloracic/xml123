package com.example.demo.ws;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import com.example.demo.model.User;

import rs.ac.uns.ftn.agenti.ObjectFactory;
import rs.ac.uns.ftn.agenti.UserWS;

public class EndpointMapper {
    DozerBeanMapper mapper = new DozerBeanMapper();
    ObjectFactory objectFactory = new ObjectFactory();
    BeanMappingBuilder builder;
    
    public EndpointMapper(Class a,Class b) {
    	builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(User.class, UserWS.class);
            }
            
        };
        List<a> data = new ArrayList();
        mapper.addMapping(builder);
    }
}
