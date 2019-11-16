package com.k15t.pat.registration.register;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.k15t.pat.exceptions.UserAlreadyRegisteredException;
import com.k15t.pat.exceptions.UserNotFoundException;
import com.k15t.pat.registration.Registration;
import com.k15t.pat.registration.RegistrationRepository;

public class RegistrationRepositoryTest {

	RegistrationRepository registrationService; 
		
	@Before
	public void before() {
		registrationService=new RegistrationRepository();
		
	}
	@Test
	public void testSave() throws UserAlreadyRegisteredException {
		Registration registration=createUser("testUser1","sonu.yasir1@gmail.com","testAddress1","password1","00966565656561");
		Registration theReturnedRegistration = registrationService.save(registration);
		assertEquals("User names must match",theReturnedRegistration.getUser(), registration.getUser());
		assertEquals("Email names must match", theReturnedRegistration.getEmail(), registration.getEmail() );
		assertEquals("Address names must match", theReturnedRegistration.getAddress(), registration.getAddress());
		assertEquals( "Password names must match", theReturnedRegistration.getPassword(), registration.getPassword());
		assertEquals("Phone names must match", theReturnedRegistration.getPhone(), registration.getPhone());
	}

	@Test
	public void testContainsUser() throws UserAlreadyRegisteredException {
		Registration registration=createUser("testUser2","sonu.yasir2@gmail.com","testAddress2","password2","00966565656562");
	    registrationService.save(registration);
		assertTrue(registrationService.containsUser(registration.getUser()));
	}

	@Test
	public void testDoNotContainsUser() throws UserAlreadyRegisteredException {
		
		assertTrue(!registrationService.containsUser("someNonExistentUser"));
	}
	
	@Test(expected = UserAlreadyRegisteredException.class)
	public void testSaveWithException() throws UserAlreadyRegisteredException {
		Registration registration=createUser("testUser3","sonu.yasir3@gmail.com","testAddress3","password3","00966565656563");
		registrationService.save(registration);
		registrationService.save(registration);
	}

	@Test
	public void testUpdateRegistration() throws UserAlreadyRegisteredException, UserNotFoundException {
		Registration registration=createUser("testUser3","sonu.yasir3@gmail.com","testAddress3","password3","00966565656563");
		registrationService.save(registration);
		registration=registrationService.getUser(registration.getUser());
		String updateEmail="changed@yahoo.com";
		registration.setEmail(updateEmail);
		Registration updated = registrationService.update(registration);
		assertEquals(updated.getEmail(), updateEmail);
		
	}
	

	@Test(expected = UserNotFoundException.class)
	public void testDeleteRegistration() throws UserNotFoundException, UserAlreadyRegisteredException {
		Registration registration=createUser("testUser3","sonu.yasir3@gmail.com","testAddress3","password3","00966565656563");
		registrationService.save(registration);
		registration=registrationService.getUser(registration.getUser());
		registrationService.delete(registration.getUser());
		registrationService.getUser(registration.getUser());
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testDeleteExceptionRegistration() throws UserNotFoundException, UserAlreadyRegisteredException {
		Registration registration=createUser("testUser4","sonu.yasir3@gmail.com","testAddress3","password3","00966565656563");
		registrationService.delete(registration.getUser());
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testUpdateExceptionRegistration() throws UserNotFoundException, UserAlreadyRegisteredException {
		Registration registration=createUser("testUser5","sonu.yasir3@gmail.com","testAddress3","password3","00966565656563");
		registrationService.update(registration);
		
	}
	private Registration createUser(String userName, String email, 
			String address,	String password, String mobile) {
		Registration registration = new Registration();
		registration.setUser(userName);
		registration.setEmail(email);
		registration.setAddress(address);
		registration.setPassword(password);
		registration.setPhone(mobile);
		return registration;
	}
}
