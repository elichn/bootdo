package com.bootdo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>Title: WebConfigurer</p>
 * <p>Description: WebConfigurer</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Component
class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private BootdoConfig bootdoConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file:///" + bootdoConfig.getUploadPath());
    }

}