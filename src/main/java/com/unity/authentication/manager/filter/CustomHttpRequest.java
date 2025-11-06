package com.unity.authentication.manager.filter;

import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 通过继承HttpServletRequestWrapper类进行ContentTypeD额改写
 */
public class CustomHttpRequest extends HttpServletRequestWrapper {
    public CustomHttpRequest(HttpServletRequest request) {
        super(request);
    }

    public String getContentType() {
        return MediaType.APPLICATION_XML_VALUE;
    }
}
