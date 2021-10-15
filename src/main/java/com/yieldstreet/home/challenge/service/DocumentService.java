package com.yieldstreet.home.challenge.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yieldstreet.home.challenge.model.Document;
import com.yieldstreet.home.challenge.util.FileManagementUtils;

@Service
public class DocumentService {

	
	@Value("${custom.basepath.default}")
	private String basepath;

	public boolean saveDocument(Document doc, String user) throws FileNotFoundException, IOException {
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
	
	
}
