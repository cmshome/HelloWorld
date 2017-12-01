package com.lxk.http;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class ClientException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4638148560041331949L;
	
	public enum ErrorType {
		NotLogin,
		NetError,
		ProtocolError,
		UnsupportedOperation,
		ClientError,
		Other, 
	}
	
	private ErrorType errorType;

	public ClientException(ErrorType errorType) {
		super();
		this.errorType = errorType;
	}
	
	public ClientException(ErrorType errorType, String msg) {
		super(msg);
		this.errorType = errorType;
	}
	
	public ClientException(ErrorType errorType, Exception ex) {
		super(ex);
		this.errorType = errorType;
	}
	
	public ClientException(ErrorType errorType, String msg, Exception ex) {
		super(msg, ex);
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}
	
	public static ClientException getClientException(Exception ex) {
		if (ex instanceof ClientProtocolException) {
			return new ClientException(ErrorType.ProtocolError, ex);
		}
		if (ex instanceof UnsupportedOperationException) {
			return new ClientException(ErrorType.UnsupportedOperation, ex);
		}
		if (ex instanceof IOException) {
			return new ClientException(ErrorType.NetError, ex);
		}
		return new ClientException(ErrorType.Other, ex);
	}
	
}
