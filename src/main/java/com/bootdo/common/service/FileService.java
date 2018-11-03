package com.bootdo.common.service;

import com.bootdo.common.domain.FileDO;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: FileService</p>
 * <p>Description: 文件上传 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface FileService {

    FileDO get(Long id);

    List<FileDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FileDO sysFile);

    int update(FileDO sysFile);

    int remove(Long id);

    int batchRemove(Long[] ids);

    /**
     * isExist 判断一个文件是否存在
     *
     * @param url FileDO中存的路径
     * @return Boolean
     */
    Boolean isExist(String url);
}
