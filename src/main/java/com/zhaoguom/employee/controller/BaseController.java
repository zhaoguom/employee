package com.zhaoguom.employee.controller;


import com.zhaoguom.employee.error.BusinessErrorEnum;
import com.zhaoguom.employee.error.BusinessException;
import com.zhaoguom.employee.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    //定义ExceptionHandler解决未被Controller吸收的Exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrorMessage());
        } else{
            responseData.put("errCode", BusinessErrorEnum.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errMsg", BusinessErrorEnum.UNKNOWN_ERROR.getErrorMessage());
        }
        return CommonReturnType.create(responseData, "fail");
    }
}
