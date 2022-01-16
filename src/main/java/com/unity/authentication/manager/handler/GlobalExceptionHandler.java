package com.unity.authentication.manager.handler;

import com.unity.authentication.manager.handler.exception.UamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(UamException.class)
    @ResponseBody
    public Map<String, Object> handlerUamException(UamException ex) {
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode","201");
        map.put("errorMsg","Uam异常");
        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception ex) {
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode","1000");
        map.put("errorMsg",ex.getCause());
        return map;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> handlerException(MethodArgumentNotValidException ex) {
        Map<String, Object> result = new HashMap<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        errors.forEach(error -> {
            result.put("errorCode", "6001");
            result.put("errorMsg", messageSource.getMessage(error.getDefaultMessage(), null, LocaleContextHolder.getLocale()));//调用messageSource.getMessage来实现国际化
        });
        return result;
    }
}
