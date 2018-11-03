/**
 *
 */
package com.bootdo.common.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: GeneratorService</p>
 * <p>Description: 代码生成 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface GeneratorService {
    
    List<Map<String, Object>> list();

    byte[] generatorCode(String[] tableNames);
}
