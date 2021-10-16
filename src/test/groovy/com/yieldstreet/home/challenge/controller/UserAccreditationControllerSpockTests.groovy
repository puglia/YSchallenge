package com.yieldstreet.home.challenge.controller

import spock.lang.Specification
import org.springframework.test.context.ContextConfiguration
import com.yieldstreet.home.challenge.service.DocumentService
import com.yieldstreet.home.challenge.service.UserAccreditationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.spockframework.spring.SpringBean

import org.springframework.boot.test.context.SpringBootTest

import com.yieldstreet.home.challenge.controller.UserAccreditationController
import com.yieldstreet.home.challenge.model.AccreditationProof
import com.yieldstreet.home.challenge.model.Document
import com.yieldstreet.home.challenge.util.FileManagementUtils

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.test.context.ContextConfiguration

//@WebMvcTest(UserAccreditationController)
@ContextConfiguration 
@SpringBootTest
@AutoConfigureMockMvc 
class UserAccreditationControllerSpockTests extends Specification {

	
	@Autowired
	MockMvc mockMvc
	
	@Autowired
	DocumentService documentService
	
	def doc1,doc2
	
	def setup() {
		doc1 = [ name: "2019.jpg", mime_type: "image/jpg", user_id: "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V", content:"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg=="]
		doc2 =	[ name: "2018.pdf",mime_type: "application/pdf",  user_id: "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V", content:"91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgoi=="]
	}
	
	//TODO move this payload to a file
	def "should save the documents after receiving a POST"() {
		given: "a well formed request containing 2 documents"
		def requestBody = """ {
						 "user_id": "$doc1.user_id",
						 "payload": {
							 "accreditation_type": "BY_INCOME",
							 "documents": [{
								 "name": "$doc1.name",
								 "mime_type": "$doc1.mime_type",
								 "content": "$doc1.content"
								 },{
								 "name": "$doc2.name",
								 "mime_type": "$doc2.mime_type",
								 "content": "$doc2.content"
								 }
							 ]
						 }
						}"""
		when:
			def response = mockMvc.perform(post('/user/accreditation').contentType("application/json").content(requestBody))
								
		then:
			response.andExpect(status().isOk())
	}
	
	//TODO move this payload to a file
	def "should return bad request when receive malformed input"() {
		given: "a malformed input"
		def malformedRequest = """ {
						 "user_id": "$doc1.user_id",
						 "payload": {
							 "accreditation_type": "OTHER",
							 "documents": [{
								 "name": "$doc1.name"
								 }
							 ]
						 }
						}"""
		when:
			def response = mockMvc.perform(post('/user/accreditation').contentType("application/json").content(malformedRequest))
								
		then:
			response.andExpect(status().isBadRequest())
	}
	
	def cleanup() {
		FileManagementUtils.deleteFile(documentService.getBasepath() + "\\$doc1.user_id\\$doc1.name" )
		FileManagementUtils.deleteFile(documentService.getBasepath() + "\\$doc2.user_id\\$doc2.name" )
		
	}
	
}