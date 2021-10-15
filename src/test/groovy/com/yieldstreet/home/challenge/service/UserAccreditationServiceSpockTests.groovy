package com.yieldstreet.home.challenge

import spock.lang.Specification
import spock.lang.Shared
import com.yieldstreet.home.challenge.service.DocumentService
import com.yieldstreet.home.challenge.service.UserAccreditationService
import org.springframework.beans.factory.annotation.Autowired
import com.yieldstreet.home.challenge.model.AccreditationProof
import com.yieldstreet.home.challenge.model.Document
import org.springframework.boot.test.context.SpringBootTest
import org.spockframework.spring.SpringBean
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration
class UserAccreditationServiceSpockTests extends Specification {

	@SpringBean
    DocumentService documentService = Mock()
    
	@Autowired
    UserAccreditationService userAccreditationService
	
	
	def 'should call document saving method twice'() {
		given:
			def user = "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V"
			def doc = new Document()
			doc.setContent("ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==")
			doc.setMimeType("application/pdf")
			doc.setName("2021.pdf")
			def doc2 = new Document()
			doc2.setContent("BLOexcA8qIjogWyJzcmMkKiOwsCvBLAqRTYcdrtTy==")
			doc2.setMimeType("image/png")
			doc2.setName("2020.png")
			def proof = new AccreditationProof()
			proof.setAccreditationType("BY_INCOME")
			proof.setDocuments(Arrays.asList(doc,doc2))
		when:
			userAccreditationService.verify(proof,user)
	 
		 then:
			 2 *  documentService.saveDocument(_,_)
	}
	
	
	
	def 'should return a boolean even when called with no docs'() {
		given:
			def user = "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V"
			
			def proof = new AccreditationProof()
			proof.setAccreditationType("BY_INCOME")
			proof.setDocuments(new ArrayList<Document>())
		expect:
			userAccreditationService.verify(proof,user) instanceof Boolean

	}
}