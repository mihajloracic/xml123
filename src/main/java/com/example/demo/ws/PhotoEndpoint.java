package com.example.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.SmestajPhoto;
import com.example.demo.repository.SmestajPhotoRepository;
import com.example.demo.service.SmestajPhotoService;
import com.example.demo.service.SmestajService;

import rs.ac.uns.ftn.agenti.CreatePhotoRequest;
import rs.ac.uns.ftn.agenti.CreatePhotoResponse;
import rs.ac.uns.ftn.agenti.DeletePhotoRequest;
import rs.ac.uns.ftn.agenti.DeletePhotoResponse;
import rs.ac.uns.ftn.agenti.GetPhotosForSmestajResponse;
import rs.ac.uns.ftn.agenti.GetPhotosForSmestajReuqest;
import rs.ac.uns.ftn.agenti.PhotoWS;

@Endpoint
public class PhotoEndpoint extends EndpointMapper{
	
	public static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agenti";
	
	@Autowired
	SmestajService smestajService;
	
	@Autowired
	SmestajPhotoService smestajPhotoService;
	
	@Autowired
	SmestajPhotoRepository smestajPhotoRepository;
	
	public PhotoEndpoint() {
		super(SmestajPhoto.class,PhotoWS.class);
	}
	
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPhotoRequest")
    @ResponsePayload
	public CreatePhotoResponse createPhoto(@RequestPayload CreatePhotoRequest request) {
        SmestajPhoto smestajPhoto = new SmestajPhoto();
        smestajPhoto.setPath(request.getPhoto());
        smestajPhoto.setSmestaj(smestajService.findBySmestajId(request.getSmestajId()));
        smestajPhoto = smestajPhotoService.saveSmestajPhoto(smestajPhoto);
        PhotoWS photoWS = objectFactory.createPhotoWS();
        mapper.map(smestajPhoto, photoWS);
        CreatePhotoResponse reponse = objectFactory.createCreatePhotoResponse();
        photoWS.setSmestajId(request.getSmestajId());
        reponse.setPhoto(photoWS);
		return reponse;
	}
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePhotoRequest")
    @ResponsePayload
	public DeletePhotoResponse deletePhoto(@RequestPayload DeletePhotoRequest request) {
        smestajPhotoRepository.deleteById(request.getId());
		DeletePhotoResponse reponse = objectFactory.createDeletePhotoResponse();
        return reponse;
	}
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPhotosForSmestajRequest")
    @ResponsePayload
    public GetPhotosForSmestajResponse getPhotosForSmestaj(@RequestPayload GetPhotosForSmestajReuqest request){
    	return null;
    }
	
}
