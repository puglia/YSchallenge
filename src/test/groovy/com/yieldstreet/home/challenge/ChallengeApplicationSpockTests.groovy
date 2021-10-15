package com.yieldstreet.home.challenge

import spock.lang.Specification
import javax.inject.Inject
import com.yieldstreet.home.challenge.service.DocumentService
import com.yieldstreet.home.challenge.service.UserAccreditationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.yieldstreet.home.challenge.controller.UserAccreditationController
import com.yieldstreet.home.challenge.model.AccreditationProof
import com.yieldstreet.home.challenge.model.Document

@SpringBootTest
class ChallengeApplicationSpockTests extends Specification {

	@Autowired
	UserAccreditationController userAccreditationController
	
	@Autowired
	DocumentService documentService
	
	@Autowired
	UserAccreditationService userAccreditationService
	
	def "userAccreditationController created"() {
		expect:
		userAccreditationController
	}
	
	def "documentService created"() {
		expect:
		documentService
	}
	
	def "userAccreditationService created"() {
		expect:
		userAccreditationService
	}
}