package com.bootdo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Title: BootdoConfig</p>
 * <p>Description: BootdoConfig</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Component
@ConfigurationProperties(prefix = "bootdo")
public class BootdoConfig {

    /**
     * 上传路径
     */
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
