package com.bby.hotel.base;

import com.bby.hotel.exception.BusinessException;
import com.bby.hotel.exception.EmErrorMsg;
import com.bby.hotel.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public static final String  CONSUMES_TYPE = "application/x-www-form-urlencoded";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handlerException(HttpServletRequest request, Exception ex){
        if(ex instanceof BusinessException){
            BusinessException exception = (BusinessException) ex;
            return ResponseUtils.getResponseFail("errCode:"+exception.getErrorCode()+",errMsg:"+exception.getErrorMsg());
        }
        return ResponseUtils.getResponseFail("errCode:"+ EmErrorMsg.UNKNOWER_ERROR.getErrorCode()+
                ",errMsg:"+EmErrorMsg.UNKNOWER_ERROR.getErrorMsg());

    }

}
