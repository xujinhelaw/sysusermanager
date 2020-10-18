package com.unity.authentication.manager.handler;

import com.unity.authentication.manager.handler.exception.UamException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

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
        map.put("errorMsg","System Error!");
        return map;
    }
}
