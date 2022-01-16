package com.unity.authentication.manager.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Slf4j
public class MessageUtil {

    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    // 无法通过自动注入MessageSource的时候，可以使用下面这个方法
    public static String getMessage(String key, Object[] params) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames("/i18n/message");//这里配置就不需要在配置application.yml

        String message = "";

        try {
            Locale locale = LocaleContextHolder.getLocale();
            message = messageSource.getMessage(key, params, locale);
        } catch (NoSuchMessageException exception) {
            log.error("parse message error!");
        }
        return message;
    }
}
