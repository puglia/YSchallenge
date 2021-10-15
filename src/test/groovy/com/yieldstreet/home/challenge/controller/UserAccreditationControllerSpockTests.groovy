package com.yieldstreet.home.challenge.controller

import spock.lang.Specification
import org.springframework.test.context.ContextConfiguration
import com.yieldstreet.home.challenge.service.DocumentService
import com.yieldstreet.home.challenge.service.UserAccreditationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.spockframework.spring.SpringBean

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import com.yieldstreet.home.challenge.controller.UserAccreditationController
import com.yieldstreet.home.challenge.config.ApplicationConfiguration
import com.yieldstreet.home.challenge.model.AccreditationProof
import com.yieldstreet.home.challenge.model.Document

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(UserAccreditationController)
@AutoConfigureMockMvc
class UserAccreditationControllerSpockTests extends Specification {

	
	@Autowired
	MockMvc mockMvc
	
	@SpringBean
	UserAccreditationService userAccreditationService = Mock()
	
	
	def "should save the documents and receiving a POST"() {
		given: "a well formed request containing 2 documents"
		def requestBody = ''' {
						 "user_id": "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V",
						 "payload": {
							 "accreditation_type": "BY_INCOME",
							 "documents": [{
								 "name": "2018.pdf",
								 "mime_type": "application/pdf",
								 "content": "ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg=="
								 },{
								 "name": "2019.jpg",
								 "mime_type": "image/jpeg",
								 "content": "91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgoi=="
								 }
							 ]
						 }
						}'''
		when:
			def response = mockMvc.perform(post('/user/accreditation').contentType("application/json").content(requestBody))
								
		then:
			response //response.andExpect(status().isOk())
	}
	
}