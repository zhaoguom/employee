package com.zhaoguom.employee.error;

public enum BusinessErrorEnum implements CommonError{
	
	PARAM_NOT_VALID(100001, "Params not valid"),
	UNKNOWN_ERROR(100002, "Unknown internal error"),
	
	USER_NOT_EXIST(200001, "User does not exist"),
	USER_LOGIN_FAIL(200002, "Telephone or password incorrect"),
	;
	
	private int errorCode;
	private String errorMessage;

	private BusinessErrorEnum(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
 
	@Override
	public int getErrorCode() {
		// TODO Auto-generated method stub
		return this.errorCode;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}

	@Override
	public CommonError setErrorMessage(String message) {
		// TODO Auto-generated method stub
		this.errorMessage = message;
		return this;
	}

}
