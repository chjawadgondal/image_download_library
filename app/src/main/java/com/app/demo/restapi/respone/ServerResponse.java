package com.app.demo.restapi.respone;

import java.io.Serializable;

/**
 * This is Generic Super class for all type of
 * Rest Api response classes.
 */
public class ServerResponse implements Serializable {

	private int requestCode;
	private Exception Exception;

	public Exception getException() {
		return Exception;
	}

	public void setException(Exception exception) {
		Exception = exception;
	}


	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}

}
