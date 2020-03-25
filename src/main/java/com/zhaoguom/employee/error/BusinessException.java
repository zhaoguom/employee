package com.zhaoguom.employee.error;

public class BusinessException extends Exception implements CommonError{

	private static final long serialVersionUID = -2118258785599507110L;
	private CommonError commonError;
	
	public BusinessException(CommonError commonError) {
		super();
		this.commonError = commonError;
	}
	
	public BusinessException(CommonError commonError, String errorMessage) {
		super();
		this.commonError = commonError;
		this.commonError.setErrorMessage(errorMessage);
	}
	
	@Override
	public int getErrorCode() {
		return this.commonError.getErrorCode();
	}

	@Override
	public String getErrorMessage() {
		return this.commonError.getErrorMessage();
	}

	@Override
	public CommonError setErrorMessage(String message) {
		// TODO Auto-generated method stub
		this.commonError.setErrorMessage(message);
		return this;
	}
	
}
