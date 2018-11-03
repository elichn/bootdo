package com.bootdo.common.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: SecuityConfig</p>
 * <p>Description: SecuityConfig</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@Configuration
public class SecuityConfig {


}
