package com.k15t.pat.registration.register;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.k15t.pat.registration.Registration;
/**
 * This test aims to equate two same user but different data.
 * 
 * @author pythonprojects
 *
 */
public class RegistrationTest {

	@Test
	public void testEqualsObject() {
		Registration user1=createUser("TestUser", "a.b@gmail.com", 
				"Address \n, ZIP : 1411",	"password","+966 565656565" ); 
		Registration user2=createUser("TestUser", "a.b@yahoo.co.in", 
				"Some other address : 999",	"XXXXXXXXX","+1 999999999" );
		Registration user3=createUser("TestUser1", "a.b@yahoo.co.in", 
				"Some other address : 999",	"XXXXXXXXX","+1 999999999" );
		Registration user4=createUser(null, "a.b@yahoo.co.in", 
				"Some other address : 999",	"XXXXXXXXX","+1 999999999" );
		assertEquals(user1, user1);
		assertEquals(user1, user2);
		assertNotEquals(user1, user3);
		assertNotEquals(user1, null);
		assertNotEquals(user4, user3);
	}

	@Test
	public void testHashCodeObject() {
		Registration user1=createUser("TestUser", "a.b@gmail.com", 
				"Address \n, ZIP : 1411",	"password","+966 565656565" ); 
		Registration user2=createUser("TestUser", "a.b@yahoo.co.in", 
				"Some other address : 999",	"XXXXXXXXX","+1 999999999" );
		Set<Registration> set =new HashSet<Registration>();
		set.add(user1);
		set.add(user2);
		assertEquals(set.size(), 1);
	}
	
	@Test
	public void testToString() {
		Registration user1=createUser("TestUser", "a.b@gmail.com", 
				"Address \n, ZIP : 1411",	"password","+966 565656565" ); 
		
		assertTrue(user1.toString().contains(user1.getUser()));
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
