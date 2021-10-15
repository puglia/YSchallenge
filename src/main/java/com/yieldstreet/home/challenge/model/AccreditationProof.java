package com.yieldstreet.home.challenge.model;

import java.util.List;

import com.yieldstreet.home.challenge.enums.AccreditationType;

public class AccreditationProof {
	private Long id;
	private AccreditationType accreditationType;
	private List<Document> documents;

	public AccreditationType getAccreditationType() {
		return accreditationType;
	}

	public void setAccreditationType(AccreditationType accreditationType) {
		this.accreditationType = accreditationType;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
