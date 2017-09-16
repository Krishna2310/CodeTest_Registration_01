package org.gati.codetest.userregistration.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7767069692461544135L;

	public DataNotFoundException(String userdetail){
		super(userdetail);
	}
}
