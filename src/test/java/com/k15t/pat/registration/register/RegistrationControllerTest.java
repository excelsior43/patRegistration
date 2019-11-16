package com.k15t.pat.registration.register;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.k15t.pat.ApplicationBootstrap;
import com.k15t.pat.registration.Registration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBootstrap.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")

public class RegistrationControllerTest {

	private RestTemplate restTemplate = new TestRestTemplate();
	@Before
	public void before(){	    
	}
	@Test
	public void testRegistration() throws Exception {
		 ResponseEntity<String> template = restTemplate
				.getForEntity("http://localhost:9000/rest/registration/igugj" ,
						String.class);		
		assertTrue(template.getStatusCode().is4xxClientError());
	}

	@Test
	public void testSaveRegistration() throws Exception {
		String userName="testSaveUser";
		    restTemplate.postForEntity("http://localhost:9000/rest/registration", this.createUser(userName),null);
		    ResponseEntity<Registration> getResponseEntity = restTemplate
					.getForEntity("http://localhost:9000/rest/registration/" + userName, Registration.class);
			Registration registration = getResponseEntity.getBody();
			assertEquals(registration.getUser(), userName);
	}
    
	@Test
	public void testGetRegistration() throws Exception {
		String userName="testGetUser";
		ResponseEntity<Registration> responseEntity =  restTemplate.postForEntity(
	    		"http://localhost:9000/rest/registration", this.createUser(userName),null);	
		responseEntity = restTemplate
				.getForEntity("http://localhost:9000/rest/registration/" + userName, Registration.class);
		Registration registration = responseEntity.getBody();
		assertEquals(registration.getUser(), userName);

	}
/**
 * API stops duplicate users to be inserted.
 * @throws Exception
 */
	@Test
	public void testSaveRegistrationTwice() throws Exception {
		String userName="testSaveUser";
		    restTemplate.postForEntity("http://localhost:9000/rest/registration", this.createUser(userName),null);
		    ResponseEntity<Registration> responseEntity = restTemplate
		    		.postForEntity("http://localhost:9000/rest/registration", 
		    				this.createUser(userName),null);
		    assertTrue(responseEntity.getStatusCode().is4xxClientError());
			
	}
	
	private Registration createUser(String userName) {
		Registration registration = new Registration();
		registration.setUser(userName);
		registration.setEmail("sonu.yasir@gmail.com");
		registration.setAddress("testAddress");
		registration.setPassword("password");
		registration.setPhone("00966565656565");
		return registration;
	}
	
	@Test
	public void testUpdateRegistration() throws Exception {
		String userName="testUpdateUser";
		 	//create a fresh user
		    restTemplate.postForEntity("http://localhost:9000/rest/registration", this.createUser(userName),null);
		    // get it back
		    ResponseEntity<Registration> getResponseEntity = restTemplate
					.getForEntity("http://localhost:9000/rest/registration/" + userName, Registration.class);
		    // update registration
		    Registration toBeUpdated = getResponseEntity.getBody();
		    toBeUpdated.setEmail("pat@mail.yahoo.com");
		    restTemplate.
		    		put("http://localhost:9000/rest/registration/" + userName, getResponseEntity.getBody());
		     // get it back
			 ResponseEntity<Registration> returnedResponseEntity = restTemplate
						.getForEntity("http://localhost:9000/rest/registration/" + userName, Registration.class);
			Registration registration = returnedResponseEntity.getBody();
			assertEquals(registration.getEmail(), toBeUpdated.getEmail());
	}
	
	@Test
	public void testDeleteRegistration() throws Exception {
		String userName="testUpdateUser";
		 	//create a fresh user
		    restTemplate.postForEntity("http://localhost:9000/rest/registration", this.createUser(userName),null);
		    
		    //delete registration
		    restTemplate.delete("http://localhost:9000/rest/registration"+userName);
		    // get it back
		    ResponseEntity<String> getResponseEntity = restTemplate
					.getForEntity("http://localhost:9000/rest/registration/" + userName, String.class);
		    // non-existent registration
		    assertTrue(getResponseEntity.getStatusCode().is2xxSuccessful());
	}
}
