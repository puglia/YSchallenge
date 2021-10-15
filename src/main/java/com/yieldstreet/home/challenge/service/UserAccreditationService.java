package com.yieldstreet.home.challenge.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yieldstreet.home.challenge.model.AccreditationProof;
import com.yieldstreet.home.challenge.model.Document;

@Service
public class UserAccreditationService {

	@Inject
	DocumentService documentService;
	
	public boolean verify(AccreditationProof proof, String user) throws FileNotFoundException, IOException {
		for(Document doc: proof.getDocuments())
			documentService.saveDocument(doc,user);
		
		return Math.random() > 0.49;
		
	}
	
	
}
