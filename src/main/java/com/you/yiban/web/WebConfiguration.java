package com.you.yiban.web;

import com.you.yiban.filter.AllowOriginFilter;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author w.z
 * @date 2019/8/13 16:08
 */

@Configuration
/*@EnableWebMvc
@ComponentScan("com.you.yiban")
extends WebMvcConfigurerAdapter
*/
public class WebConfiguration {
    
    /**
     * 跨域Fileter注入
     *
     * @return 跨域注册Bean对象
     */
    @Bean
    public FilterRegistrationBean  registerFilter()  {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new AllowOriginFilter());
        return bean;
    }
}
