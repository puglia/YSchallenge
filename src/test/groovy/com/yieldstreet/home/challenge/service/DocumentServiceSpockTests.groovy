package com.yieldstreet.home.challenge

import spock.lang.Specification
import spock.lang.Shared
import com.yieldstreet.home.challenge.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import com.yieldstreet.home.challenge.model.Document
import org.springframework.boot.test.context.SpringBootTest
import org.spockframework.spring.SpringBean
import org.springframework.test.context.ContextConfiguration

import com.yieldstreet.home.challenge.util.FileManagementUtils

@SpringBootTest
@ContextConfiguration
class DocumentServiceSpockTests extends Specification {

    
	@Autowired
    DocumentService documentService
	
	def fullpath
	def user
	def docName
	
	def setup() {
		user = "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpD2X"
		docName = "2021.pdf"
		fullpath = documentService.getBasepath() + "\\" + user + "\\" + docName
	}
	
	def 'should create the file'() {
		given: 'a document'
			def doc = new Document()
			doc.setContent("ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==")
			doc.setMimeType("application/pdf")
			doc.setName(docName)
		when: 'document is saved'
			documentService.saveDocument(doc,user);
	 
		then: 'document should be in the default path'
			FileManagementUtils.checkFileExists(fullpath) == true
	}
	
	
	def cleanup() {
		FileManagementUtils.deleteFile(fullpath)
	}
	
	
}