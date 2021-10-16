package com.yieldstreet.home.challenge.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yieldstreet.home.challenge.model.Document;
import com.yieldstreet.home.challenge.util.FileManagementUtils;

@Service
public class DocumentService {

	
	@Value("${custom.basepath.default}")
	private String basepath;

	public boolean saveDocument(Document doc, String user) throws FileNotFoundException, IOException {
		validateDocument(doc);
		
		File target = FileManagementUtils.findOrCreateFile(basepath + "\\" + user, doc.getName());
		byte[] decoded = Base64.getDecoder().decode(doc.getContent());
		try (OutputStream stream = new FileOutputStream(target)) {
			stream.write(decoded);
			stream.close();
		}
		
		return true;
	}
	
	public String getBasepath() {
		return this.basepath;
	}
	
	private void validateDocument(Document doc) {
		if(!StringUtils.hasText(doc.getContent()))
			throw new IllegalArgumentException("File content not found.");
		if(!StringUtils.hasText(doc.getName()))
			throw new IllegalArgumentException("File name must be informed");
	}
	
	
}
