package com.unity.authentication.manager.config;

import com.unity.authentication.manager.filter.ModifyContentTypeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器的配置类，实现自定义过滤器的实例化和过滤器的注册
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<ModifyContentTypeFilter> modifyContentTypeFilter() {
        FilterRegistrationBean<ModifyContentTypeFilter> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new ModifyContentTypeFilter());
        registrationBean.addUrlPatterns("/xml/*");
        return registrationBean;
    }
}
