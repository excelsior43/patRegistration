package com.k15t.pat.exceptions;

/**
 * Triggered when a nen-existent user is queried by the frontend.
 * 
 * @author pythonprojects
 *
 */
public class UserNotFoundException extends Exception{

	public UserNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -5041022413337556328L;

}
