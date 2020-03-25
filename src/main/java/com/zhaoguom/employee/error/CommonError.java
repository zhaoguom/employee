package com.zhaoguom.employee.error;

public interface CommonError {
	public int getErrorCode();
	public String getErrorMessage();
	public CommonError setErrorMessage(String message);
}
