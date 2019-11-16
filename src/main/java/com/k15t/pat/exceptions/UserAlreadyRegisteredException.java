package com.k15t.pat.exceptions;
/**
 * If user is trying to register again, this exception is thrown.
 * @author pythonprojects
 *
 */
public class UserAlreadyRegisteredException extends Exception {

	public UserAlreadyRegisteredException(String message) {
		super(message);
	}


	private static final long serialVersionUID = 1L;  

}
