package com.bootdo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>Title: ApplicationContextRegister</p>
 * <p>Description: ApplicationContextRegister</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContextRegister.class);

    private static ApplicationContext APPLICATION_CONTEXT;

    /**
     * setApplicationContext 设置spring上下文
     *
     * @param applicationContext spring上下文
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.debug("ApplicationContext registed-->{}", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * getApplicationContext 获取容器
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * getBean 获取容器对象
     *
     * @param type type
     * @param <T>  <T>
     * @return <T>
     */
    public static <T> T getBean(Class<T> type) {
        return APPLICATION_CONTEXT.getBean(type);
    }
}