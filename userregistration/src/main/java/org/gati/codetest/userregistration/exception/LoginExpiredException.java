package org.gati.codetest.userregistration.exception;

public class LoginExpiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2606433006415486880L;
	
	public LoginExpiredException(String userdetail){
		super(userdetail);
	}

}
