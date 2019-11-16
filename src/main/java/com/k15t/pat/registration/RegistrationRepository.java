package com.k15t.pat.registration;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.k15t.pat.exceptions.UserAlreadyRegisteredException;
import com.k15t.pat.exceptions.UserNotFoundException;
/**
 * DB Repository to Get and Save Registration.
 * @author pythonprojects
 *
 */
@Component
public class RegistrationRepository { 

	ConcurrentHashMap<String, Registration> patStore= new ConcurrentHashMap<String, Registration>(); 
	
	public Registration save(Registration registration) throws UserAlreadyRegisteredException {
		if(patStore.contains(registration))
			throw new UserAlreadyRegisteredException(String.format("User already exists : %s", registration.getUser()));
		patStore.put(registration.getUser(), registration);
		return patStore.get(registration.getUser());
	}

	public Registration getUser(String user) throws UserNotFoundException {
		if(this.containsUser(user))
			return patStore.get(user);
		else throw new  UserNotFoundException(String.format("User not found : %s",user));
	}
	
	public boolean containsUser(String user) {
		return patStore.containsKey(user);
	}

	public Registration update(Registration registration) throws UserNotFoundException {
		if(patStore.containsKey(registration.getUser()))
			return patStore.put(registration.getUser(), registration);
		throw  new  UserNotFoundException(String.format("User not found : %s",registration.getUser()));
	}
	
	public Registration delete(String user) throws UserNotFoundException {
		if(patStore.containsKey(user))
			return patStore.remove(user);
		throw  new  UserNotFoundException(String.format("User not found : %s",user));
	}
}
