package org.intech.j2ee.beans;

import java.io.Serializable;

public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String 	mMessage;

	public Report(String message) {
		mMessage = message;
	}

	public String getMessage() {
		return mMessage;
	}

}
